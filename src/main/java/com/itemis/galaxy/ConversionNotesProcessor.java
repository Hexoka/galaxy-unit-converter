package com.itemis.galaxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * The ConversionNotesProcessor processes the conversion notes of galactic
 * merchants to convert different units and numbers.
 */
public final class ConversionNotesProcessor {
	
	private final UnitConverter converter = new UnitConverter();

	/**
	 * Processes conversion notes and returns the output as a list of strings.
	 * @param notes conversion notes
	 * @return output as a list of strings
	 */
	public List<String> processNotes(List<String> notes) {
		List<String> results = new ArrayList<>();
		for(String line : notes) {
			line = line.trim();
			processLine(line).ifPresent(results::add);
		}
		return results;
	}

	/**
	 * Process a symbol definition line
	 * @param line line of the conversion notes
	 * @return true if a symbol definition was detected and processed
	 */
	private boolean processSymbol(String line) {
		String[] splitted = line.split(" ");
		if(splitted.length == 3 && splitted[1].equals("is")) {
			Optional<RomanSymbol> symbol = getSymbol(splitted[2]);
			if(symbol.isPresent()) {
				converter.setSymbolValue(splitted[0], symbol.get());
				return true;
			}
		}
		return false;
	}

	/**
	 * Get a roman symbol for its corresponding string
	 * @param symbolString roman symbol as a string
	 * @return the roman symbol or empty if the symbolString is invalid
	 */
	private Optional<RomanSymbol> getSymbol(String symbolString) {
		for(RomanSymbol symbol : RomanSymbol.values()) {
			if(symbol.name().equals(symbolString)) {
				return Optional.of(symbol);
			}
		}
		return Optional.empty();
	}

	/**
	 * Process a metal price definition line
	 * @param line line of the conversion notes
	 * @return true if a metal price definition was detected and processed
	 */
	private boolean processMetalPrice(String line) {
		String[] splitted = line.split(" is ");
		if(splitted.length != 2) {
			return false;
		}
		
		String[] price = splitted[1].split(" ");
		if(price.length == 2 && !price[1].equals("Credits")) {
			return false;
		}
		
		double totalPrice = 0.0;
		try {
			totalPrice = Double.parseDouble(price[0]);
		} catch(NumberFormatException e) {
			return false;
		}
		
		List<String> symbols = new ArrayList<>(Arrays.asList(splitted[0].split(" ")));
		String metal = symbols.remove(symbols.size() - 1);
		OptionalInt amount = converter.calculateNumber(symbols);
		if(amount.isEmpty()) {
			return false;
		}
		
		double metalPrice = totalPrice / amount.getAsInt();
		converter.setMetalPrice(metal, metalPrice);
		return true;
	}

	/**
	 * Process a number question line
	 * @param line line of the conversion notes
	 * @return response for the number question or empty if no number question was detected 
	 */
	private Optional<String> processNumberQuestion(String line) {
		if(!line.startsWith("how much is ") || !line.endsWith("?")) {
			return Optional.empty();
		}
		String symbolString = line.substring(0, line.length() - 1).replace("how much is ", "").trim();
		List<String> symbols = Arrays.asList(symbolString.split(" "));
		OptionalInt number = converter.calculateNumber(symbols);
		if(number.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(symbolString + " is " + number.getAsInt());
	}

	/**
	 * Process a price question line
	 * @param line line of the conversion notes
	 * @return response for the price question or empty if no price question was detected 
	 */
	private Optional<String> processPriceQuestion(String line) {
		if(!line.startsWith("how many Credits is ") || !line.endsWith("?")) {
			return Optional.empty();
		}
		String symbolString = line.substring(0, line.length() - 1).replace("how many Credits is ", "").trim();
		List<String> symbols = new ArrayList<>(Arrays.asList(symbolString.split(" ")));
		String metal = symbols.remove(symbols.size() - 1);
		OptionalDouble number = converter.calculatePrice(metal, symbols);
		if(number.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(symbolString + " is " + (int)number.getAsDouble() + " Credits");
	}

	/**
	 * Processes a single line of the conversion notes.
	 * @param line line of the conversion notes
	 * @return the response for the line or empty if it was a valid symbol or price definition
	 */
	private Optional<String> processLine(String line) {
		boolean processedSymbol = processSymbol(line);
		if(processedSymbol) {
			return Optional.empty();
		}
		
		boolean processedMetalPrice = processMetalPrice(line);
		if(processedMetalPrice) {
			return Optional.empty();
		}
		
		Optional<String> numberAnswer = processNumberQuestion(line);
		if(numberAnswer.isPresent()) {
			return numberAnswer;
		}
		
		Optional<String> priceAnswer = processPriceQuestion(line);
		if(priceAnswer.isPresent()) {
			return priceAnswer;
		}
		
		return Optional.of("I have no idea what you are talking about");
	}
}

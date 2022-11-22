package com.itemis.galaxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * This class can is used to convert galactic units.
 * It processes a set of conversion notes to generate a textual output of the converted units.
 */
public final class UnitConverter {
	
	private Map<String, RomanSymbol> symbolValues = new HashMap<>();
	private Map<String, Double> metalPrices = new HashMap<>();
	
	private final RomanNumberConverter romanConverter = new RomanNumberConverter();

	/**
	 * Set the corresponding roman symbol value for a galactic symbol.
	 * @param galacticSymbol galactic symbol
	 * @param romanSymbol corresponding roman symbol of the galactic symbol
	 */
	public void setSymbolValue(String galacticSymbol, RomanSymbol romanSymbol) {
		symbolValues.put(galacticSymbol, romanSymbol);
	}
	
	/**
	 * Removes the galactic symbol.
	 * @param galacticSymbol galactic symbol to remove
	 */
	public void removeSymbolValue(String galacticSymbol) {
		symbolValues.remove(galacticSymbol);
	}
	
	/**
	 * Get the corresponding roman symbol value for a galactic symbol.
	 * @param galacticSymbol galactic symbol
	 * @return roman symbol or empty if the galactic symbol is unknown
	 */
	public Optional<RomanSymbol> getSymbolValue(String galacticSymbol) {
		return Optional.ofNullable(symbolValues.get(galacticSymbol));
	}
	
	/**
	 * Set the price in credits for a metal.
	 * @param metal metal
	 * @param price price in credits
	 */
	public void setMetalPrice(String metal, double price) {
		metalPrices.put(metal, price);
	}
	
	/**
	 * Get the price in credits for a metal.
	 * @param metal metal
	 * @return price in credits or empty if the metal if unknown
	 */
	public OptionalDouble getMetalPrice(String metal) {
		if(metalPrices.containsKey(metal)) {
			return OptionalDouble.of(metalPrices.get(metal));
		} else {
			return OptionalDouble.empty();
		}
	}
	
	/**
	 * Removes the metal price.
	 * @param metal metal
	 */
	public void removeMetalPrice(String metal) {
		metalPrices.remove(metal);
	}
	
	/**
	 * Calculate the price for the amount of the specified metal according to the galactic numeral.
	 * @param metal metal
	 * @param galacticSymbols galactic numeral
	 * @return price or empty if the price can not be calculated
	 */
	public OptionalDouble calculatePrice(String metal, List<String> galacticSymbols) {
		//TODO
		return OptionalDouble.empty();
	}
	
	/**
	 * Calculate the amount for the galactic numeral.
	 * @param galacticSymbols galactic numeral
	 * @return amount or empty if the amount can not be calculated
	 */
	public OptionalInt calculateNumber(List<String> galacticSymbols) {
		List<RomanSymbol> romanSymbols = galacticSymbols.stream()
														.map(symbolValues::get)
														.filter(Objects::nonNull)
														.collect(Collectors.toList());
		
		boolean hasUnknownSymbols = romanSymbols.size() < galacticSymbols.size();
		if(hasUnknownSymbols) {
			return OptionalInt.empty();
		}
		
		return romanConverter.calculateNumber(romanSymbols);
	}
}

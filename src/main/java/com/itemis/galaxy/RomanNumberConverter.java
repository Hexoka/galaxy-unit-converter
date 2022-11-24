package com.itemis.galaxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

/**
 * This class is able to calculate the number for a given roman numeral.
 */
public final class RomanNumberConverter {

	/**
	 * Calculate the number for a roman numeral.
	 * @param romanSymbols roman numeral
	 * @return calculated number or empty if the number can not be calculated because of an invalid input
	 */
	public OptionalInt calculateNumber(List<RomanSymbol> romanSymbols) {
		if(romanSymbols.size() < 0) {
			return OptionalInt.of(0);
		}
		int totalValue = 0;
		int lastSplitIndex = 0;
		int maxValue = 1000;
		int minValue = 100;
		for(int i = 0; i < romanSymbols.size(); i++) {
			int value = romanSymbols.get(i).getValue();
			if(value < maxValue && value >= minValue) {
				OptionalInt digitValue = calculateDigitValue(romanSymbols.subList(lastSplitIndex, i));
				if(digitValue.isEmpty()) {
					return OptionalInt.empty();
				}
				maxValue /= 10;
				minValue /= 10;
				totalValue += digitValue.getAsInt();
				lastSplitIndex = i;
			} else if(value < minValue) {
				maxValue /= 10;
				minValue /= 10;
				i--;
			}
		}
		OptionalInt digitValue = calculateDigitValue(romanSymbols.subList(lastSplitIndex, romanSymbols.size()));
		if(digitValue.isEmpty()) {
			return OptionalInt.empty();
		}
		totalValue += digitValue.getAsInt();
		
		return OptionalInt.of(totalValue);
		
//		boolean valid = checkValidity(romanSymbols);
//		if(!valid) {
//			return OptionalInt.empty();
//		}
//		return calculateNumberForValid(romanSymbols);
	}
	
	private OptionalInt calculateDigitValue(List<RomanSymbol> romanSymbols) {
		System.out.print("Digit: ");
		romanSymbols.stream().map(Enum::name).forEach(System.out::print);
		System.out.println();
		
		if(romanSymbols.size() == 2) {
			if(romanSymbols.get(1).getValue() > romanSymbols.get(0).getValue()) {
				System.out.println("Subtraction: "  +romanSymbols.get(0).name() + romanSymbols.get(1).name());
				return calculateSubtraction(romanSymbols.get(0), romanSymbols.get(1));
			}
		}
		
		int value = 0;
		RomanSymbol lastSymbol = RomanSymbol.M;
		for(RomanSymbol symbol : romanSymbols) {
			if(symbol.getValue() > lastSymbol.getValue()) {
				return OptionalInt.empty();
			}
			value += symbol.getValue();
			lastSymbol = symbol;
		}
		return OptionalInt.of(value);
	}

	/**
	 * Calculate the number for a roman numeral.
	 * @param romanSymbols roman numeral (must be a valid numeral)
	 * @return calculated number or empty if the number can not be calculated because of an invalid input
	 */
	private OptionalInt calculateNumberForValid(List<RomanSymbol> romanSymbols) {
		romanSymbols = new ArrayList<>(romanSymbols);
		switch(romanSymbols.size()) {
		case 0:
			return OptionalInt.of(0);
		case 1:
			return OptionalInt.of(romanSymbols.get(0).getValue());
		}
		
		RomanSymbol first = romanSymbols.get(0);
		RomanSymbol second = romanSymbols.get(1);
		if(first.getValue() >= second.getValue()) {
			//Split the calculations after the first symbol
			romanSymbols.remove(0);
			OptionalInt valueFirst = calculateNumberForValid(List.of(first));
			OptionalInt valueWithoutFirst = calculateNumberForValid(romanSymbols);
			if(valueFirst.isPresent() && valueWithoutFirst.isPresent()) {
				int value = valueWithoutFirst.getAsInt() + valueFirst.getAsInt();
				return OptionalInt.of(value);
			} else {
				return OptionalInt.empty();
			}
		} else {
			//Split the calculations after the second symbol
			romanSymbols.remove(0);
			romanSymbols.remove(0);
			OptionalInt valueFirstSecond = calculateSubtraction(first, second);
			OptionalInt valueWithoutFirst = calculateNumberForValid(romanSymbols);
			if(valueFirstSecond.isPresent() && valueWithoutFirst.isPresent()) {
				int value = valueWithoutFirst.getAsInt() + valueFirstSecond.getAsInt();
				return OptionalInt.of(value);
			} else {
				return OptionalInt.empty();
			}
		}
	}
	
	

	private boolean checkValidity(List<RomanSymbol> romanSymbols) {
		//Check for null values
		boolean hasNullValues = romanSymbols.stream()
											.filter(Objects::isNull)
											.findAny()
											.isPresent();
		if(hasNullValues) {
			return false;
		}
		
		//Check disallowed repeats of same symbol
		int count = 0;
		RomanSymbol lastSymbol = null;
		for(RomanSymbol symbol : romanSymbols) {
			if(symbol == lastSymbol) {
				count++;
			} else {
				count = 1;
				lastSymbol = symbol;
			}
			if(count > allowedRepeats(lastSymbol)) {
				return false;
			}
		}
		
		return true;
	}



	private int allowedRepeats(RomanSymbol symbol) {
		switch(symbol) {
		case I:
		case X:
		case C:
		case M:
			return 3;
		case D:
		case L:
		case V:
		default:
			return 1;
			
		}
	}

	private OptionalInt calculateSubtraction(RomanSymbol smaller, RomanSymbol greater) {
		if(smaller == RomanSymbol.I && greater != RomanSymbol.V && greater != RomanSymbol.X) {
			return OptionalInt.empty();
		}
		if(smaller == RomanSymbol.X && greater != RomanSymbol.L && greater != RomanSymbol.C) {
			return OptionalInt.empty();
		}
		if(smaller == RomanSymbol.C && greater != RomanSymbol.D && greater != RomanSymbol.M) {
			return OptionalInt.empty();
		}

		return OptionalInt.of(greater.getValue() - smaller.getValue());
	}
}

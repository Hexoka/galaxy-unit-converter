package com.itemis.galaxy;

import java.util.List;
import java.util.OptionalInt;

/**
 * This class is able to calculate the number for a given roman numeral.
 */
public final class RomanNumberConverter {

	/**
	 * Calculate the number for a roman numeral.
	 * @param romanSymbols roman numeral (not null)
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
	}
	
	private OptionalInt calculateDigitValue(List<RomanSymbol> romanSymbols) {
		if(romanSymbols.size() == 2) {
			if(romanSymbols.get(1).getValue() > romanSymbols.get(0).getValue()) {
				return calculateSubtraction(romanSymbols.get(0), romanSymbols.get(1));
			}
		}
		
		int value = 0;
		RomanSymbol previousSymbol = RomanSymbol.M;
		int repeats = 0;
		for(RomanSymbol symbol : romanSymbols) {
			if(symbol.getValue() > previousSymbol.getValue()) {
				return OptionalInt.empty();
			} else if(symbol == previousSymbol) {
				repeats++;
				if(repeats > allowedRepeats(symbol)) {
					return OptionalInt.empty();
				}
			} else {
				repeats = 1;
			}
			value += symbol.getValue();
			previousSymbol = symbol;
		}
		return OptionalInt.of(value);
	}

	/**
	 * Returns the number of allowed repetitions of the given symbol in a roman numeral. 
	 * @param symbol symbol (not null)
	 * @return the number of allowed repetitions
	 */
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
			return 1;
		default:
			throw new IllegalArgumentException("Unknown symbol: " + symbol.name());
		}
	}

	/**
	 * Calculates the subtraction of two roman symbols if the combination is valid e.g.:
	 * <br>IV = 4
	 * <br>MC = 900
	 * <br>XL = 40
	 * @param first first roman symbol (not null)
	 * @param second second roman symbol (not null)
	 * @return the subtracted value of the two symbols or empty if combination is invalid
	 */
	private OptionalInt calculateSubtraction(RomanSymbol first, RomanSymbol second) {
		if(first != RomanSymbol.I && first != RomanSymbol.X && first != RomanSymbol.C) {
			return OptionalInt.empty();
		}
		
		if(first == RomanSymbol.I && second != RomanSymbol.V && second != RomanSymbol.X) {
			return OptionalInt.empty();
		}
		if(first == RomanSymbol.X && second != RomanSymbol.L && second != RomanSymbol.C) {
			return OptionalInt.empty();
		}
		if(first == RomanSymbol.C && second != RomanSymbol.D && second != RomanSymbol.M) {
			return OptionalInt.empty();
		}

		return OptionalInt.of(second.getValue() - first.getValue());
	}
}

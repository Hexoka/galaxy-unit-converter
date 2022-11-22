package com.itemis.galaxy;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/**
 * This class is able to calculate the number for a given roman numeral.
 */
public final class RomanNumberConverter {

	/**
	 * Calculate the number for a roman numeral.
	 * @param romanSymbols roman numeral (must not contain null values)
	 * @return calculated number or empty if the number can not be calculated because of an invalid input
	 */
	public OptionalInt calculateNumber(List<RomanSymbol> romanSymbols) {
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
			OptionalInt valueFirst = calculateNumber(List.of(first));
			OptionalInt valueWithoutFirst = calculateNumber(romanSymbols);
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
			OptionalInt valueWithoutFirst = calculateNumber(romanSymbols);
			if(valueFirstSecond.isPresent() && valueWithoutFirst.isPresent()) {
				int value = valueWithoutFirst.getAsInt() + valueFirstSecond.getAsInt();
				return OptionalInt.of(value);
			} else {
				return OptionalInt.empty();
			}
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

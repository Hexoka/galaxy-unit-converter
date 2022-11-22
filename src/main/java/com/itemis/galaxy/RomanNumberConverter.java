package com.itemis.galaxy;

import java.util.List;
import java.util.OptionalInt;

/**
 * This class is able to calculate the number for a given roman numeral.
 */
public final class RomanNumberConverter {

	/**
	 * Calculate the number for a roman numeral.
	 * @param romanSymbols roman numeral
	 * @return calculated number or empty if the number can not be calculated
	 */
	public OptionalInt calculateNumber(List<RomanSymbol> romanSymbols) {
		switch(romanSymbols.size()) {
		case 0:
			return OptionalInt.of(0);
		case 1:
			return OptionalInt.of(romanSymbols.get(0).getValue());
		}
		return OptionalInt.empty();
	}
}

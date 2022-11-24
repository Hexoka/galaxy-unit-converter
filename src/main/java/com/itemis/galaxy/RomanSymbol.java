package com.itemis.galaxy;

/**
 * This enum represents the symbols used for roman numerals.
 */
public enum RomanSymbol {

	I(1),
	V(5),
	X(10),
	L(50),
	C(100),
	D(500),
	M(1000);
	
	private int value;
	
	/**
	 * Construct a new roman symbol.
	 * @param value value of the roman symbol.
	 */
	private RomanSymbol(int value) {
		this.value = value;
	}
	
	/**
	 * Get the value of the roman symbol.
	 * @return value
	 */
	public int getValue() {
		return value;
	}
}

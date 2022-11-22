package com.itemis.galaxy;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the {@link RomanNumberConverter} class.
 */
public final class RomanNumberConverterTest {
	
	/**
	 * Tests the method {@link RomanNumberConverter#calculateNumber(List)}
	 * Uses an empty list.
	 */
	@Test
	public void testCalculateNumber() {
		RomanNumberConverter converter = new RomanNumberConverter();
		
		List<RomanSymbol> input = List.of();
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(0, converter.calculateNumber(input).getAsInt());
		
	}

	/**
	 * Tests the method {@link RomanNumberConverter#calculateNumber(List)}
	 * Uses only single roman symbols.
	 */
	@Test
	public void testCalculateNumber1() {
		RomanNumberConverter converter = new RomanNumberConverter();
		
		List<RomanSymbol> input = List.of(RomanSymbol.I);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(1, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.V);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(5, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.X);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(10, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.L);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(50, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.C);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(100, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.D);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(500, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.M);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(1000, converter.calculateNumber(input).getAsInt());
	}
	

	
	/**
	 * Tests the method {@link RomanNumberConverter#calculateNumber(List)}
	 * Uses combinations of two roman symbols
	 */
	@Test
	public void testCalculateNumber2() {
		RomanNumberConverter converter = new RomanNumberConverter();
		
		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.I);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(2, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.I, RomanSymbol.V);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(4, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.V, RomanSymbol.I);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(6, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.I, RomanSymbol.X);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(9, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.X, RomanSymbol.I);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(11, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.X, RomanSymbol.V);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(15, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.X, RomanSymbol.L);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(40, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.X, RomanSymbol.C);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(90, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.X, RomanSymbol.X);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(20, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.C, RomanSymbol.D);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(400, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.C, RomanSymbol.C);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(200, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.C, RomanSymbol.M);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(900, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.M, RomanSymbol.M);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(2000, converter.calculateNumber(input).getAsInt());
	}
	
	/**
	 * Tests the method {@link RomanNumberConverter#calculateNumber(List)}
	 * Uses combinations of more than two roman symbols
	 */
	@Test
	public void testCalculateNumber3() {
		RomanNumberConverter converter = new RomanNumberConverter();

		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.I, RomanSymbol.I);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(3, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.V, RomanSymbol.I, RomanSymbol.I);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(7, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.V, RomanSymbol.I, RomanSymbol.I, RomanSymbol.I);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(8, converter.calculateNumber(input).getAsInt());

		input = List.of(RomanSymbol.X, RomanSymbol.I, RomanSymbol.V);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(14, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.M, RomanSymbol.C, RomanSymbol.M, RomanSymbol.X, RomanSymbol.L, RomanSymbol.I, RomanSymbol.V);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(1944, converter.calculateNumber(input).getAsInt());
		
		input = List.of(RomanSymbol.M, RomanSymbol.C, RomanSymbol.M, RomanSymbol.I, RomanSymbol.I, RomanSymbol.I);
		Assert.assertTrue(converter.calculateNumber(input).isPresent());
		Assert.assertEquals(1903, converter.calculateNumber(input).getAsInt());
	}
	
	/**
	 * Tests the method {@link RomanNumberConverter#calculateNumber(List)}
	 * Uses invalid combinations of multiple roman symbols
	 */
	@Test
	public void testCalculateNumber4() {
		RomanNumberConverter converter = new RomanNumberConverter();
		
		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.I, RomanSymbol.I, RomanSymbol.I);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
		
		input = List.of(RomanSymbol.V, RomanSymbol.V);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
		
		input = List.of(RomanSymbol.X, RomanSymbol.X, RomanSymbol.X, RomanSymbol.X);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
		
		input = List.of(RomanSymbol.L, RomanSymbol.L);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
		
		input = List.of(RomanSymbol.C, RomanSymbol.C, RomanSymbol.C, RomanSymbol.C);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
		
		input = List.of(RomanSymbol.D, RomanSymbol.D);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
		
		input = List.of(RomanSymbol.M, RomanSymbol.M, RomanSymbol.M, RomanSymbol.M);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());

		input = List.of(RomanSymbol.X, RomanSymbol.I, RomanSymbol.V, RomanSymbol.I);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}
}

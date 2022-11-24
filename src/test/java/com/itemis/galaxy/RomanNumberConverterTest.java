package com.itemis.galaxy;

import java.util.List;
import java.util.OptionalInt;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the {@link RomanNumberConverter} class.
 */
public final class RomanNumberConverterTest {

	private final RomanNumberConverter converter = new RomanNumberConverter();

	/**
	 * Tests the method {@link RomanNumberConverter#calculateNumber(List)} Uses an
	 * empty list.
	 */
	@Test
	public void testCalculateNumber0() {
		List<RomanSymbol> input = List.of();
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(0, result.getAsInt());
	}

	/**
	 * Tests the method {@link RomanNumberConverter#calculateNumber(List)} Uses only
	 * single roman symbols.
	 */
	@Test
	public void testCalculateNumber1() {
		List<RomanSymbol> input = List.of(RomanSymbol.I);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(1, result.getAsInt());
	}

	@Test
	public void testCalculateNumber2() {
		List<RomanSymbol> input = List.of(RomanSymbol.V);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(5, result.getAsInt());
	}

	@Test
	public void testCalculateNumber3() {
		List<RomanSymbol> input = List.of(RomanSymbol.X);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(10, result.getAsInt());
	}

	@Test
	public void testCalculateNumber4() {
		List<RomanSymbol> input = List.of(RomanSymbol.L);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(50, result.getAsInt());
	}

	@Test
	public void testCalculateNumber5() {
		List<RomanSymbol> input = List.of(RomanSymbol.C);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(100, result.getAsInt());
	}

	@Test
	public void testCalculateNumber6() {
		List<RomanSymbol> input = List.of(RomanSymbol.D);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(500, result.getAsInt());
	}

	@Test
	public void testCalculateNumber7() {
		List<RomanSymbol> input = List.of(RomanSymbol.M);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(1000, result.getAsInt());
	}

	@Test
	public void testCalculateNumber8() {
		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.I);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(2, result.getAsInt());
	}

	@Test
	public void testCalculateNumber9() {
		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.V);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(4, result.getAsInt());
	}

	@Test
	public void testCalculateNumber10() {
		List<RomanSymbol> input = List.of(RomanSymbol.V, RomanSymbol.I);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(6, result.getAsInt());
	}

	@Test
	public void testCalculateNumber11() {
		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.X);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(9, result.getAsInt());
	}

	@Test
	public void testCalculateNumber12() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.I);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(11, result.getAsInt());
	}

	@Test
	public void testCalculateNumber13() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.V);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(15, result.getAsInt());
	}

	@Test
	public void testCalculateNumber14() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.L);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(40, result.getAsInt());
	}

	@Test
	public void testCalculateNumber15() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.C);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(90, result.getAsInt());
	}

	@Test
	public void testCalculateNumber16() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.X);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(20, result.getAsInt());
	}

	@Test
	public void testCalculateNumber17() {
		List<RomanSymbol> input = List.of(RomanSymbol.C, RomanSymbol.D);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(400, result.getAsInt());
	}

	@Test
	public void testCalculateNumber18() {
		List<RomanSymbol> input = List.of(RomanSymbol.C, RomanSymbol.C);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(200, result.getAsInt());
	}

	@Test
	public void testCalculateNumber19() {
		List<RomanSymbol> input = List.of(RomanSymbol.C, RomanSymbol.M);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(900, result.getAsInt());
	}

	@Test
	public void testCalculateNumber20() {
		List<RomanSymbol> input = List.of(RomanSymbol.M, RomanSymbol.M);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(2000, result.getAsInt());
	}

	@Test
	public void testCalculateNumber21() {
		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.I, RomanSymbol.I);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(3, result.getAsInt());
	}

	@Test
	public void testCalculateNumber22() {
		List<RomanSymbol> input = List.of(RomanSymbol.V, RomanSymbol.I, RomanSymbol.I);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(7, result.getAsInt());
	}

	@Test
	public void testCalculateNumber23() {
		List<RomanSymbol> input = List.of(RomanSymbol.V, RomanSymbol.I, RomanSymbol.I, RomanSymbol.I);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(8, result.getAsInt());
	}

	@Test
	public void testCalculateNumber24() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.I, RomanSymbol.V);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(14, result.getAsInt());
	}

	@Test
	public void testCalculateNumber25() {
		List<RomanSymbol> input = List.of(RomanSymbol.M, RomanSymbol.C, RomanSymbol.M, RomanSymbol.X, RomanSymbol.L,
				RomanSymbol.I, RomanSymbol.V);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(1944, result.getAsInt());
	}

	@Test
	public void testCalculateNumber26() {
		List<RomanSymbol> input = List.of(RomanSymbol.M, RomanSymbol.C, RomanSymbol.M, RomanSymbol.I, RomanSymbol.I,
				RomanSymbol.I);
		OptionalInt result = converter.calculateNumber(input);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals(1903, result.getAsInt());
	}

	@Test
	public void testCalculateNumber27() {
		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.I, RomanSymbol.I, RomanSymbol.I);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber28() {
		List<RomanSymbol> input = List.of(RomanSymbol.V, RomanSymbol.V);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber29() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.X, RomanSymbol.X, RomanSymbol.X);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber30() {
		List<RomanSymbol> input = List.of(RomanSymbol.L, RomanSymbol.L);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber31() {
		List<RomanSymbol> input = List.of(RomanSymbol.C, RomanSymbol.C, RomanSymbol.C, RomanSymbol.C);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber32() {
		List<RomanSymbol> input = List.of(RomanSymbol.D, RomanSymbol.D);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber33() {
		List<RomanSymbol> input = List.of(RomanSymbol.M, RomanSymbol.M, RomanSymbol.M, RomanSymbol.M);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber34() {
		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.M);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber35() {
		List<RomanSymbol> input = List.of(RomanSymbol.I, RomanSymbol.L);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber36() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.M);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber37() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.D);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}

	@Test
	public void testCalculateNumber38() {
		List<RomanSymbol> input = List.of(RomanSymbol.X, RomanSymbol.I, RomanSymbol.V, RomanSymbol.I);
		Assert.assertFalse(converter.calculateNumber(input).isPresent());
	}
}

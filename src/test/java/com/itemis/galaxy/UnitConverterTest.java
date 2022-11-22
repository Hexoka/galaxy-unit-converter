package com.itemis.galaxy;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the {@link UnitConverter} class.
 */
public final class UnitConverterTest {

	/**
	 * Tests the methods {@link UnitConverterTest#setSymbolValue}, {@link UnitConverterTest#removeSymbolValue}
	 * and {@link UnitConverterTest#getSymbolValue}
	 */
	@Test
	public void testGalacticSymbols() {
		UnitConverter unitConverter = new UnitConverter();
		unitConverter.setSymbolValue("glob", RomanSymbol.I);
		Assert.assertEquals(RomanSymbol.I, unitConverter.getSymbolValue("glob").get());
		
		unitConverter.setSymbolValue("prok", RomanSymbol.V);
		Assert.assertTrue(unitConverter.getSymbolValue("prok").isPresent());
		unitConverter.removeSymbolValue("prok");
		Assert.assertTrue(unitConverter.getSymbolValue("prok").isEmpty());
		
		unitConverter.setSymbolValue("pish", RomanSymbol.I);
		unitConverter.setSymbolValue("pish", RomanSymbol.X);
		Assert.assertEquals(RomanSymbol.X, unitConverter.getSymbolValue("pish").get());
	}
	
	/**
	 * Tests the methods {@link UnitConverterTest#setMetalPrice}, {@link UnitConverterTest#removeMetalPrice}
	 * and {@link UnitConverterTest#getMetalPrice}
	 */
	@Test
	public void testMetalPrices() {
		UnitConverter unitConverter = new UnitConverter();
		unitConverter.setMetalPrice("Silver", 17.0);
		Assert.assertEquals(17.0, unitConverter.getMetalPrice("Silver").getAsDouble(), 0.001);
		
		unitConverter.setMetalPrice("Gold", 14450.0);
		Assert.assertTrue(unitConverter.getMetalPrice("Gold").isPresent());
		unitConverter.removeMetalPrice("Gold");
		Assert.assertTrue(unitConverter.getMetalPrice("Gold").isEmpty());
		
		unitConverter.setMetalPrice("Iron", 200.0);
		unitConverter.setMetalPrice("Iron", 195.5);
		Assert.assertEquals(195.5, unitConverter.getMetalPrice("Iron").getAsDouble(), 0.001);
	}
	
	/**
	 * Tests the method {@link UnitConverterTest#calculateNumber}
	 */
	@Test
	public void testCalculateNumber() {
		UnitConverter unitConverter = new UnitConverter();
		unitConverter.setSymbolValue("glob", RomanSymbol.I);		
		unitConverter.setSymbolValue("prok", RomanSymbol.V);		
		unitConverter.setSymbolValue("pish", RomanSymbol.X);		
		unitConverter.setSymbolValue("tegj", RomanSymbol.L);
		
		Assert.assertEquals(2, unitConverter.calculateNumber(List.of("glob", "glob")).getAsInt());
		Assert.assertEquals(4, unitConverter.calculateNumber(List.of("glob", "prok")).getAsInt());
		Assert.assertEquals(42, unitConverter.calculateNumber(List.of("pish", "tegj", "glob", "glob")).getAsInt());
		Assert.assertTrue(unitConverter.calculateNumber(List.of("pish", "tegj", "glob", "globx")).isEmpty());
		Assert.assertTrue(unitConverter.calculateNumber(List.of("glob", "glob", "glob", "glob")).isEmpty());
	}
	
	/**
	 * Tests the method {@link UnitConverterTest#calculatePrice}
	 */
	@Test
	public void testCalculatePrice() {
		UnitConverter unitConverter = new UnitConverter();
		unitConverter.setSymbolValue("glob", RomanSymbol.I);		
		unitConverter.setSymbolValue("prok", RomanSymbol.V);		
		unitConverter.setSymbolValue("pish", RomanSymbol.X);		
		unitConverter.setSymbolValue("tegj", RomanSymbol.L);
		unitConverter.setMetalPrice("Silver", 17.0);
		unitConverter.setMetalPrice("Gold", 14450.0);
		unitConverter.setMetalPrice("Iron", 195.5);
		
		Assert.assertEquals(68.0, unitConverter.calculatePrice("Silver", List.of("glob", "prok")).getAsDouble(), 0.001);
		Assert.assertEquals(57800.0, unitConverter.calculatePrice("Gold", List.of("glob", "prok")).getAsDouble(), 0.001);
		Assert.assertEquals(782.0, unitConverter.calculatePrice("Iron", List.of("glob", "prok")).getAsDouble(), 0.001);
		Assert.assertTrue(unitConverter.calculatePrice("Bronze", List.of("glob", "prok")).isEmpty());
		Assert.assertTrue(unitConverter.calculatePrice("Silver", List.of("globx", "prok")).isEmpty());
	}

}

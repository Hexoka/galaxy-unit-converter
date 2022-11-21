package com.itemis.galaxy;

import java.util.Arrays;
import java.util.List;

/**
 * The main class is used to run the application. 
 */
public class Main {

	/**
	 * Processes the input and prints out the resulting output of the unit conversion.
	 * @param args conversion notes input
	 */
	public static void main(String[] args) {
		ConversionNotesProcessor notesProcessor = new ConversionNotesProcessor();
		List<String> conversionNotes = Arrays.asList(args);
		notesProcessor.processNotes(conversionNotes).forEach(System.out::println);
	}

}

package com.itemis.galaxy;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the {@link ConversionNotesProcessor} class.
 */
public final class ConversionNotesProcessorTest {

	@Test
	public void testProcessNotes() {
		List<String> input = List.of(
				  "glob is I",
	              "prok is V",
	              "pish is X",
	              "tegj is L",
	              "glob glob Silver is 34 Credits",
	              "glob prok Gold is 57800 Credits",
	              "pish pish Iron is 3910 Credits",
	              "how much is pish tegj glob glob ?",
	              "how many Credits is glob prok Silver ?",
	              "how many Credits is glob prok Gold ?",
	              "how many Credits is glob prok Iron ?",
	              "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
		
		ConversionNotesProcessor notesProcessor = new ConversionNotesProcessor();
		List<String> output = notesProcessor.processNotes(input);
		
		Assert.assertEquals(output.size(), 5);
		Assert.assertEquals(output.get(0), "pish tegj glob glob is 42");
		Assert.assertEquals(output.get(1), "glob prok Silver is 68 Credits");
		Assert.assertEquals(output.get(2), "glob prok Gold is 57800 Credits");
		Assert.assertEquals(output.get(3), "glob prok Iron is 782 Credits");
		Assert.assertEquals(output.get(4), "I have no idea what you are talking about");
	}
}

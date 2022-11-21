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
		
		Assert.assertEquals(5, output.size());
		Assert.assertEquals("pish tegj glob glob is 42", output.get(0));
		Assert.assertEquals("glob prok Silver is 68 Credits", output.get(1));
		Assert.assertEquals("glob prok Gold is 57800 Credits", output.get(2));
		Assert.assertEquals("glob prok Iron is 782 Credits", output.get(3));
		Assert.assertEquals("I have no idea what you are talking about", output.get(4));
	}
}

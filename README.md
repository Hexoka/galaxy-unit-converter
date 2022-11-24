# Galaxy Unit Converter

## Assumptions
- The unit is always called *Credits*
- The structure of the input lines is always like in the test input:


1. Definition of a symbol e.g.: glob is I
2. Observed metal price e.g.: glob glob Silver is 34 Credits
3. Question of a number value e.g.: how much is glob glob ?
4. Question of a price value e.g.: how many Credits is glob glob Silver ?


- Otherwise the application will return: *I have no idea what you are talking about*

## Build and Run
The project can be build using maven:
- <code>mvn install</code> will generate a JAR-file called "galaxy-unit-converter-1.0.0-SNAPSHOT.jar" in the target directory
- This will also run the unit test automatically
- To just run the unit test call: <code>mvn test</code>

The JAR-file can be executed using Java 17 (with the test input or can replaced with other input):
- <code>java -cp galaxy-unit-converter-1.0.0-SNAPSHOT.jar com.itemis.galaxy.Main "glob is I" "prok is V" "pish is X" "tegj is L" "glob glob Silver is 34 Credits" "glob prok Gold is 57800 Credits" "pish pish Iron is 3910 Credits" "how much is pish tegj glob glob ?" "how many Credits is glob prok Silver ?" "how many Credits is glob prok Gold ?" "how many Credits is glob prok Iron ?" "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"</code>

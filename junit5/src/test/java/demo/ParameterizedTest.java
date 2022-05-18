package demo;

import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/** Some examples of JUnit5 Parameterized Demo.
 * For a full treatise on this topic, see
 * https://baeldung.com/parameterized-tests-junit-5
 */
public class ParameterizedTest {

	static final int THRESHOLD = 42;

	/** Simple: a list of values in the annotation;
	 * other primitive types can be used.
	 */
	@org.junit.jupiter.params.ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,7,8,9})
	public void testNumberBelowThreshold(int num) {
		assertTrue(num < THRESHOLD);
	}
	
	/** More complex: read lines with "input,expected" 
	 * from a CSV file on disk
	 */
	@org.junit.jupiter.params.ParameterizedTest
	@CsvFileSource(resources = "/demo.csv", numLinesToSkip = 1)
	public void testToLowerCaseAndTrimWithCsvFromFile(String input, String expected) {
		String actual = input.toLowerCase().trim();
		assertEquals(expected, actual);
	}
}
		

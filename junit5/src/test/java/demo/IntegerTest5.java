package demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** 
 * Demonstrate how you might use JUnit 5.x to test the java.lang.Integer 
 * class (this is not to say that Sun/Oracle doesn't test before they ship it - they do!!).
 */
public class IntegerTest5 {

	// These two optional setup methods are just to show
	// when they get invoked by the framework.
	
	@BeforeAll
	public static void setupClass() {
		System.out.println("IntegerTest: In demo Class setup method");
    }

	@BeforeEach
	public void setUp() {
		System.out.println("IntegerTest: In demo Instance setup method");
	}
	
	@Test
	public void testAdd() {
		assertEquals(4, 2 + 2, "Java can't add!");
	}
	@Test
	public void testDecode() {
		int ret = Integer.decode("-42").intValue();
		assertEquals(-42, ret);
	}

	@Test
	public void testDecodeThrows() {
		assertThrows(NumberFormatException.class,
		    () -> Integer.decode("one two three"));
	}
}

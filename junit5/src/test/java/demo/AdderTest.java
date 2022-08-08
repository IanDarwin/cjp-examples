package demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** 
 * Demonstrate how you might use JUnit 5.x to test a class that USES the java.lang.Integer class
 */
public class AdderTest {

	MyAdder target;

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
		assertEquals(4, target.add(2, 2), "Adder can't add!");
	}

	// Trivial, just enough to throw tests at
	class MyAdder {
		int add(int i1, int i2) {
			return i1 + i2;
		}
	}
}

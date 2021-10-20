package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Demonstrate JUnit5's approach.
 * The use of println's is not normal for a production test,
 * but only to show which methods are called and when.
 */
public class DecorTest {

	Decorator decorator;
	
	@BeforeAll
	public static void preClassInit() {
		System.out.println("DecorTest.setup");
		// empty - would normally be used for factory init, etc.
	}
	
	@BeforeEach
	public void setup() {
		System.out.println("DecorTest.setup");
		decorator = new Decorator();
	}

	@Test
	public void testDefaultModern() {
		System.out.println("DecorTest.testDefaultModern");
		assertEquals("++ Demo ++", decorator.decorate("Demo"), () -> decorator.toString());
	}

	@Test
	public void testNonDefaultClassic() {
		assertEquals("// Hello world //",
			new Decorator("//", "==").decorate("Hello world"));
	}

	@Test
	public void testInvalidTheme() {
		Exception exception = assertThrows(
			IllegalArgumentException.class,
			() -> { decorator.decorate("Decorate this", "MyNotWrittenYetTheme"); });
		System.out.println("Exception was " + exception);
	}
	
	@AfterAll
	public static void tearDownClass() {
		System.out.println("DecorTest.tearDownClass()");
	}
}

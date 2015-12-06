package demo;

import static org.junit.gen5.api.Assertions.assertEquals;
import static org.junit.gen5.api.Assertions.expectThrows;

import org.junit.gen5.api.BeforeEach;
import org.junit.gen5.api.Test;
import org.junit.gen5.api.TestName;

public class DecorTest {

	Decorator decorator;

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
		    Exception exception = expectThrows(
				IllegalArgumentException.class,
				() -> { decorator.decorate("Decorate this", "MyNotWrittenYetTheme"); });
	}
}

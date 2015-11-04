package examples.junit;

import org.junit.*;

import static java.lang.Math.sqrt;
import static org.junit.Assert.*;

public class DoubleWithEpsilonTest {

	@Test
	public void testSqrt() {
		assertEquals("test sqrt", 1.414213562D, sqrt(2), 0.00000001D);
	}
}

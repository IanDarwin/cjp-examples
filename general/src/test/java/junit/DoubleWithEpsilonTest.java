package junit;

import org.junit.*;

import static org.junit.Assert.*;

public class DoubleWithEpsilonTest {

	@Test
	public void testSqrt() {
		assertEquals("test sqrt", 1.414213562D, Math.sqrt(2), 0.00000001D);
	}
}

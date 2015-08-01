package junit;

import org.junit.*;

import static org.junit.Assert.*;

public class DoubleWithEpsilon {

	@Test
	public void isAnybodyListeningQ() {
		fail("Is anybody listening?");
	}

	@Test
	public void testSqrt() {
		assertEquals("test sqrt", 1.414213562D, Math.sqrt(2), 0.00000001D);
	}
}

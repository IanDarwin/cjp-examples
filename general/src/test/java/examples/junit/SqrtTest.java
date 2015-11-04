package examples.junit;
import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class SqrtTest {
	
	@Test @Ignore
	public void testSqrtBad() {
		assertEquals("test sqrt", 1.414213562D, sqrt(2));
	}
	
	@Test
	public void testSqrtGood() {
		assertEquals("test sqrt", 1.414213562D, sqrt(2), 0.00000001D);

	}
}
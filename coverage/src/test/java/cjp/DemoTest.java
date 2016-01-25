package cjp;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test simple sequence.
 */
public class DemoTest {

	Demo d;

	@Before
	public void init() {
		d = new Demo();
	}

	@Test
	public void testGetNext() {
		assertEquals(0, d.getNext());
		assertEquals(1, d.getNext());
		assertEquals(2, d.getNext());
	}

	@Test
	public void testReset() {
		d.getNext();
		d.getNext();
		d.reset();
		assertEquals(0, d.getNext());
	}
}

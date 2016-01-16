package examples.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringBuilderTest {
    @Test
    public void testAppendSimple() {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(',');
        sb.append(' ');
        sb.append("World");
        assertEquals("Test Append", "Hello, World", sb.toString());
    }
    
    private StringBuilder subject;

    @Before
    public void init() {
        subject = new StringBuilder();
    }
    
    @Test
    public void testAppendBetter() {
        subject.append("Hello");
        subject.append(',');
        subject.append(' ');
        subject.append("World");
        assertEquals("Test Append", "Hello, World", subject.toString());
    }
    
    @Test
    public void testClearing() {
    	assertEquals(0, subject.length());
    	subject.append("Hello world");
    	subject.setLength(0);
    	assertEquals(0, subject.length());
    	// While here, assert that it returns an empty string not a null string
    	assertEquals("", subject.toString());
    }

	// Test Exception Handling
	@Test(expected=IndexOutOfBoundsException.class)
	public void StringBuilderChecksIndex() {
		new StringBuilder().insert(-1, "Where does this go?");
	}
}

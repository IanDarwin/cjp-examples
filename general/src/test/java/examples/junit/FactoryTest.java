package examples.junit;

import org.junit.*;
import static org.junit.Assert.*;

public class FactoryTest {

	private static Factory factory;
	private Object instance;
	
	@BeforeClass
	public static void createFactory() {
		factory = new Factory();
		factory.open();
	}
	
	@Before
	public void createObj() {
		instance = factory.createInstance();
	}
	
	@Test
	public void testSomethingAboutInstance() {
		assertSame(Object.class, instance.getClass());
	}
	
	@After
	public void tearDown() {
		instance = null; // if the class under test had a close method...
	}
	
	@AfterClass
	public static void shutdown() {
		factory.close();
	}
	
	
	// This is a fake Factory class just to show the interactions
	public static class Factory {
		boolean open = false;
		void open() {
			open = true;
		}
		Object createInstance() {
			if (!open) {
				throw new IllegalStateException("Called createNew() but Factory isn't open");
			}
			return new Object();
		}
		void close() {
			open = false;
		}
	}
}

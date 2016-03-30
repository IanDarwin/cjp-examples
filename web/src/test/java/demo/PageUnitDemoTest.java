package demo;

import org.junit.Test;

import pageunit.ScriptTestCase;

public class PageUnitDemoTest {

	@Test
	public void testORMsearch() throws Exception {
		new ScriptTestCase("src/test/pageunit/oreilly.txt").run();
	}
}

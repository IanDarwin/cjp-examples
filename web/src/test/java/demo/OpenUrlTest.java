package demo;

import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;

public class OpenUrlTest {

	@Test
	public void testServerIsUp() throws Exception {
		new URL("http://darwinsys.com/").openConnection().getInputStream().close();
	}
	
	@Test
	@Ignore // Comment out to show failure
	public void testAnotherServerIsUp() throws Exception {
		new URL("http://nosuchhostuo2i3uoifiooaa.com/").openConnection().getInputStream().close();
	}
}

package junit4;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HamcrestDemoTest {

	@Test
	public void showSimpleHamcrestWorking() {
		
		assertThat("hello", equalTo("hello"));
		
		assertThat("a b c", allOf(
			equalTo("a b c"),
			instanceOf(String.class),
			not(containsString("x y z"))));
	}
}

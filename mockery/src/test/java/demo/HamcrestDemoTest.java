package demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

// tag::main[]
public class HamcrestDemoTest {

	@Test
	public void testNameConcat() {
		Person p = new Person("Ian", "Darwin");
		String f = p.getFullName();
		assertThat(f, containsString("Ian"));
		assertThat(f, equalTo("Ian Darwin"));
		assertThat(f, not(containsString("/"))); // contrived, to show syntax
	}

	String str = "truth is truth, to the end of reckoning";

	@Test
	public void stringTest() {
		assertThat(str, containsString("truth"));
		assertThat(str, not(containsString("beauty")));
	}
}
// end::main[]

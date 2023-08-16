package demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

// tag::main[]
public class HamcrestDemo4 {

	@Test
	public void testNameConcat() {
		Person p = new Person("Ian", "Darwin");
		String f = p.getFullName();
		assertThat(f, containsString("Ian"));
		assertThat(f, equalTo("Ian Darwin"));
		assertThat(f, not(containsString("/"))); // contrived, to show syntax
	}
}
// end::main[]

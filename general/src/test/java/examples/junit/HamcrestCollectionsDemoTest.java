package examples.junit;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsCollectionsWith.*;

import org.junit.Test;

public class HamcrestCollectionsDemoTest {

	@Test
	public void showSimpleHamcrestWorking() {
		
		List<String> data = Arrays.asList("One", "Two", "Three", "Four");
		assertThat(data, isCollectionWith("Two", "Four"));
	}
}

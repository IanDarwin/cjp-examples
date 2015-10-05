package examples.junit;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.*;
import org.junit.Test;

public class HamcrestCollectionsDemoTest {

	@Test
	public void showSimpleHamcrestWorking() {
		
		List<String> data = Arrays.asList("One", "Two", "Three", "Four");
		assertThat(data, hasItems("Two", "Four"));
	}
}

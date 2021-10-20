package junit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Test;

public class FilesystemTests {
	private static final String FILENAME = "test.data";

	@Test
	public void testFileCreation() throws Exception {
		File f = new File(FILENAME);
		// Check that it wasn't there
		assertFalse(f.exists());

		f.createNewFile();

		// Assert that it does exist
		assertTrue(f.exists());
	}

	/** Clean up: try to delete all artifacts after test */
	@After
	public void reallyClean() {
		// Do not care if either of these fails
		new File(FILENAME).delete();
		new File(FILENAME + ".bak").delete();
		new File(FILENAME + ".tmp").delete();
	}

}

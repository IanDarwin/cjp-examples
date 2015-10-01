package demo;

import java.util.*;

import org.junit.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PersonDaoTest {

	private PersonDao mockPersonDao;
	private PersonHandler testSubject;

	@Before
	public void setup() {
		mockPersonDao = mock(PersonDao.class);
		testSubject= new PersonHandler(mockPersonDao);
	}

	Person p1 = new Person(0, "First", "Person");
	Person p2 = new Person(1, "Robin", "Williams");
	Person[] people = {p1, p2};

	@Test
	public void testHandlerCallsDao() {
		// Condition the Mock
		when(mockPersonDao.getAll()).thenReturn(Arrays.asList(people));
		// when(mockPersonDao.getId(1)).thenReturn(new Person(1, "Ashlie", "Madison"));

		// Now the actual test
		boolean b = testSubject.checkIfPersonExists("Ashlie", "Madison");

		// Test the expectations
		verify(mockPersonDao, times(1)).getAll(); // also atLeastOnce(), never()
		assertFalse(b);
	}
}

package demo;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Same as PersonDaoTest but using @Mocks
 */
public class PersonDaoTest2 {

	@Mock private PersonDao mockPersonDao;
	private PersonController testSubject;

	@Before
	public void setup() {
		initMocks(this);
		testSubject= new PersonController(mockPersonDao);
	}

	List<Person> people = List.of(
		new Person(0, "First", "Person"),
		new Person(1, "Robin", "Williams"),
	);

	@Test
	public void testControllerCallsDaoGetAll() {
		// Condition the Mock
		when(mockPersonDao.getAll()).thenReturn(people);
		
		// Now the actual test - we know there's no such person in our fake data.
		boolean b = testSubject.checkIfPersonExists("Ashlie", "Madison");

		// Test the expectations
		verify(mockPersonDao, times(1)).getAll(); 
		// Could also use atLeastOnce(), never(), ...

		// Test the final result
		assertFalse(b);
	}

	@Test
	public void testControllerCallsDaoGetById() {
		when(mockPersonDao.getById(1)).thenReturn(new Person(1, "Ashlie", "Madison"));
		Person p = testSubject.findPersonById(1);
		verify(mockPersonDao, times(1)).getById(1);
		assertThat(p.name(), equalTo("Ashlie Madison"));
	}

}

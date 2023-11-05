package demo;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * Same as PersonDaoTest but using @Mocks
 */
public class MockitoViaAnnotsTest {

	@Mock private PersonDao mockPersonDao;
	private PersonController testSubject;

	@BeforeEach
	public void setup() {
		initMocks(this);
		testSubject= new PersonController(mockPersonDao);
	}

	List<Person> people = List.of(
		new Person("Some", "Person"),
		new Person("Robin", "Williams")
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
		when(mockPersonDao.getById(1)).thenReturn(new Person("Ashlie", "Madison"));
		Person p = testSubject.findPersonById(1);
		verify(mockPersonDao, times(1)).getById(1);
		assertThat(p.getFullName(), equalTo("Ashlie Madison"));
	}

}

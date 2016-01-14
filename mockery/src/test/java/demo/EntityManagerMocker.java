package demo;

import java.util.*;

import javax.persistence.*;

import org.junit.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class EntityManagerMocker {

	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void setup() {
		emf = mock(EntityManagerFactory.class);
		when (emf.createEntityManager()).thenReturn(mock(EntityManager.class));
	}

	@Test
	public void testHandlerCallsDao() {
		// Condition the Mock
		em = emf.createEntityManager();
		when(em.find(Person.class, 1L)).thenReturn(new Person(1, "Ashlie", "Madison"));

		// Now the actual test
		// Simulate some real EntityManager-using DAO code
		Person p = em.find(Person.class, 1L);

		// Test the expectations
		verify(emf, times(1)).createEntityManager();
		verify(em, times(1)).find(Person.class, 1L);
		assertEquals("Ashlie Madison", p.name());
	}
}

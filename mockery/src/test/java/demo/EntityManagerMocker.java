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
		em = mock(EntityManager.class);
		emf = mock(EntityManagerFactory.class);
		when (emf.createEntityManager()).thenReturn(em);
	}

	@Test
	public void testHandlerCallsDao() {
		// Condition the Mock
		when(em.find(1L, Person.class)).thenReturn(new Person(1, "Ashlie", "Madison"));

		// Now the actual test
		// Simulaate some real EntityManager-using DAO code
		Person p = em.find(1, Person.class);

		// Test the expectations
		verify(emf, times(1)).createEntityManager();
		verify(em, times(1)).find(1, Person.class);
		assertEquals("Ashlie Madison", p.name());
	}
}

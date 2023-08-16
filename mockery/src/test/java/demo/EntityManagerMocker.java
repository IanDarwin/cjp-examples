package demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class EntityManagerMocker {

	private static EntityManagerFactory emf;
	
	@BeforeClass
	public static void setup() {
		emf = mock(EntityManagerFactory.class);
		when (emf.createEntityManager()).thenReturn(mock(EntityManager.class));
	}

	@Test
	public void testHandlerCallsDao() {
		// Condition the Mock
		EntityManager em = emf.createEntityManager();
		when(em.find(Person.class, 1L)).thenReturn(new Person("Ashlie", "Madison"));

		// Now the actual test
		// Simulate some real EntityManager-using DAO code
		Person p = em.find(Person.class, 1L);

		// Test the expectations
		verify(emf, times(1)).createEntityManager();
		verify(em, times(1)).find(Person.class, 1L);
		assertEquals("Ashlie Madison", p.getFullName());
	}
}

package demo;

/** 
 * This is a fake data layer just to demonstrate use of mocking.
 */
public class PersonController {

	private PersonDao dao;

	public PersonController(PersonDao dao) {
		this.dao = dao;
	}

	/** 
	 * Again, this could more realistically be done in the data 
	 * layer with a "Where" clause...
	 */
	public boolean checkIfPersonExists(String firstName, String lastName) {
		for (Person candidate : dao.getAll()) {
			if (firstName.equals(candidate.firstName()) &&
				lastName.equals(candidate.lastName())) {
					return true;
				}
		}
		return false;
	}

	/** Simple delegation method to find a person by Id */
	public Person findPersonById(long i) {
		return dao.getById(i);
	}
}

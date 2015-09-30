package demo;

/** This is a fake data layer just to demonstrate use of mocking,
 * not intended to be best practices way of architecting your application.
 */
public class PersonHandler {

	private PersonDao dao;

	public PersonHandler(PersonDao dao) {
		this.dao = dao;
	}

	/** 
	 * Again, we know that this could more realistically be done in the data 
	 * layer with a "Where" clause...
	 */
	public boolean checkIfPersonExists(String firstName, String lastName) {
		for (Person candidate : dao.getAll()) {
			if (firstName.equals(candidate.firstName) &&
				lastName.equals(candidate.lastName)) {
					return true;
				}
		}
		return false;
	}
}

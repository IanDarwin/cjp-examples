package demo;

public class Person {

	long id;

	/*package*/ String firstName, lastName;

	public Person(long id, String f, String l) {
		this.id = id;
		this.firstName = f;
		this.lastName = l;
	}
	public Person(String f, String l) {
		this(0, f, l);
	}

	public String name() {
		return firstName + " " + lastName;
	}
}

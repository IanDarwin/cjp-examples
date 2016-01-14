package demo;

import java.util.Arrays;
import java.util.List;

public class PersonDaoStub implements PersonDao {
	Person p1 = new Person(0, "First", "Person");
	Person p2 = new Person(1, "Robin", "Williams");
	Person[] people = {p1, p2};

	@Override
	public List<Person> getAll() {
		return Arrays.asList(people);
	}

	@Override
	public Person getById(long id) {
		return id < people.length ? people[(int)id] : null;
	}
}

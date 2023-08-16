package demo;

import java.util.Arrays;
import java.util.List;

public class PersonDaoStub implements PersonDao {
	
	List<Person> people = List.of(
		new Person("First", "Person"),
		new Person("Robin", "Williams")
	);

	@Override
	public List<Person> getAll() {
		return people;
	}

	@Override
	public Person getById(long id) {
		return id < people.size() ? people.get((int)id) : null;
	}
}

package demo;

public record Person(String firstName, String lastName) { 
	public String getFullName() {
		return String.format("%s %s", firstName, lastName);
	}
}

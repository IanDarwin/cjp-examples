package examples;

public class FindBugsPropertiesExample {
	private int value = 42;

	public static void main(String[] args) {
		FindBugsPropertiesExample myprog = new FindBugsPropertiesExample();
		myprog.print();
		System.out.println("Value? I think it is " + myprog.value);
	}

	void print() {
		// This local variable shadows the field of the same name.
		// FindBugs is supposed to warn about this if the value of
		// the system property "findbugs.maskedfields.locals"
		// is set true.
		int value = 56;
		System.out.println("What is the value of value? I think it is " + value);
	}
}

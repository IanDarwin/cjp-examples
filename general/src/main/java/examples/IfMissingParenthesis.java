package examples;

public class IfMissingParenthesis {

	public static void someFunction(int a) {
		if (a < 0)
			System.err.printf("Value of 'a' is %d but may not be negative%n", a);
	}
}

package examples;

import edu.umd.cs.findbugs.annotations.NonNull;

public abstract class FBWarningsDemo {

	public static String MESSAGE1 = "Hello";

	@NonNull()	// Should warn: the default constructor leaves the field null
	public String message;

	//@edu.umd.cs.findbugs.annotations.SuppressWarnings("MS")
	public static String MESSAGE2 = "Hello";

	public void print() {
		System.out.println("Your message is " + message);
		FBWarningsDemo.MESSAGE2 = null;
	}
}

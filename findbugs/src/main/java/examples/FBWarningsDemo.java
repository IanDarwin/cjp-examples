package examples;

import javax.annotation.Nonnull;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public abstract class FBWarningsDemo {

	public static String MESSAGE1 = "Hello";

	@Nonnull()	// Should warn: the default constructor leaves the field null
	public String message;

	@SuppressFBWarnings("MS")
	public static String MESSAGE2 = "Hello";

	public void print() {
		System.out.println("Your message is " + message);
		FBWarningsDemo.MESSAGE2 = null;
	}
}

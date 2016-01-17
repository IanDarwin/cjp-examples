package fred;

import a.b.c.d.e.Fred;	// Fred does not exist so this won't compile

/**
 * This class will not compile, but it is here to show that PMD
 * can still find problems even in code that isn't compilable
 * due to external problems like missing imports.
 * That is why it is in the "notincludedsrc" directory instead
 * of the src directory; so Eclipse/NetBeans don't forever mark
 * your project in red...
 */
public class MissingInclude {

	private Fred fred;	// This can't possibly compile

	private static String x = "Hello. Man, this is weird"; // Should get warning

	public static void main(String[] args) {
		System.out.println(x);
	}
}

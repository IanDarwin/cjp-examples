package examples;

import javax.annotation.CheckReturnValue;

public class FindBugsAnnotationExample {

	@CheckReturnValue(/*"Friends don't greet friends with 'null'"*/)
	public static String getGreeting() {
		if (System.currentTimeMillis() % 12 == 0)
			return null;
		else
			return "Hello";
	}

	public static void main(String[] args) {
		getGreeting();
		System.out.println(getGreeting());
	}
}

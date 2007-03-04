package examples;

public class ThrowUncaughtExceptionDemo {

	int n = 0;

	public static void main(String[] args) {
		System.out.println("ThrowUncaughtExceptionDemo.java.main() starting");
		new ThrowUncaughtExceptionDemo(args).process();
		System.out.println("ThrowUncaughtExceptionDemo.java.main() done.");
	}

	public ThrowUncaughtExceptionDemo(String[] args) {
		System.out.println("ThrowUncaughtExceptionDemo.java.ThrowUncaughtException()");
		if (args.length == 1) {
			n = Integer.parseInt(args[0]);
		}
	}

	private void process() {
		System.out.println("ThrowUncaughtExceptionDemo.java.process()");
		if (n == 42) {
			throw new IllegalArgumentException("That is not the meaning of this program");
		}
	}
}

package badcode;

public class ThrowUncaughtException {

	int n = 0;

	public static void main(String[] args) {
		System.out.println("ThrowUncaughtException.main() starting");
		new ThrowUncaughtException(args).process();
		System.out.println("ThrowUncaughtException.main() done.");
	}

	public ThrowUncaughtException(String[] args) {
		System.out.println("ThrowUncaughtException.ThrowUncaughtException()");
		if (args.length == 1) {
			n = Integer.parseInt(args[0]);
		}
	}

	private void process() {
		System.out.println("ThrowUncaughtException.process()");
		if (n == 42) {
			throw new IllegalArgumentException("That is not the meaning of this program");
		}
	}
}

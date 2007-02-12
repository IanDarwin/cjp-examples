package intro;

public class AssertDemo {

	public static double myFunction(double d, double e) {
		System.out.printf("AssertDemo.myFunction(%e, %e)%n", d, e);

		// pre-assertion:
		assert d < e : "first argument must be less than second";

		double result = 0;	// some computation involving d and

		// post-assertion
		assert d >= 0 : "result became negative";

		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		myFunction(Math.PI, 123.456);	// OK
		myFunction(Math.PI, Math.PI);	// violates pre-assertion
	}

}

package examples;

/** Simple example of a class that could not be tested exhaustively
 * because of the combinatoric explosion of all possible states (there are
 * 2^32 * 2^64 = 4^96 possible states; don't try enumerating them at home, kids...).
 */
public class ImpossibleToTest {
	int x;
	double d;
	double compute() {
		double result = 0;
		// do something with x and d, save in 'result'
		return result;
	}
	// setters and getters for x and d here...
}

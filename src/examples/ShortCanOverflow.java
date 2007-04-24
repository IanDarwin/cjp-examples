package examples;

public class ShortCanOverflow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		short i = 0;
		while (i++ >= 0) {
			if (i%1000 == 0) {
				System.out.print('.');
			}
		}
		System.out.println();
		System.out.printf("" +
				"Incrementing i made it negative! (Value %d)%n", i);
	}

}

package examples;

import java.util.Date;

public class Warnings {

	private int x;	// Expect UNUSED Warning

	public static void main(String[] args) {
		int y;

        // Create a Date object for May 5, 1986
        Date d = new Date(86, 5-1, 5);   // EXPECT DEPRECATION WARNING
        System.out.println("Date is " + d);
	}
}

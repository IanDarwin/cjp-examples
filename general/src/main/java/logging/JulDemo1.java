package logging;

import java.util.logging.Logger;

public class JulDemo1 {
	
	public static void main(String[] args) {

		Logger myLogger = Logger.getLogger("logging");

		Object o = new Object();
		myLogger.info("I created an object: " + o);
	}
}

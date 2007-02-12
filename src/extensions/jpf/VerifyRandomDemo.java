package extensions.jpf;

import gov.nasa.jpf.jvm.Verify;

public class VerifyRandomDemo {

	public static void main(String[] args) {
		int ri = Verify.random(10);
		System.out.println(ri);
	}

}

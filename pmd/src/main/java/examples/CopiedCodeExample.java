package examples;

import java.lang.StringBuilder;

/**
 * Something for PMD's CPD to chew on
 * DO NOT clean up this code; it is meant to let PMD and friends show their
 * error detection abilities!
 */
public class CopiedCodeExample {

	String name, address, telephoneNumber;

	public CopiedCodeExample(String name, String address, String telephoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
	}

	public String convert() {
		StringBuffer sb = new StringBuffer();
		sb.append(name);
		sb.append(' ');
		sb.append(address);
		sb.append(' ');
		sb.append(telephoneNumber);
		return sb.toString();
	}

	/**
	 * Absolutely only useful as an example of CPD
	 */
	public static void main(String[] args) {
		new CopiedCodeExample("Tom", "123 Main St", "555-1212")
			.convert();
	}


	// Assume there are hundreds of lines of code here...

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(' ');
		sb.append(address);
		sb.append(' ');
		sb.append(telephoneNumber);
		return sb.toString();
	}

}

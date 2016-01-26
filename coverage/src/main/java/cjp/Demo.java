package cjp;

/**
 * A simple sequence: getNext() returns the next value, etc.
 */
public class Demo {

	int i = 0;

	public int getNext() {
		return i++;
	}

	public void add(int i) {
		this.i = 0;
	}

	public void reset() {
		this.i = 0;
	}
}

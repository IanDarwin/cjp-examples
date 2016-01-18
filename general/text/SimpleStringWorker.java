package fragments;

/** As the package name implies, this is an INCOMPLETE fragment
 * just to hold (and verify compilation of) one method.
 * @author Ian Darwin
 */
public class SimpleStringWorker implements CharSequence {

	char[] chars;
	
	public CharSequence append(CharSequence s) {
	    int current = chars.length;
	    int more = s.length();
	    char[] newChars = new char[current + more];
	    System.arraycopy(chars, 0, newChars, 0, current);
	    System.arraycopy(s.toString().toCharArray(), 0, newChars, current, more);
	    chars = newChars;
	    return this;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

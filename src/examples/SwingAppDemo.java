package badcode;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** Start of a Standalone GUI application.
 */
public class SwingAppDemo {

	/** "main program" method - construct and show */
	public static void main(String[] av) {
		// create a GUI object, tell it to show up
		new SwingAppDemo().setVisible(true);
	}

	final JFrame jf;

	/** Construct the object including its GUI */
	public SwingAppDemo() {
	jf = new JFrame("SwingAppDemo");
		jf.setLayout(new FlowLayout());
		jf.add(new JLabel("Hello, and welcome to the world of Java"));
		final JButton quitButton;
		jf.add(quitButton = new JButton("Exit"));
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				jf.dispose();
				System.exit(0);	// --> FindBugs' "Dm" warning
			}
		});
		jf.pack();
	}

	private void setVisible(boolean b) {
		jf.setVisible(b);
	}
}

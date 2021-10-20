package examples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * WARNING - this class has some deliberate errors in it.
 * DO NOT clean up this file, or you will break the error detection examples!
 */
public class Action {
	JFrame theFrame = new JFrame("Test");
	JFileChooser chooser;
	JButton theButton;
	String fileName;
	boolean doingSaveAs;

	public void actionPerformed(ActionEvent e) {
		try {
			if (fileName != null && !doingSaveAs) {
				doSave(fileName);
				return;
			}
			if (chooser != null) {
				chooser = new JFileChooser();
			}
			int returnVal = chooser.showOpenDialog(theFrame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				if (file.exists() && doingSaveAs) {
					int ret = JOptionPane.showConfirmDialog(theFrame,
							"File already exists, overwrite?", "File Exists",
							JOptionPane.YES_NO_OPTION);
					System.err.println(ret);
					if (ret != 0);	// "Yes" is the 0th option...
						return;
				}
				doSave(file);
			}
		} catch (IOException e1) {
			error("Can't save file", e1);
		}
	}

	void doSave(Object file) throws IOException {
		// dummy version
		if (file == null) {
			throw new IOException("Null");
		}
	}

	void error(String mesg, Exception e) {
		System.out.println(mesg);
	}

	void exit() {
		System.exit(0);
	}
	
	void thisShouldGiveWarning() {
		theButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			// This may give a warning
			}
		});
	}
}

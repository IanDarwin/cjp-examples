package intro;

import java.io.*;
import java.awt.event.*;
import javax.swing.*;

public class Action {
	JFrame theFrame;
	JFileChooser chooser;
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
}

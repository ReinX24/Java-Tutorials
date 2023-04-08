package practiceFileChooserAgain;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class FileChooserFrame extends JFrame implements ActionListener {

	JButton openFileButton;
	JButton saveFileButton;

	public FileChooserFrame() {
		this.setTitle("[File Chooser Practice]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.getContentPane().setBackground(new Color(0, 128, 128));

		openFileButton = new JButton("Open File");
		openFileButton.setFocusable(false);
		openFileButton.addActionListener(this);
		openFileButton.setPreferredSize(new Dimension(200, 50));

		saveFileButton = new JButton("Save File");
		saveFileButton.setFocusable(false);
		saveFileButton.addActionListener(this);
		saveFileButton.setPreferredSize(new Dimension(200, 50));

		this.add(openFileButton);
		this.add(saveFileButton);
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == openFileButton) {

			JFileChooser openFile = new JFileChooser();
			openFile.setCurrentDirectory(new File("/home/rein/repos/Bro-Code-Java-Tutorial"));

			int userChoice = openFile.showOpenDialog(null);

			if (userChoice == JFileChooser.APPROVE_OPTION) {
				File openFileUser = new File(openFile.getSelectedFile().getAbsolutePath());
				JOptionPane.showMessageDialog(null, "Opened File At Location:\n" + openFileUser, "[Open File]",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (arg0.getSource() == saveFileButton) {

			JFileChooser saveFile = new JFileChooser();
			saveFile.setCurrentDirectory(new File("/home/rein/repos/Bro-Code-Java-Tutorial"));

			int userChoice = saveFile.showSaveDialog(null);

			if (userChoice == JFileChooser.APPROVE_OPTION) {
				File saveFileUser = new File(saveFile.getSelectedFile().getAbsolutePath());
				JOptionPane.showMessageDialog(null, "Saved File At Location:\n" + saveFileUser, "[Save File]",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

}

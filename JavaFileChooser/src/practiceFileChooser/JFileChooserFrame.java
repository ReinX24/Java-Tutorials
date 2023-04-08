package practiceFileChooser;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class JFileChooserFrame extends JFrame implements ActionListener {

	JButton openFileButton;
	JButton saveFileButton;

	public JFileChooserFrame() {
		this.setTitle("[JFileChooser Practice]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(new FlowLayout());

		openFileButton = new JButton("Open File");
		openFileButton.setFocusable(false);
		openFileButton.addActionListener(this);

		saveFileButton = new JButton("Save File");
		saveFileButton.setFocusable(false);
		saveFileButton.addActionListener(this);

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
				File userFile = new File(openFile.getSelectedFile().getAbsolutePath());
				JOptionPane.showMessageDialog(null, "Opened File Location:\n" + userFile, "[Open File]",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (arg0.getSource() == saveFileButton) {

			JFileChooser saveFile = new JFileChooser();
			saveFile.setCurrentDirectory(new File("/home/rein/repos/Bro-Code-Java-Tutorial"));
			int userChoice = saveFile.showSaveDialog(null);

			if (userChoice == JFileChooser.APPROVE_OPTION) {
				File userFile = new File(saveFile.getSelectedFile().getAbsolutePath());
				JOptionPane.showMessageDialog(null, "Saved File Location:\n" + userFile, "[Save File]",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

}

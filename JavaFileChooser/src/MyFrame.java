import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {

	JButton chooseFileButton;

	public MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		chooseFileButton = new JButton("[Select File]");
		chooseFileButton.addActionListener(this);
		chooseFileButton.setFocusable(false);

		this.add(chooseFileButton);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == chooseFileButton) {

			JFileChooser fileChooser = new JFileChooser();

			// Setting default directory
//			fileChooser.setCurrentDirectory(new File(".")); // goes to current project folder
			fileChooser.setCurrentDirectory(new File("/home/rein/repos/Bro-Code-Java-Tutorial"));

			// Opening dialog menu
//			int userResponse = fileChooser.showOpenDialog(null); // select file to open
//			System.out.println(fileChooser.showOpenDialog(null));
			// returns 0 if a file is chosen, 1 if cancel or x in upper right corner

			// showSaveDialog, select file to save. Changes Open to Save in bottom right
			// corner
			int userResponse = fileChooser.showSaveDialog(null); // select file to open

			if (userResponse == JFileChooser.APPROVE_OPTION) {
				// Store selected file in a File object
				File userFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(userFile); // prints file location
			}

		}

	}

}

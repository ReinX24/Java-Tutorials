import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.desktop.OpenFilesEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class ProgramFrame extends JFrame implements ActionListener {

	JMenuBar mainBar;

	// JMenuBar components
	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;

	// fileMenu items
	JMenuItem openFile;
	JMenuItem saveFile;
	JMenuItem exitApp;
	
	// Button for opening and saving files
	JButton fileOpenSaveButton;

	public ProgramFrame() {
		this.setTitle("[JMenuBar and JFileChooser]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));

		mainBar = new JMenuBar();

		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");

		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu.setMnemonic(KeyEvent.VK_E);
		helpMenu.setMnemonic(KeyEvent.VK_H);

		openFile = new JMenuItem("Open");
		saveFile = new JMenuItem("Save");
		exitApp = new JMenuItem("Exit");

		openFile.setMnemonic(KeyEvent.VK_O);
		saveFile.setMnemonic(KeyEvent.VK_S);
		exitApp.setMnemonic(KeyEvent.VK_X);

		openFile.addActionListener(this);
		saveFile.addActionListener(this);
		exitApp.addActionListener(this);

		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(exitApp);

		mainBar.add(fileMenu);
		mainBar.add(editMenu);
		mainBar.add(helpMenu);

		this.setJMenuBar(mainBar);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == openFile) {
			JOptionPane.showMessageDialog(null, "Opening File...");
			this.dispose();
			
			JFrame openFileFrame = new JFrame();
			openFileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			openFileFrame.setLayout(new FlowLayout());
			
			fileOpenSaveButton = new JButton("[Open File]");
			fileOpenSaveButton.setFocusable(false);
			
			openFileFrame.add(fileOpenSaveButton);
			openFileFrame.pack();
			openFileFrame.setVisible(true);
			
			
		} else if (arg0.getSource() == saveFile) {
			JOptionPane.showMessageDialog(null, "Saving File...");
		} else if (arg0.getSource() == exitApp) {
			int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "[Exit App]",
					JOptionPane.YES_NO_OPTION);

			if (userChoice == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "App Exited!", "[Exit App]", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
		} else if (arg0.getSource() == fileOpenSaveButton) {
			JFileChooser chooseFile = new JFileChooser();
			chooseFile.setCurrentDirectory(new File(".")); // goes to current project directory
		}

	}

}

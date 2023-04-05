import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener {

	JMenuBar menuBar;

	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;

	JMenuItem saveItem;
	JMenuItem loadItem;
	JMenuItem exitItem;

	ImageIcon saveIcon;
	ImageIcon loadIcon;
	ImageIcon exitIcon;

	public MyFrame() {
		this.setTitle("[Menu Bar]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new FlowLayout());

		// Finish creating our JMenuBar
		menuBar = new JMenuBar();

		// Adding different menu categories
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		// Adding different menu items to file menu category
		saveItem = new JMenuItem("Save");
		loadItem = new JMenuItem("Load");
		exitItem = new JMenuItem("Exit");

		saveItem.addActionListener(this);
		loadItem.addActionListener(this);
		exitItem.addActionListener(this);

		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		fileMenu.add(exitItem);

		// Setting a keyboard shortcut to each of our menu items
		saveItem.setMnemonic(KeyEvent.VK_S); // capital S for Save
		loadItem.setMnemonic(KeyEvent.VK_L); // capital L for Load
		exitItem.setMnemonic(KeyEvent.VK_X); // capital E to Exit

		// Setting keyboard shortcuts to each of our menu categories
		fileMenu.setMnemonic(KeyEvent.VK_F); // Alt F
		editMenu.setMnemonic(KeyEvent.VK_E); // Alt E
		helpMenu.setMnemonic(KeyEvent.VK_H); // Alt H

		// Setting Icons for menu items in menu components
		saveIcon = new ImageIcon("healerStaff.png");
		loadIcon = new ImageIcon("warriorSword.png");
		exitIcon = new ImageIcon("wizardStaff.png");

		saveItem.setIcon(saveIcon);
		loadItem.setIcon(loadIcon);
		exitItem.setIcon(exitIcon);

		this.setJMenuBar(menuBar);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Adding action listeners to each menu item
		if (arg0.getSource() == saveItem) {
			JOptionPane.showMessageDialog(null, "[File Saved]");
		} else if (arg0.getSource() == loadItem) {
			JOptionPane.showMessageDialog(null, "[File Loaded]");
		} else if (arg0.getSource() == exitItem) {
			JOptionPane.showMessageDialog(null, "[Exited File]");
			this.dispose();
		}
	}

}
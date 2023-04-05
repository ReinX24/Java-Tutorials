package practiceMenuBar;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBarFrame extends JFrame implements ActionListener {

	// Main JMenuBar
	JMenuBar mainBar;

	// JMenuBar components
	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;
	JMenu aboutMenu;

	// JMenuItems

	// fileMenu
	JMenuItem saveItem;
	JMenuItem loadItem;
	JMenuItem exitItem;

	public MenuBarFrame() {
		this.setTitle("[Menu Bar Practice]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());

		// Finish creating our JMenuBar
		mainBar = new JMenuBar();

		// Creating our JMenuBar components
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");
		aboutMenu = new JMenu("About");

		// Adding components to JMenuBar
		mainBar.add(fileMenu);
		mainBar.add(editMenu);
		mainBar.add(helpMenu);
		mainBar.add(aboutMenu);

		// Adding action listeners to each menu component
		fileMenu.setMnemonic(KeyEvent.VK_F); // ALT + F
		editMenu.setMnemonic(KeyEvent.VK_E); // ALT + E
		helpMenu.setMnemonic(KeyEvent.VK_H); // ALT + H
		aboutMenu.setMnemonic(KeyEvent.VK_A); // ALT + A

		// Creating and adding menu items to fileMenu
		saveItem = new JMenuItem("Save");
		loadItem = new JMenuItem("Load");
		exitItem = new JMenuItem("Exit");

		// Adding shortcuts to file menu items, adding ActionListeners to each item
		saveItem.addActionListener(this);
		loadItem.addActionListener(this);
		exitItem.addActionListener(this);

		saveItem.setMnemonic(KeyEvent.VK_S);
		loadItem.setMnemonic(KeyEvent.VK_L);
		exitItem.setMnemonic(KeyEvent.VK_X);

		// TODO: Add menu items for each of the menu components

		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		fileMenu.add(exitItem);

		this.setJMenuBar(mainBar);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == saveItem) {
			JOptionPane.showMessageDialog(null, "Item Saved!", "[Save Item]", JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == loadItem) {
			JOptionPane.showMessageDialog(null, "Item Loaded!", "[Load Item]", JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == exitItem) {
			JOptionPane.showMessageDialog(null, "Exited Program!", "[Exit Item]", JOptionPane.INFORMATION_MESSAGE);
			this.dispose(); // closes our JFrame
		}
	}

}

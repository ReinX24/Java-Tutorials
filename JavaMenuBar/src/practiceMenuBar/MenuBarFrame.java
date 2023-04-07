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

	// editMenu
	JMenuItem copyItem;
	JMenuItem pasteItem;
	JMenuItem renameItem;

	// helpMenu
	JMenuItem helpLocal;
	JMenuItem helpOnline;
	JMenuItem helpCommunity;

	// aboutMenu
	JMenuItem aboutApp;
	JMenuItem aboutCompany;

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

		fileMenu.add(saveItem);
		fileMenu.add(loadItem);
		fileMenu.add(exitItem);

		// Creating and adding editMenu items
		copyItem = new JMenuItem("Copy");
		pasteItem = new JMenuItem("Paste");
		renameItem = new JMenuItem("Rename");

		copyItem.addActionListener(this);
		pasteItem.addActionListener(this);
		renameItem.addActionListener(this);

		copyItem.setMnemonic(KeyEvent.VK_C);
		pasteItem.setMnemonic(KeyEvent.VK_P);
		renameItem.setMnemonic(KeyEvent.VK_R);

		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		editMenu.add(renameItem);

		helpLocal = new JMenuItem("Local Help");
		helpOnline = new JMenuItem("Online Help");
		helpCommunity = new JMenuItem("Community Help");

		helpLocal.addActionListener(this);
		helpOnline.addActionListener(this);
		helpCommunity.addActionListener(this);

		helpLocal.setMnemonic(KeyEvent.VK_L);
		helpOnline.setMnemonic(KeyEvent.VK_O);
		helpCommunity.setMnemonic(KeyEvent.VK_C);

		helpMenu.add(helpLocal);
		helpMenu.add(helpOnline);
		helpMenu.add(helpCommunity);

		aboutApp = new JMenuItem("About App");
		aboutCompany = new JMenuItem("About Company");

		aboutApp.addActionListener(this);
		aboutCompany.addActionListener(this);

		aboutApp.setMnemonic(KeyEvent.VK_A);
		aboutCompany.setMnemonic(KeyEvent.VK_C);

		aboutMenu.add(aboutApp);
		aboutMenu.add(aboutCompany);

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
		} else if (arg0.getSource() == copyItem) {
			JOptionPane.showMessageDialog(null, "Copied Item!", "[Copy Item]", JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == pasteItem) {
			JOptionPane.showMessageDialog(null, "Pasted Item!", "[Paste Item]", JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == renameItem) {
			String newName = JOptionPane.showInputDialog(null, "Enter new item name: ");
			int userChoice = JOptionPane.showConfirmDialog(null, "Rename Item to : " + newName + "?");
			if (userChoice == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Renamed Item to : " + newName, "[Rename Item]",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (userChoice == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Rename Cancelled!", "[Rename Item]",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (userChoice == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, "Rename Cancelled", "[Rename Item]",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (arg0.getSource() == helpLocal) {
			JOptionPane.showMessageDialog(null, "Connecting to Local Help...", "[Local Help]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == helpOnline) {
			JOptionPane.showMessageDialog(null, "Connecting to Online Help...", "[Online Help]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == helpCommunity) {
			JOptionPane.showMessageDialog(null, "Connecting to Community Help...", "[Community Help]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == aboutApp) {
			JOptionPane.showMessageDialog(null, "App to edit text", "[About App]", JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == aboutCompany) {
			JOptionPane.showMessageDialog(null, "Text Company\nBetter Text, Better Future", "[About Company]",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

}

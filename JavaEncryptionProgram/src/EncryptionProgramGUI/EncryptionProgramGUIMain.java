package EncryptionProgramGUI;

import javax.lang.model.type.IntersectionType;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.AbstractRegionPainter;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EncryptionProgramGUIMain extends JFrame implements ActionListener {

	final Dimension PROGRAM_SCREEN_SIZE = new Dimension(1336, 768);
	final Color BACKGROUND_COLOR = new Color(0, 128, 128);
	final Font TITLE_FONT = new Font("Arial", Font.BOLD, 24);
	final Font PROGRAM_FONT = new Font("Arial", Font.BOLD, 16);
	final Color FONT_COLOR = Color.WHITE;
	final Color FONT_BACKGROUND_COLOR = Color.LIGHT_GRAY;

	JLabel titleLabel;
	JPanel mainPanel;

	JButton newKeyButton;
	JButton getKeyButton;
	JButton encryptMessageButton;
	JButton decryptMessageButton;
	JButton aboutProgramButton;
	JButton exitProgramButton;

	JButton[] programButtons;
	
	ArrayList<Character> plainCharList;
	ArrayList<Character> shuffledCharList;
	
	char currentChar;
	char[] userStringCharArr;
	

	public static void main(String[] args) {

		// TODO: recreate encryption program using Java Swing GUI components
		new EncryptionProgramGUIMain();
		// TODO: add ImageIcon for our program

	}

	public EncryptionProgramGUIMain() {

		createFrame();

	}

	public void createFrame() {
		this.setTitle("Encryption Program");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		addButtonsPanel();
		addButtons();

		this.pack();
		this.setLocationRelativeTo(null); // JFrame will appear in the center of the screen
		this.setVisible(true);
	}

	public void addButtonsPanel() {
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(PROGRAM_SCREEN_SIZE); // takes up entire screen
		mainPanel.setBackground(BACKGROUND_COLOR);
		mainPanel.setLayout(new GridLayout(7, 1, 0, 20)); // 6 rows, 1 column
		mainPanel.setBorder(new EmptyBorder(25, 400, 50, 400));

		// TODO: add titleLabel attributes
		titleLabel = new JLabel("ASCII ENCRYPTION PROGRAM");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(TITLE_FONT);
		titleLabel.setForeground(FONT_COLOR);
		titleLabel.setBackground(BACKGROUND_COLOR);
		mainPanel.add(titleLabel);

		this.add(mainPanel);
	}

	public void addButtons() {

		// TODO: add icons for our JButtons? (to be tested if feasible)
		programButtons = new JButton[6];

		newKeyButton = new JButton("New Key");
		getKeyButton = new JButton("Get Key");
		encryptMessageButton = new JButton("Encrypt Message");
		decryptMessageButton = new JButton("Decrypt Message");
		aboutProgramButton = new JButton("About Program");
		exitProgramButton = new JButton("Exit");

		programButtons[0] = newKeyButton;
		programButtons[1] = getKeyButton;
		programButtons[2] = encryptMessageButton;
		programButtons[3] = decryptMessageButton;
		programButtons[4] = aboutProgramButton;
		programButtons[5] = exitProgramButton;

		for (int i = 0; i < programButtons.length; i++) {
			programButtons[i].addActionListener(this);
			programButtons[i].setFocusable(false);
			programButtons[i].setFont(PROGRAM_FONT);

			mainPanel.add(programButtons[i]);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == newKeyButton) {
			// newKey function
		} 
		
		if (arg0.getSource() == getKeyButton) {
			// getKey function
		}
		
		if (arg0.getSource() == encryptMessageButton) {
			// encryptMessage function
		}
		
		if (arg0.getSource() == decryptMessageButton) {
			// decryptMessage function
		}
		
		if (arg0.getSource() == aboutProgramButton) {
			// aboutProgram function
		}
		
		if (arg0.getSource() == exitProgramButton) {
			// exitProgram function
			exitProgram();
		}
				
	}
	
	// TODO: finish getKey function
	public void getKey() {
		
		plainCharList = new ArrayList<Character>();
		
		
		
		for (int i = 32; i < 127; i++) {
			
		}
		
	}
	
	public void newKey() {
		
	}
	
	public void encryptMessage() {
		
	}
	
	public void decryptMessage() {
		
	}
	
	public void aboutProgram() {
		
	}
	
	public void exitProgram() {
		// TODO: add a confirmation prompt before closing program
		System.exit(0);
	}

}

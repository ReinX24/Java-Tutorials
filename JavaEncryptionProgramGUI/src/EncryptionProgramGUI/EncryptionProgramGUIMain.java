package EncryptionProgramGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class EncryptionProgramGUIMain extends JFrame implements ActionListener {

	final Dimension PROGRAM_SCREEN_SIZE = new Dimension(1336, 768);
	final Color BACKGROUND_COLOR = new Color(0, 128, 128);
	final Font TITLE_FONT = new Font("Arial", Font.BOLD, 32);
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
	JButton asciiTableButton;
	JButton exitProgramButton;

	JButton[] programButtons;

	ArrayList<Character> plainCharList;
	ArrayList<Character> shuffledCharList;

	String currentKey;
	String plainMessage;
	String encryptedMessage;

	char currentChar;
	char[] messageCharArr;

	JTextField encryptedMessageField;

	int newKeyConfirm;
	final String[] dialogChoices = { "Confirm", "Copy" };
	final String[] newKeyChoices = { "Confirm", "Get Key" };
	int dialogUserChoice;

	JTextArea keyArea;
	JScrollPane keyPane;

	final ImageIcon encryptIcon = new ImageIcon("encryptionPhoto.png");
	final ImageIcon decryptIcon = new ImageIcon("decryptionPhoto.png");
	final ImageIcon getKeyIcon = new ImageIcon("getKeyPhoto.png");
	final ImageIcon newKeyIcon = new ImageIcon("newKeyPhoto.png");
	final ImageIcon aboutProgramIcon = new ImageIcon("aboutProgramPhoto.png");

	public static void main(String[] args) {

		// TODO: recreate encryption program using Java Swing GUI components
		// TODO: export the program into a jar file with an icon
		// TODO: add music or background sounds to program
		new EncryptionProgramGUIMain();
		// TODO: add ImageIcon for our program

	}

	public EncryptionProgramGUIMain() {

		setLookAndFeel();
		createFrame();

	}

	public void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public void createFrame() {

		createNewKey(); // generates a new key

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
		mainPanel.setLayout(new GridLayout(8, 1, 0, 20)); // 6 rows, 1 column
		mainPanel.setBorder(new EmptyBorder(25, 400, 50, 400));

		// DONE: add titleLabel attributes
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
		programButtons = new JButton[7];

		newKeyButton = new JButton("New Key");
		newKeyButton.setIcon(newKeyIcon);

		getKeyButton = new JButton("Get Key");
		getKeyButton.setIcon(getKeyIcon);

		encryptMessageButton = new JButton("Encrypt Message");
		encryptMessageButton.setIcon(encryptIcon);

		decryptMessageButton = new JButton("Decrypt Message");
		decryptMessageButton.setIcon(decryptIcon);

		aboutProgramButton = new JButton("About Program");
		aboutProgramButton.setIcon(aboutProgramIcon);

		// TODO: add ASCII table icon an finish ascii table function
		asciiTableButton = new JButton("ASCII Table");
		exitProgramButton = new JButton("Exit");

		programButtons[0] = newKeyButton;
		programButtons[1] = getKeyButton;
		programButtons[2] = encryptMessageButton;
		programButtons[3] = decryptMessageButton;
		programButtons[4] = aboutProgramButton;
		programButtons[5] = asciiTableButton;
		programButtons[6] = exitProgramButton;

		for (int i = 0; i < programButtons.length; i++) {
			programButtons[i].addActionListener(this);
			programButtons[i].setFocusable(false);
			programButtons[i].setFont(PROGRAM_FONT);
			programButtons[i].setHorizontalAlignment(JButton.LEFT);
			programButtons[i].setBorder(new EmptyBorder(0, 50, 0, 0));
			programButtons[i].setIconTextGap(20);

			mainPanel.add(programButtons[i]);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == newKeyButton) {
			// newKey function
			newKey();
		}

		if (arg0.getSource() == getKeyButton) {
			// getKey function
			getKey();
		}

		if (arg0.getSource() == encryptMessageButton) {
			// encryptMessage function
			encryptMessage();
		}

		if (arg0.getSource() == decryptMessageButton) {
			// decryptMessage function
			decryptMessage();
		}

		if (arg0.getSource() == aboutProgramButton) {
			// aboutProgram function
			aboutProgram();
		}

		if (arg0.getSource() == asciiTableButton) {
			showAsciiTable();
		}

		if (arg0.getSource() == exitProgramButton) {
			// exitProgram function
			exitProgram();
		}

	}

	public void getKey() {

		currentKey = "";

		for (int i = 0; i < plainCharList.size(); i++) {
			currentKey += plainCharList.get(i) + "   " + shuffledCharList.get(i) + "\n";
		}

		JTextArea keyArea = new JTextArea(20, 20);
		keyArea.setText("Current Key:\n" + currentKey);
		keyArea.setEditable(false);

		JScrollPane keyPane = new JScrollPane(keyArea);
		keyPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		keyPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// TODO: add an option where the user can copy the key to their clip board
		JOptionPane.showMessageDialog(this, keyPane, "GET KEY", JOptionPane.INFORMATION_MESSAGE);

	}

	public void newKey() {

		// DONE: add confirmation message before generating a new key
		newKeyConfirm = JOptionPane.showConfirmDialog(this, "Create new key?", "NEW KEY CONFIRM",
				JOptionPane.YES_NO_OPTION);

		if (newKeyConfirm == JOptionPane.YES_OPTION) {
			// DONE: change into showOptionDialog and have getKey as one of the choices
			createNewKey();

			dialogUserChoice = JOptionPane.showOptionDialog(this, "New key generated", "NEW KEY MESSAGE",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, newKeyChoices, newKeyChoices[0]);

			if (dialogUserChoice == 1) {
				getKey();
			}

		}

	}

	public void createNewKey() {
		currentChar = ' ';
		plainCharList = new ArrayList<Character>();

		for (int i = 32; i < 127; i++) {
			plainCharList.add(currentChar++);
		}

		shuffledCharList = new ArrayList<Character>(plainCharList);
		// copies plainCharList to shuffledCharList
		Collections.shuffle(shuffledCharList); // shuffles shuffledCharList
	}

	public void encryptMessage() {

		plainMessage = JOptionPane.showInputDialog(this, "Enter message to be encrypted", "ENCRYPT MESSAGE",
				JOptionPane.QUESTION_MESSAGE);

		if (plainMessage != null) { // checks if plainMessage is empty
			encryptedMessage = "";
			messageCharArr = plainMessage.toCharArray();

			for (int i = 0; i < messageCharArr.length; i++) {
				for (int j = 0; j < plainCharList.size(); j++) {
					if (messageCharArr[i] == plainCharList.get(j)) {
						encryptedMessage += shuffledCharList.get(j);
					}
				}
			}

			showEncryptedMessage();

		}

	}

	public void showEncryptedMessage() {
		encryptedMessageField = new JTextField(encryptedMessage);
		encryptedMessageField.setEditable(false);

		dialogUserChoice = JOptionPane.showOptionDialog(this, "Encrypted Message:\n" + encryptedMessage,
				"ENCRYPTED MESSAGE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, dialogChoices,
				dialogChoices[0]);

		if (dialogUserChoice == 1) {
			JOptionPane.showMessageDialog(this, "Encrypted message copied to clipboard!", "COPY ENCRYPTED MESSAGE",
					JOptionPane.INFORMATION_MESSAGE);
			// Copying encrypted message into clip board, can now be pasted by user
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(encryptedMessage), null);
		}
	}

	public void decryptMessage() {

		encryptedMessage = JOptionPane.showInputDialog(this, "Enter message to be decrypted", "DECRYPT MESSAGE",
				JOptionPane.INFORMATION_MESSAGE);

		if (encryptedMessage != null) {
			plainMessage = "";
			messageCharArr = encryptedMessage.toCharArray();

			for (int i = 0; i < messageCharArr.length; i++) {
				for (int j = 0; j < shuffledCharList.size(); j++) {
					if (messageCharArr[i] == shuffledCharList.get(j)) {
						plainMessage += plainCharList.get(j);
					}
				}
			}

			showDecryptedMessage();

		}

	}

	public void showDecryptedMessage() {
		encryptedMessageField = new JTextField(plainMessage);
		encryptedMessageField.setEditable(false);

		dialogUserChoice = JOptionPane.showOptionDialog(this, "Decrypted Message:\n" + plainMessage,
				"ENCRYPTED MESSAGE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, dialogChoices,
				dialogChoices[0]);

		if (dialogUserChoice == 1) {
			JOptionPane.showMessageDialog(this, "Decrypted message copied to clipboard!", "COPY DECRYPTED MESSAGE",
					JOptionPane.INFORMATION_MESSAGE);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(plainMessage), null);
		}
	}

	// DONE: add an aboutProgram messageDialog that explains the functions of the
	// program
	public void aboutProgram() {
		JOptionPane.showMessageDialog(this,
				"ASCII Encryption Program\n(American Standard Code for Information Interchange)\n\nReplaces a character randomly with another character in an ASCII Table.",
				"ABOUT PROGRAM", JOptionPane.INFORMATION_MESSAGE);
	}

	// TODO: add another button that shows the ascii table
	public void showAsciiTable() {
		System.out.println("Testing");
	}

	public void exitProgram() {
		// DONE: add a confirmation prompt before closing program
		int exitConfirmChoice = JOptionPane.showConfirmDialog(this, "Exit?", "CONFIRM EXIT", JOptionPane.YES_NO_OPTION);
		if (exitConfirmChoice == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}

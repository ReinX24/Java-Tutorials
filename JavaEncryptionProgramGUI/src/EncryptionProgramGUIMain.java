
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.URL;

public class EncryptionProgramGUIMain extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L; // added to get rid of warning

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

	// DONE: find another icon for program, an icon with a more solid background
	URL encryptionProgramIconURL = getClass().getResource("encryptionProgramPhoto.png");
	URL encryptIconURL = getClass().getResource("encryptionPhoto.png");
	URL decryptIconURL = getClass().getResource("decryptionPhoto.png");
	URL getKeyIconURL = getClass().getResource("getKeyPhoto.png");
	URL newKeyIconURL = getClass().getResource("newKeyPhoto.png");
	URL aboutProgramIconURL = getClass().getResource("aboutProgramPhoto.png");
	URL asciiTableIconURL = getClass().getResource("asciiPhoto.png");
	URL exitIconURL = getClass().getResource("exitPhoto.png");

	final ImageIcon encryptionProgramIcon = new ImageIcon(encryptionProgramIconURL);
	final ImageIcon encryptIcon = new ImageIcon(encryptIconURL);
	final ImageIcon decryptIcon = new ImageIcon(decryptIconURL);
	final ImageIcon getKeyIcon = new ImageIcon(getKeyIconURL);
	final ImageIcon newKeyIcon = new ImageIcon(newKeyIconURL);
	final ImageIcon aboutProgramIcon = new ImageIcon(aboutProgramIconURL);
	final ImageIcon asciiTableIcon = new ImageIcon(asciiTableIconURL);
	final ImageIcon exitIcon = new ImageIcon(exitIconURL);

	String asciiTableValues;
	JTextArea asciiTableArea;
	JScrollPane asciiTablePane;

	AudioInputStream streamAudio;
	Clip audioClip;
	FloatControl gainControl;

	/*
	 * ADDING AUDIO INSTRUCTIONS:
	 * 
	 * - Separate the program's resources such as photos and audio in a folder
	 * outside src
	 * 
	 * - Go to properties, build path, and add these folders
	 * 
	 * - Once these folders are added, make sure you are using the URL, getClass,
	 * and getResouce functions for photos and audio
	 */

	final URL MENU_AUDIO_URL = getClass()
			.getResource("Zardonic ⧸ Superhot： Mind Control Delete OST： 01 - Hallway Alpha [HQ].X-L7HlCQ.wav");
	final URL BUTTON_CLICK_AUDIO_URL = getClass().getResource("Sound Effects - Atm cash machine key press [FREE].wav");
	final URL EXIT_PROGRAM_URL = getClass().getResource("Computer Boop - Sound Effect.wav");

	public static void main(String[] args) {

		// DONE: recreate encryption program using Java Swing GUI components
		// DONE: export the program into a jar file with an icon
		// DONE: add music or background sounds to program
		new EncryptionProgramGUIMain();
		// DONE: add ImageIcon for our program

	}

	public EncryptionProgramGUIMain() {

		setLookAndFeel();
		playProgramMenuAudio();
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

	public void playProgramMenuAudio() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(MENU_AUDIO_URL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			audioClip.loop(Clip.LOOP_CONTINUOUSLY);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-16.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playButtonPressedAudio() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(BUTTON_CLICK_AUDIO_URL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-16.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playExitProgramAudio() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(EXIT_PROGRAM_URL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-16.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void createFrame() {

		createNewKey(); // generates a new key

		this.setIconImage(encryptionProgramIcon.getImage()); // setting icon for our JFrame

		this.setTitle("Encryption Program");
		this.addKeyListener(this);
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

		// DONE: add icons for our JButtons? (to be tested if feasible)
		programButtons = new JButton[7];

		newKeyButton = new JButton("New Key");
		newKeyButton.setIcon(newKeyIcon);
		newKeyButton.setMnemonic(KeyEvent.VK_N); // adds an underline to a specified character

		getKeyButton = new JButton("Get Key");
		getKeyButton.setIcon(getKeyIcon);
		getKeyButton.setMnemonic(KeyEvent.VK_G);

		encryptMessageButton = new JButton("Encrypt Message");
		encryptMessageButton.setIcon(encryptIcon);
		encryptMessageButton.setMnemonic(KeyEvent.VK_E);

		decryptMessageButton = new JButton("Decrypt Message");
		decryptMessageButton.setIcon(decryptIcon);
		decryptMessageButton.setMnemonic(KeyEvent.VK_D);

		aboutProgramButton = new JButton("About Program");
		aboutProgramButton.setIcon(aboutProgramIcon);
		aboutProgramButton.setMnemonic(KeyEvent.VK_A);

		asciiTableButton = new JButton("ASCII Table");
		asciiTableButton.setIcon(asciiTableIcon);
		asciiTableButton.setMnemonic(KeyEvent.VK_I);

		exitProgramButton = new JButton("Exit");
		exitProgramButton.setIcon(exitIcon);
		exitProgramButton.setMnemonic(KeyEvent.VK_X);

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

		playButtonPressedAudio(); // button click sound when a button is pressed

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

		currentKey = "Current Key:\n";

		for (int i = 0; i < plainCharList.size(); i++) {
			currentKey += plainCharList.get(i) + "   " + shuffledCharList.get(i) + "\n";
		}

		keyArea = new JTextArea(20, 20);
		keyArea.setText(currentKey);
		keyArea.setEditable(false);
		keyArea.setCaretPosition(0); // start at the top of JTextArea

		keyPane = new JScrollPane(keyArea);
		keyPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		keyPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		dialogUserChoice = JOptionPane.showOptionDialog(this, keyPane, "GET KEY", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, dialogChoices, dialogChoices[0]);

		if (dialogUserChoice == 1) {
			JOptionPane.showMessageDialog(this, "Encryption key copied to clipboard!", "COPY ENCRYPTION KEY",
					JOptionPane.INFORMATION_MESSAGE);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(currentKey), null);
		}

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

	// DONE: add another button that shows the ASCII table
	public void showAsciiTable() {

		asciiTableValues = "ASCII Table Values:\nDec Chr\n";

		for (int i = 32; i < 127; i++) {
			asciiTableValues += i + "   " + (char) i + "\n";
		}

		asciiTableArea = new JTextArea(20, 20);
		asciiTableArea.setText(asciiTableValues);
		asciiTableArea.setEditable(false);
		asciiTableArea.setCaretPosition(0);

		asciiTablePane = new JScrollPane(asciiTableArea);
		asciiTablePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		asciiTablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JOptionPane.showMessageDialog(this, asciiTablePane, "ASCII TABLE", JOptionPane.INFORMATION_MESSAGE);

	}

	public void exitProgram() {
		// DONE: add a confirmation prompt before closing program
		int exitConfirmChoice = JOptionPane.showConfirmDialog(this, "Exit?", "CONFIRM EXIT", JOptionPane.YES_NO_OPTION);

		if (exitConfirmChoice == JOptionPane.YES_OPTION) {
			playExitProgramAudio();
			try {
				Thread.sleep(1000); // pause for 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyChar()) {

		case 'n':
			newKeyButton.doClick();
			break;

		case 'g':
			getKeyButton.doClick();
			break;

		case 'e':
			encryptMessageButton.doClick();
			break;

		case 'd':
			decryptMessageButton.doClick();
			break;

		case 'a':
			aboutProgramButton.doClick();
			break;

		case 'i':
			asciiTableButton.doClick();
			break;

		case 'x':
			exitProgramButton.doClick();
			break;

		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}

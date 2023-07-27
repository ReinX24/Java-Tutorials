import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class GameFrame extends JFrame implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel gamePanel;
	JLabel titleLabel;
	JLabel instructionsLabel;
	JLabel piLabel;
	JTextArea piTextArea;

	// 101 digits of Pi, including the first number before the decimal point
	String piValue = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
	int piStartIndex = 0;
	int piEndIndex = 1; // starts at 3
	int piScore = 0;
	boolean decimalPointAdded = false;
	JLabel scoreLabel;
	JButton skipButton;
	static JButton resetButton;
	JButton exitButton;

	final Color backgroundColor = new Color(27, 36, 64);
	final Color textAreaAndButtonColor = new Color(17, 20, 38);

	// Object from another class for our game audio
	GameAudio gameAudio = new GameAudio();
	// Object from another class for some of our option dialogs
	OptionPaneDialog optionDialog = new OptionPaneDialog();

	URL piGameIcon = getClass().getResource("piGameIcon.png");

	static int elapsedTime = 0;
	static int secondsPassed = 0;
	static int minutesPassed = 0;
	static int hoursPassed = 0;

	boolean hasStarted = false;

	static String secondsString = String.format("%02d", secondsPassed);
	static String minutesString = String.format("%02d", minutesPassed);
	static String hoursString = String.format("%02d", hoursPassed);

	static JLabel timerLabel = new JLabel(hoursString + ":" + minutesString + ":" + secondsString);

	static Timer myTimer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Timer object will execute functions in this block
			elapsedTime += 1000; // increase by 1 second (1000 milliseconds)
			hoursPassed = elapsedTime / 3600000; // 3600000 milliseconds in one hour
			minutesPassed = (elapsedTime / 60000) % 60; // 60000 milliseconds in one minute, modulo 60 so that if there
														// is a remainder, it is not included in the minutesPassed
														// String
			secondsPassed = (elapsedTime / 1000) % 60; // 1000 milliseconds in one second

			secondsString = String.format("%02d", secondsPassed); // 2 zeroes will be reserved for secondsString
			minutesString = String.format("%02d", minutesPassed);
			hoursString = String.format("%02d", hoursPassed);

			timerLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
		}

	});

	public GameFrame() {
		gameAudio.playBackgroundMusic();
		this.setTitle("Pi 101");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon(piGameIcon).getImage());

		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(1024, 768));
		gamePanel.setBackground(backgroundColor);
		gamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

		this.add(gamePanel);

		titleLabel = new JLabel("Pi 101", JLabel.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font(null, Font.BOLD, 32));
		titleLabel.setPreferredSize(new Dimension(1024, 32));

		gamePanel.add(titleLabel);

		instructionsLabel = new JLabel("Instructions: Type the first 101 digits of Pi!", JLabel.CENTER);
		instructionsLabel.setForeground(Color.WHITE);
		instructionsLabel.setFont(new Font(null, Font.PLAIN, 24));
		instructionsLabel.setPreferredSize(new Dimension(1024, 32));

		gamePanel.add(instructionsLabel);

		piTextArea = new JTextArea(12, 32);
		piTextArea.setBackground(textAreaAndButtonColor);
		piTextArea.setForeground(Color.WHITE);
		piTextArea.setLineWrap(true);
		piTextArea.setFont(new Font(null, Font.PLAIN, 24));
		piTextArea.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		piTextArea.setEditable(false);
		piTextArea.addKeyListener(this);

		gamePanel.add(piTextArea);

		scoreLabel = new JLabel("Score: " + piStartIndex, JLabel.CENTER);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setFont(new Font(null, Font.PLAIN, 24));
		scoreLabel.setPreferredSize(new Dimension(1024, 64));

		gamePanel.add(scoreLabel);

		skipButton = new JButton("Skip");
		skipButton.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		skipButton.setBackground(textAreaAndButtonColor);
		skipButton.setForeground(Color.WHITE);
		skipButton.addActionListener(this);
		skipButton.setFocusable(false);
		skipButton.setPreferredSize(new Dimension(256, 64));

		gamePanel.add(skipButton);

		resetButton = new JButton("Reset");
		resetButton.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		resetButton.setBackground(textAreaAndButtonColor);
		resetButton.setForeground(Color.WHITE);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		resetButton.setPreferredSize(new Dimension(256, 64));

		gamePanel.add(resetButton);

		exitButton = new JButton("Exit");
		exitButton.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		exitButton.setBackground(textAreaAndButtonColor);
		exitButton.setForeground(Color.WHITE);
		exitButton.addActionListener(this);
		exitButton.setFocusable(false);
		exitButton.setPreferredSize(new Dimension(256, 64));

		gamePanel.add(exitButton);

		// DONE: configure text in timerLabel to show the time properly
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		timerLabel.setOpaque(true);
		timerLabel.setBackground(textAreaAndButtonColor);
		timerLabel.setForeground(Color.WHITE);
		timerLabel.setPreferredSize(new Dimension(512, 64));

		gamePanel.add(timerLabel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		String pressedKey = String.valueOf(arg0.getKeyChar());
		// If the user already has typed in the 101 digits of Pi, print a message
		// telling them that they have already finished the game and asks them if they
		// would like to restart
		if (piScore == 101) {
			alreadyMaxScoreMessage();
		} else if (pressedKey.equals(piValue.substring(piStartIndex, piEndIndex)) && !pressedKey.equals(".")) {
			// Checks if the current entered key is the correct one for the current
			// position, also check if the entered key is not a decimal point
			piTextArea.append(pressedKey);
			piStartIndex++;
			piEndIndex++;
			piScore++;
			scoreLabel.setText("Score: " + piScore);
			myTimer.start(); // starts our timer
			// If the user finally reaches the 101th digit of Pi, print congratulations
			// message
			if (piScore == 101) {
				congratulationsMessage();
			}
		} else if (pressedKey.equals(".") && !decimalPointAdded) {
			// If the entered key is a decimal point and it has not been added yet
			piTextArea.append(pressedKey); // just add a period, not counted in score, not a digit
			decimalPointAdded = true;
			piStartIndex++;
			piEndIndex++;
		} else {
			// If the user does not type a number
			gameAudio.playWrongInputSound();
			JOptionPane.showMessageDialog(null, "Wrong input!", "Wrong Input Message", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void congratulationsMessage() {
		optionDialog.congratulationsMessage();
	}

	public void alreadyMaxScoreMessage() {
		optionDialog.alreadyMaxScoreMessage();
	}

	public void specialCongratulationsMessage() {
		optionDialog.specialCongratulationsMessage();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == skipButton) {
			// DONE: Add functionality where it skips to a certain decimal place
			SpinnerNumberModel piSpinnerValues = new SpinnerNumberModel(1, 1, 101, 1);
			JSpinner piValueSpinner = new JSpinner(piSpinnerValues);
			// Making our JSpinner not editable by the user
			((JSpinner.DefaultEditor) piValueSpinner.getEditor()).getTextField().setEditable(false);

			String[] skipValueOptions = { "Confirm", "Cancel" };
			int skipValueChoice = JOptionPane.showOptionDialog(null, piValueSpinner, "Enter Placement Skip Value",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, skipValueOptions, skipValueOptions[0]);

			// If the user chooses to skip the to a certain placement value
			if (skipValueChoice == 0) {
				// The current score will equal to the index of the skipped starting value
				piScore = (int) piValueSpinner.getValue();
				// Current expected character will now be the next value of the current index
				// Example: If the user chooses to start at index value 2, then it will start at
				// 3.1 and will expect 4 as the next value
				piStartIndex = piScore + 1;
				piEndIndex = piScore + 2;
				scoreLabel.setText("Score: " + piScore);
				piTextArea.setText(piValue.substring(0, piStartIndex));
				// If the score is greater than 1 but less than 101, play the normal skip sound
				if (piScore >= 1 && piScore < 101) {
					gameAudio.playSkipSound();
				} else if (piScore == 101) {
					// If the score is equal to 101, play congratulations sound instead and show
					// "special" congratulations message
					// DONE: add "special" congratulations message here
					specialCongratulationsMessage();
				} else if (piScore > 1) {
					// If the current skipped value is greater than 3., then set decimalPointAdded
					// to true since it will add the decimal to the JTextField when we skip
					decimalPointAdded = true;
				}
			}
		}

		if (arg0.getSource() == resetButton) {
			int confirmReset = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset your progress?",
					"Reset Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmReset == JOptionPane.YES_OPTION) {
				gameAudio.playResetSound();
				// Resetting text area, indexes, etc.
				piTextArea.setText("");
				piStartIndex = 0;
				piEndIndex = 1;
				piScore = 0;
				decimalPointAdded = false;
				scoreLabel.setText("Score: " + piScore);
				// Resetting timer values
				elapsedTime = 0;
				secondsPassed = 0;
				minutesPassed = 0;
				hoursPassed = 0;

				secondsString = String.format("%02d", secondsPassed);
				minutesString = String.format("%02d", minutesPassed);
				hoursString = String.format("%02d", hoursPassed);

				timerLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
				myTimer.stop();
			}
		}

		if (arg0.getSource() == exitButton) {
			optionDialog.askExitConfirmation();
		}
	}

}
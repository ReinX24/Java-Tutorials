import javax.sound.sampled.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer; // we need this import for our Timer object instead of the one from the util class

import java.awt.*;
import java.awt.event.*;
import java.io.*;
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
	JButton resetButton;
	JButton exitButton;

	final Color backgroundColor = new Color(27, 36, 64);
	final Color textAreaAndButtonColor = new Color(17, 20, 38);

	AudioInputStream streamAudio;
	Clip audioClip;
	FloatControl controlVolume;

	URL congratulationsSoundURL = getClass().getResource("congratulationsSound.wav");
	URL maxScoreSoundURL = getClass().getResource("maxScoreSound.wav");
	URL wrongInputSoundURL = getClass().getResource("wrongInput.wav");
	URL skipSoundURL = getClass().getResource("skipSound.wav");
	URL resetSoundURL = getClass().getResource("resetSound.wav");
	URL exitSoundURL = getClass().getResource("exitSound.wav");
	URL backgroundMusicURL = getClass().getResource("backgroundMusic.wav");

	URL piGameIcon = getClass().getResource("piGameIcon.png");

	int elapsedTime = 0;
	int secondsPassed = 0;
	int minutesPassed = 0;
	int hoursPassed = 0;

	boolean hasStarted = false;

	String secondsString = String.format("%02d", secondsPassed);
	String minutesString = String.format("%02d", minutesPassed);
	String hoursString = String.format("%02d", hoursPassed);

	JLabel timerLabel = new JLabel(hoursString + ":" + minutesString + ":" + secondsString);

	Timer myTimer = new Timer(1000, new ActionListener() {

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
		playBackgroundMusic();
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
			playWrongInputSound();
			JOptionPane.showMessageDialog(null, "Wrong input!", "Wrong Input Message", JOptionPane.WARNING_MESSAGE);
		}
	}

	// DONE: place congratulations message here
	public void congratulationsMessage() {
		playCongratsSound();
		myTimer.stop();
		// DONE: after saying congratulations, ask the user if they want to restart the
		// game or not
		String[] congratulationsOptions = { "Restart", "Cancel" };
		int congratulationsChoice = JOptionPane.showOptionDialog(null,
				"Congratulations! You have correctly entered the first 101 digits of Pi!\nRestart the game?",
				"Congratulations Message", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				congratulationsOptions, congratulationsOptions[0]);
		// If the user wishes to restart the game
		if (congratulationsChoice == 0) {
			resetButton.doClick();
		}
	}

	public void alreadyMaxScoreMessage() {
		// DONE: change message dialog into option dialog that asks if they want to
		// restart the game or not
		playMaxScoreSound();
		String[] maxScoreOptions = { "Restart", "Cancel" };
		int maxScoreChoice = JOptionPane.showOptionDialog(null, "101 digits of Pi already entered!",
				"Max Score Message", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, maxScoreOptions,
				maxScoreOptions[0]);
		// If the user chooses to restart the game
		if (maxScoreChoice == 0) {
			resetButton.doClick();
		}
	}

	// DONE: finish this function, similar to congratulations message but pokes fun
	// at the player for skipping immediately to the 101th place
	public void specialCongratulationsMessage() {
		playCongratsSound();
		String[] skipToEndOptions = { "Reset", "Cancel" };
		int skipToEndChoice = JOptionPane.showOptionDialog(null,
				"Congratulations for skipping to the last digit!\nRestart the game?", "Skip To End Message",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, skipToEndOptions,
				skipToEndOptions[0]);
		if (skipToEndChoice == 0) {
			resetButton.doClick();
		}
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
					playSkipSound();
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
				playResetSound();
				piTextArea.setText("");
				piStartIndex = 0;
				piEndIndex = 1;
				piScore = 0;
				decimalPointAdded = false;
				scoreLabel.setText("Score: " + piScore);

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
			playExitSound();
			int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation",
					JOptionPane.YES_NO_OPTION);
			if (confirmExit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

	}

	public void playBackgroundMusic() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(backgroundMusicURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-36.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playCongratsSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(congratulationsSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-12.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playMaxScoreSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(maxScoreSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-12.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playWrongInputSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(wrongInputSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-12.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playSkipSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(skipSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-12.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playResetSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(resetSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-12.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playExitSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(exitSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-12.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}
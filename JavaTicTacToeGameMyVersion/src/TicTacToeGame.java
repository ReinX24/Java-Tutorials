import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class TicTacToeGame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JLabel titleLabel = new JLabel();
	JLabel loadingLabel = new JLabel();

	JButton[] buttonsArr = new JButton[9];
	JPanel buttonsPanel = new JPanel();

	boolean playerOneTurn;

	Random randomNumberGen = new Random();

	AudioInputStream streamAudio;
	Clip audioClip;
	FloatControl gainControl;

	URL ticTacToeGameIconURL = getClass().getResource("ticTacToeGameIcon.png");

	URL buttonPressedSoundURL = getClass().getResource("buttonPressed.wav");
	URL winGameSoundURL = getClass().getResource("winGame.wav");

	public TicTacToeGame() {

		this.setTitle("Java Tic Tac Toe Game");
		this.setSize(900, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(ticTacToeGameIconURL).getImage());

		titleLabel.setText("Tic Tac Toe");
		titleLabel.setPreferredSize(new Dimension(900, 100));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font(null, Font.BOLD, 70));
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setBackground(Color.BLACK);
		titleLabel.setOpaque(true);

		this.add(titleLabel, BorderLayout.NORTH);

		loadingLabel.setText("Loading...");
		loadingLabel.setHorizontalAlignment(JLabel.CENTER);
		loadingLabel.setFont(new Font(null, Font.BOLD, 70));

		this.add(loadingLabel, BorderLayout.CENTER);

		this.setVisible(true);

		chooseRandomFirstPlayer();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		for (int i = 0; i < buttonsArr.length; i++) {

			if (playerOneTurn) {

				if (arg0.getSource() == buttonsArr[i] && buttonsArr[i].getText() == "") {
					buttonsArr[i].setText("X");
					buttonsArr[i].setForeground(new Color(0, 128, 128));
					playerOneTurn = false;
					titleLabel.setText("O turn");
					playButtonPressedSound();
				}

			} else {

				if (arg0.getSource() == buttonsArr[i] && buttonsArr[i].getText() == "") {
					buttonsArr[i].setText("O");
					buttonsArr[i].setForeground(new Color(255, 128, 0));
					playerOneTurn = true;
					titleLabel.setText("X turn");
					playButtonPressedSound();
				}

			}

			// Checks if either of the players meet the requirements to win
			checkIfWin();

		}

	}

	public void chooseRandomFirstPlayer() {

		try {
			Thread.sleep(2000);

			this.remove(loadingLabel); // removes Loading... text at the center of our JFrame

			buttonsPanel.setPreferredSize(new Dimension(900, 900));
			buttonsPanel.setBackground(Color.GRAY);
			buttonsPanel.setLayout(new GridLayout(3, 3));

			this.add(buttonsPanel);

			for (int i = 0; i < buttonsArr.length; i++) {
				buttonsArr[i] = new JButton();
				buttonsArr[i].addActionListener(this);
				buttonsArr[i].setFocusable(false);
				buttonsArr[i].setFont(new Font(null, Font.BOLD, 70));
				buttonsArr[i].setBorder(BorderFactory.createRaisedBevelBorder());

				buttonsPanel.add(buttonsArr[i]);
			}

			buttonsPanel.setVisible(false); // will show buttonsPanel after 2 seconds

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			buttonsPanel.setVisible(true);
		}

		// Generates a random number between 0 and 1
		// 0 : X first, 1 : O first
		if (randomNumberGen.nextInt(2) == 0) {
			titleLabel.setText("X turn");
			playerOneTurn = true;
		} else {
			titleLabel.setText("O turn");
			playerOneTurn = false;
		}

	}

	public void checkIfWin() {

		// Checking if either X or O wins

		// X horizontal
		if (buttonsArr[0].getText() == "X" && buttonsArr[1].getText() == "X" && buttonsArr[2].getText() == "X") {
			xWin(0, 1, 2);
		}
		if (buttonsArr[3].getText() == "X" && buttonsArr[4].getText() == "X" && buttonsArr[5].getText() == "X") {
			xWin(3, 4, 5);
		}
		if (buttonsArr[6].getText() == "X" && buttonsArr[7].getText() == "X" && buttonsArr[8].getText() == "X") {
			xWin(6, 7, 8);
		}

		// X vertical
		if (buttonsArr[0].getText() == "X" && buttonsArr[3].getText() == "X" && buttonsArr[6].getText() == "X") {
			xWin(0, 3, 6);
		}
		if (buttonsArr[1].getText() == "X" && buttonsArr[4].getText() == "X" && buttonsArr[7].getText() == "X") {
			xWin(1, 4, 7);
		}
		if (buttonsArr[2].getText() == "X" && buttonsArr[5].getText() == "X" && buttonsArr[8].getText() == "X") {
			xWin(2, 5, 8);
		}

		// X diagonal
		if (buttonsArr[0].getText() == "X" && buttonsArr[4].getText() == "X" && buttonsArr[8].getText() == "X") {
			xWin(0, 4, 8);
		}
		if (buttonsArr[2].getText() == "X" && buttonsArr[4].getText() == "X" && buttonsArr[6].getText() == "X") {
			xWin(2, 4, 6);
		}

		// O horizontal
		if (buttonsArr[0].getText() == "O" && buttonsArr[1].getText() == "O" && buttonsArr[2].getText() == "O") {
			oWin(0, 1, 2);
		}
		if (buttonsArr[3].getText() == "O" && buttonsArr[4].getText() == "O" && buttonsArr[5].getText() == "O") {
			oWin(3, 4, 5);
		}
		if (buttonsArr[6].getText() == "O" && buttonsArr[7].getText() == "O" && buttonsArr[8].getText() == "O") {
			oWin(6, 7, 8);
		}

		// O vertical
		if (buttonsArr[0].getText() == "O" && buttonsArr[3].getText() == "O" && buttonsArr[6].getText() == "O") {
			oWin(0, 3, 6);
		}
		if (buttonsArr[1].getText() == "O" && buttonsArr[4].getText() == "O" && buttonsArr[7].getText() == "O") {
			oWin(1, 4, 7);
		}
		if (buttonsArr[2].getText() == "O" && buttonsArr[5].getText() == "O" && buttonsArr[8].getText() == "O") {
			oWin(2, 5, 8);
		}

		// O diagonal
		if (buttonsArr[0].getText() == "O" && buttonsArr[4].getText() == "O" && buttonsArr[8].getText() == "O") {
			oWin(0, 4, 8);
		}
		if (buttonsArr[2].getText() == "O" && buttonsArr[4].getText() == "O" && buttonsArr[6].getText() == "O") {
			oWin(2, 4, 6);
		}
	}

	public void xWin(int x, int y, int z) {
		buttonsArr[x].setBackground(Color.GREEN);
		buttonsArr[y].setBackground(Color.GREEN);
		buttonsArr[z].setBackground(Color.GREEN);

		for (int i = 0; i < buttonsArr.length; i++) {
			buttonsArr[i].setForeground(Color.GRAY);
			buttonsArr[i].setEnabled(false);
		}

		titleLabel.setText("X wins!");

		// DONE: restart function not working properly, the option pane shows again when
		// we click restart
		askRestartOrExit("Player X wins!");

	}

	public void oWin(int x, int y, int z) {
		buttonsArr[x].setBackground(Color.GREEN);
		buttonsArr[y].setBackground(Color.GREEN);
		buttonsArr[z].setBackground(Color.GREEN);

		for (int i = 0; i < buttonsArr.length; i++) {
			buttonsArr[i].setForeground(Color.GRAY);
			buttonsArr[i].setEnabled(false);
		}

		titleLabel.setText("O wins!");
		askRestartOrExit("Player O wins!");

	}

	public void askRestartOrExit(String winnerMessage) {

		playWinSound();

		String[] askChoices = { "Restart", "Exit" };
		int userChoice = JOptionPane.showOptionDialog(null, winnerMessage + "\nRestart or Exit Game?",
				"Restart / Exit Game", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, askChoices, null);

		if (userChoice == JOptionPane.YES_OPTION) {
			this.dispose(); // disposes our current JFrame
			// Resetting the text in our JButtons
			for (int i = 0; i < buttonsArr.length; i++) {
				buttonsArr[i].setText("");
			}
			// Creating a new TicTacToeGame JFrame
			new TicTacToeGame();
		}

		if (userChoice == JOptionPane.NO_OPTION) {
			System.exit(0);
		}

	}

	public void playButtonPressedSound() {

		// Gets the audio file
		try {
			streamAudio = AudioSystem.getAudioInputStream(buttonPressedSoundURL);
			// Clip object to get audio file & use methods on file
			audioClip = AudioSystem.getClip();
			// Opens the clip, now we could use methods on audioClip
			audioClip.open(streamAudio);
			// Lowering the volume of our main menu music
			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		audioClip.start();
	}

	public void playWinSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(winGameSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		audioClip.start();
	}

}

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PongGameSettingsMenu extends JPanel implements ActionListener {

	JFrame settingsFrame;
	JLabel settingsTitleLabel;

	JButton changeGameScoreButton;
	JButton exitMainMenu;

	JButton pOneColorChangeButton;
	JButton pTwoColorChangeButton;
	JButton resetColorsButton;

	JButton changePlayerOneNameButton;
	JButton changePlayerTwoNameButton;

	JButton exitSettingsMenuButton;

	final Color SETTINGSMENU_BACKGROUND_COLOR = new Color(218, 165, 32);

	final File SETTINGS_MENU_MUSIC = new File("8 Bit Think! Calm Puzzle Chiptune Game Music by HeatleyBros.wav");

	AudioInputStream streamAudio;
	Clip audioClip;

	final SpinnerModel gameScoreSpinnerValues = new SpinnerNumberModel(3, 1, 10, 1);
	// initial score, lowest, highest, increments per click
	JSpinner gameScoreSpinner;

	public PongGameSettingsMenu() {

		settingsFrame = new JFrame("Pong Game Settings");
		settingsFrame.setResizable(false);
		settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addSettingsComponents();
		playSettingsMenuMusic();
		addSettingsButtons();

		settingsFrame.pack();
		settingsFrame.setLocationRelativeTo(null);
		settingsFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == changeGameScoreButton) {
			changeGameScore();
		}

		if (arg0.getSource() == pOneColorChangeButton) {
			changePaddleOneColor();
		}

		if (arg0.getSource() == pTwoColorChangeButton) {
			changePaddleTwoColor();
		}

		if (arg0.getSource() == resetColorsButton) {
			resetAllPaddleColors();
		}

		if (arg0.getSource() == exitSettingsMenuButton) {
			exitSettingsMenu();
		}

		if (arg0.getSource() == changePlayerOneNameButton) {
			PongGamePlay.playerOneName = JOptionPane.showInputDialog(this, "Enter New Name",
					PongGamePlay.playerOneName);
			changePlayerOneNameButton.setText("Change Name: " + PongGamePlay.playerOneName);
		}
		
		if (arg0.getSource() == changePlayerTwoNameButton) {
			PongGamePlay.playerTwoName = JOptionPane.showInputDialog(this, "Enter New Name",
					PongGamePlay.playerTwoName);
			changePlayerTwoNameButton.setText("Change Name: " + PongGamePlay.playerTwoName);
		}

	}

	public void changeGameScore() {
		gameScoreSpinner = new JSpinner(gameScoreSpinnerValues);
		gameScoreSpinner.setPreferredSize(new Dimension(300, 100));
		gameScoreSpinner.setEditor(new JSpinner.DefaultEditor(gameScoreSpinner)); // make JSpinner not editable

		String[] changeGameScoreChoices = { "Confirm", "Cancel" };
		int changeGameScore = JOptionPane.showOptionDialog(this, gameScoreSpinner, "Game Score",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, changeGameScoreChoices, null);

		if (changeGameScore == JOptionPane.YES_OPTION) {
			PongGamePlay.winnerScore = (int) gameScoreSpinner.getValue();
			changeGameScoreButton.setText("Change Score Limit: " + PongGamePlay.winnerScore);
		}
	}

	public void changePaddleOneColor() {
		new JColorChooser();
		Paddle.bluePaddle = JColorChooser.showDialog(this, "Pick A Color", new Color(172, 58, 62));
	}

	public void changePaddleTwoColor() {
		new JColorChooser();
		Paddle.redPaddle = JColorChooser.showDialog(this, "Pick A Color", new Color(69, 91, 132));
	}

	public void resetAllPaddleColors() {
		int resetPaddleChoice = JOptionPane.showConfirmDialog(this, "Reset Paddle Colors?", "Reset Paddle Colors",
				JOptionPane.YES_NO_OPTION);

		if (resetPaddleChoice == JOptionPane.YES_OPTION) {
			Paddle.bluePaddle = new Color(172, 58, 62);
			Paddle.redPaddle = new Color(69, 91, 132);
		}

	}

	public void exitSettingsMenu() {
		settingsFrame.dispose();
		audioClip.stop();
		new PongGameMainMenu();
	}

	public void addSettingsComponents() {
		addFrameIcon();
		addSettingsDetails();
		addSettingsTitle();
	}

	public void addSettingsButtons() {
		addScoreButton();
		addChangeOnePaddleColor();
		addChangeTwoPaddleColor();
		addResetColorsButton();
		addChangePlayerOneNameButton();
		addChangePlayerTwoNameButton();
		addExitButton();
	}

	public void addSettingsDetails() {
		this.setPreferredSize(PongGamePlay.SCREEN_SIZE);
		this.setLayout(new GridLayout(8, 1, 0, 10));
		this.setBorder(new EmptyBorder(50, 300, 50, 300));
		this.setBackground(SETTINGSMENU_BACKGROUND_COLOR);
		settingsFrame.add(this);
	}

	public void addFrameIcon() {
		settingsFrame.setIconImage(PongGameMainMenu.PONG_ICON.getImage());
	}

	public void addSettingsTitle() {
		settingsTitleLabel = new JLabel("SETTINGS", JLabel.CENTER);
		settingsTitleLabel.setForeground(PongGameMainMenu.FONT_COLOR);
		settingsTitleLabel.setFont(PongGameMainMenu.TITLE_FONT);
		this.add(settingsTitleLabel);
	}

	public void addScoreButton() {
		changeGameScoreButton = new JButton("Change Score Limit: " + PongGamePlay.winnerScore);
		createButton(changeGameScoreButton);
	}

	public void addChangeOnePaddleColor() {
		pOneColorChangeButton = new JButton("Change " + PongGamePlay.playerOneName + " Paddle Color");
		createButton(pOneColorChangeButton);
	}

	public void addChangeTwoPaddleColor() {
		pTwoColorChangeButton = new JButton("Change " + PongGamePlay.playerTwoName + " Paddle Color");
		createButton(pTwoColorChangeButton);
	}

	public void addResetColorsButton() {
		resetColorsButton = new JButton("Reset Paddle Colors");
		createButton(resetColorsButton);
	}

	public void addChangePlayerOneNameButton() {
		changePlayerOneNameButton = new JButton("Change Name: " + PongGamePlay.playerOneName);
		createButton(changePlayerOneNameButton);
	}

	public void addChangePlayerTwoNameButton() {
		changePlayerTwoNameButton = new JButton("Change Name: " + PongGamePlay.playerTwoName);
		createButton(changePlayerTwoNameButton);
	}

	public void addExitButton() {
		exitSettingsMenuButton = new JButton("Exit To Main Menu");
		createButton(exitSettingsMenuButton);
	}

	public void createButton(JButton paraButton) {
		paraButton.addActionListener(this);
		paraButton.setFocusable(false);
		paraButton.setFont(PongGameMainMenu.BUTTON_FONT);
		paraButton.setForeground(PongGameMainMenu.FONT_COLOR);
		paraButton.setBackground(PongGameMainMenu.BUTTON_COLOR);
		this.add(paraButton);
	}

	public void playSettingsMenuMusic() {

		try {
			streamAudio = AudioSystem.getAudioInputStream(SETTINGS_MENU_MUSIC);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			
			FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);
			
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

}

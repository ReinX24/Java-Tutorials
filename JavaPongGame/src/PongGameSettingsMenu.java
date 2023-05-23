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

	JButton changeTableColorButton;
	JButton resetTableColorButton;

	JButton changeBallColorButton;
	JButton resetBallColorButton;

	JButton settingsResetButton;

	JButton exitSettingsMenuButton;

	JPanel settingsMenuButtonsPanel;

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

		playSettingsMenuMusic();
		addSettingsComponents();
		addSettingsMenuButtonsPanel();
		addSettingsButtons();

		settingsFrame.pack();
		settingsFrame.setLocationRelativeTo(null);
		settingsFrame.setVisible(true);
	}

	public void addSettingsComponents() {
		addFrameIcon();
		addSettingsDetails();
		addSettingsTitle();
	}

	public void addSettingsButtons() {
		addScoreButton();
		addResetColorsButton();
		addChangeOnePaddleColorButton();
		addChangeTwoPaddleColorButton();
		addChangePlayerOneNameButton();
		addChangePlayerTwoNameButton();
		addChangeTableColorButton();
		addResetTableColorButton();
		addChangeBallColorButton();
		addResetBallColorButton();
		addSettingsResetButton();
		addExitButton();
	}

	public void addFrameIcon() {
		settingsFrame.setIconImage(PongGameMainMenu.PONG_ICON.getImage());
	}

	public void addSettingsDetails() {
		this.setPreferredSize(PongGamePlay.SCREEN_SIZE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBackground(SETTINGSMENU_BACKGROUND_COLOR);
		settingsFrame.add(this);
	}

	public void addSettingsTitle() {
		settingsTitleLabel = new JLabel("SETTINGS", JLabel.CENTER);
		settingsTitleLabel.setForeground(PongGameMainMenu.FONT_COLOR);
		settingsTitleLabel.setFont(PongGameMainMenu.TITLE_FONT);
		settingsTitleLabel.setPreferredSize(new Dimension(1000, 120));
		this.add(settingsTitleLabel); // adding our title to our JPanel
	}

	public void addSettingsMenuButtonsPanel() { // JPanel that will contain our JButtons
		settingsMenuButtonsPanel = new JPanel();
		settingsMenuButtonsPanel.setLayout(new GridLayout(6, 2, 10, 10));
		settingsMenuButtonsPanel.setPreferredSize(new Dimension(1000, 370));
		settingsMenuButtonsPanel.setBorder(new EmptyBorder(0, 150, 0, 150));
		settingsMenuButtonsPanel.setBackground(SETTINGSMENU_BACKGROUND_COLOR);
		this.add(settingsMenuButtonsPanel); // adding JPanel that will contain our JButtons
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

		if (arg0.getSource() == changePlayerOneNameButton) {
			changePlayerOneName();
		}

		if (arg0.getSource() == changePlayerTwoNameButton) {
			changePlayerTwoName();
		}

		if (arg0.getSource() == changeTableColorButton) {
			changeTableColor();
		}

		if (arg0.getSource() == resetTableColorButton) {
			resetTableColor();
		}

		if (arg0.getSource() == settingsResetButton) {
			System.out.println("Game Settings Reset");
		}

		if (arg0.getSource() == changeBallColorButton) {
			changeBallColor();
		}

		if (arg0.getSource() == resetBallColorButton) {
			resetBallColor();
		}

		if (arg0.getSource() == exitSettingsMenuButton) {
			exitSettingsMenu();
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

	public void changePlayerOneName() {
		PongGamePlay.playerOneName = JOptionPane.showInputDialog(this, "Enter New Name", PongGamePlay.playerOneName);
		changePlayerOneNameButton.setText("Change Name: " + PongGamePlay.playerOneName);
	}

	public void changePlayerTwoName() {
		PongGamePlay.playerTwoName = JOptionPane.showInputDialog(this, "Enter New Name", PongGamePlay.playerTwoName);
		changePlayerTwoNameButton.setText("Change Name: " + PongGamePlay.playerTwoName);
	}

	public void changeTableColor() {
		new JColorChooser();
		PongGamePlay.TABLE_COLOR = JColorChooser.showDialog(this, "Pick A Color", new Color(119, 176, 83));
	}

	public void resetTableColor() {
		int resetPaddleChoice = JOptionPane.showConfirmDialog(this, "Reset Table Color?", "Reset Table Color",
				JOptionPane.YES_NO_OPTION);

		if (resetPaddleChoice == JOptionPane.YES_OPTION) {
			PongGamePlay.TABLE_COLOR = new Color(119, 176, 83);
		}

	}

	public void changeBallColor() {
		new JColorChooser();
		Ball.BALL_COLOR = JColorChooser.showDialog(this, "Pick A Color", Color.WHITE);
	}

	public void resetBallColor() {
		int resetBallColorChoice = JOptionPane.showConfirmDialog(this, "Reset Ball Color?", "Reset Ball Color",
				JOptionPane.YES_NO_OPTION);

		if (resetBallColorChoice == JOptionPane.YES_OPTION) {
			Ball.BALL_COLOR = Color.WHITE;
		}
	}

	public void resetSettings() { // TODO: Implement button that resets all settings to default

	}

	public void exitSettingsMenu() {
		settingsFrame.dispose();
		audioClip.stop();
		new PongGameMainMenu();
	}

	public void addScoreButton() {
		changeGameScoreButton = new JButton("Change Score Limit: " + PongGamePlay.winnerScore);
		createButton(changeGameScoreButton);
	}

	public void addChangeOnePaddleColorButton() {
		pOneColorChangeButton = new JButton("Change " + PongGamePlay.playerOneName + " Paddle Color");
		createButton(pOneColorChangeButton);
	}

	public void addChangeTwoPaddleColorButton() {
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

	public void addChangeTableColorButton() {
		changeTableColorButton = new JButton("Change Table Color");
		createButton(changeTableColorButton);
	}

	public void addResetTableColorButton() {
		resetTableColorButton = new JButton("Reset Table Color");
		createButton(resetTableColorButton);
	}

	public void addChangeBallColorButton() {
		changeBallColorButton = new JButton("Change Ball Color");
		createButton(changeBallColorButton);
	}

	public void addResetBallColorButton() {
		resetBallColorButton = new JButton("Reset Ball Color");
		createButton(resetBallColorButton);
	}

	public void addSettingsResetButton() {
		settingsResetButton = new JButton("Reset All Settings");
		createButton(settingsResetButton);
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
		settingsMenuButtonsPanel.add(paraButton);
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

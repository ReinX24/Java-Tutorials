import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

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

	JButton exitButton;
	JButton confirmChangesButton;

	public PongGameSettingsMenu() {
		settingsFrame = new JFrame("Pong Game Settings");
		settingsFrame.setResizable(false);
		settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addSettingsComponents();
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

		if (arg0.getSource() == exitButton) {
			exitSettingsMenu();
		}

	}

	public void changeGameScore() {
		try {
			PongGamePlay.winnerScore = Integer.parseInt(JOptionPane.showInputDialog(this,
					"Current Max Score: " + PongGamePlay.winnerScore + "\nEnter New Max Score"));
			changeGameScoreButton.setText("Change Score Limit: " + PongGamePlay.winnerScore);
		} catch (InputMismatchException e) { // if a String is entered instead of a number
			JOptionPane.showMessageDialog(this, "Error Occurred!");
		} catch (NumberFormatException e) { // if nothing is typed in
			// Do nothing
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
		addExitButton();
	}

	public void addSettingsDetails() {
		this.setPreferredSize(PongGamePlay.SCREEN_SIZE);
		this.setLayout(new GridLayout(6, 1, 0, 25));
		this.setBorder(new EmptyBorder(50, 300, 50, 300));
		this.setBackground(PongGameMainMenu.BACKGROUND_COLOR);
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
		pOneColorChangeButton = new JButton("Change Player 1 Paddle Color");
		createButton(pOneColorChangeButton);
	}

	public void addChangeTwoPaddleColor() {
		pTwoColorChangeButton = new JButton("Change Player 2 Paddle Color");
		createButton(pTwoColorChangeButton);
	}

	public void addResetColorsButton() {
		resetColorsButton = new JButton("Reset Paddle Colors");
		createButton(resetColorsButton);
	}

	public void addExitButton() {
		exitButton = new JButton("Exit To Main Menu");
		createButton(exitButton);
	}

	public void createButton(JButton paraButton) {
		paraButton.addActionListener(this);
		paraButton.setFocusable(false);
		paraButton.setFont(PongGameMainMenu.BUTTON_FONT);
		paraButton.setForeground(PongGameMainMenu.FONT_COLOR);
		paraButton.setBackground(PongGameMainMenu.BUTTON_COLOR);
		paraButton.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(paraButton);
	}

}

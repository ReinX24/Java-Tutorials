import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PongGameSettingsMenu extends JPanel implements ActionListener {

	JFrame settingsFrame;
	JLabel settingsTitleLabel;

	JButton changeGameScore;
	JButton exitMainMenu;

	JLabel pOneLabel;
	JLabel pTwoLabel;

	JPanel pOneColorPanel;
	JPanel pTwoColorPanel;

	JButton pOneColorChange;
	JButton pTwoColorChange;

	JButton exitButton;
	JButton confirmChangesButton;
	JButton resetButton;

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

		if (arg0.getSource() == changeGameScore) {

			try {
				PongGamePlay.winnerScore = Integer.parseInt(JOptionPane.showInputDialog(this,
						"Current Max Score: " + PongGamePlay.winnerScore + "\nEnter New Max Score"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error Occurred!");
			}
			
		}
		
		if (arg0.getSource() == exitButton) {
			settingsFrame.dispose();
			new PongGameMainMenu();
		}

	}

	public void addSettingsComponents() {
		addSettingsDetails();
		addSettingsTitle();
	}

	public void addSettingsDetails() {
		this.setPreferredSize(PongGamePlay.SCREEN_SIZE);
		this.setLayout(new GridLayout(6, 1, 0, 25));
		this.setBorder(new EmptyBorder(50, 300, 50, 300));
		this.setBackground(PongGameMainMenu.BACKGROUND_COLOR);
		settingsFrame.add(this);
	}

	public void addSettingsTitle() {
		settingsTitleLabel = new JLabel("SETTINGS", JLabel.CENTER);
		settingsTitleLabel.setForeground(PongGameMainMenu.FONT_COLOR);
		settingsTitleLabel.setFont(PongGameMainMenu.TITLE_FONT);
		this.add(settingsTitleLabel);
	}

	public void addSettingsButtons() {
		addScoreButton();
		addExitButton();
	}

	public void addScoreButton() {
		changeGameScore = new JButton("Change Score Limit");
		createButton(changeGameScore);
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

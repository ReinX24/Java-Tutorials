import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PongGameMainMenu extends JPanel implements ActionListener {

	static final Font TITLE_FONT = new Font("Arial", Font.ITALIC, 48);
	static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 16);

	static final Color BACKGROUND_COLOR = new Color(0, 128, 128);
	static final Color FONT_COLOR = new Color(238, 238, 238);
	static final Color BUTTON_COLOR = new Color(57, 62, 70);

	static final ImageIcon PONG_ICON = new ImageIcon("pongGameIcon.png");

	JFrame menuFrame;

	JLabel titleLabel;

	JButton playButton;
	JButton settingsButton;
	JButton instructionsButton;
	JButton aboutButton;
	JButton exitButton;

	public PongGameMainMenu() {
		menuFrame = new JFrame("Pong Game Menu");
		menuFrame.setResizable(true);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addMenuDetails();
		addMenuButtons();

		menuFrame.pack();
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == playButton) {
			playPongGame();
		}

		if (arg0.getSource() == settingsButton) {
			gameSettingsMenu();
		}

		if (arg0.getSource() == instructionsButton) {
			gameInstructions();
		}

		if (arg0.getSource() == aboutButton) {
			gameAbout();
		}

		if (arg0.getSource() == exitButton) {
			gameExit();
		}

	}

	public void playPongGame() {
		menuFrame.dispose();
		new PongGamePlay(); // calling our PongGameFrame constructor
	}

	public void gameSettingsMenu() {
		menuFrame.dispose();
		new PongGameSettingsMenu();
	}

	public void gameInstructions() {
		JOptionPane.showMessageDialog(null,
				"- Instructions -\nBackspace to Exit Game\n\nPlayer One:\nW to go Up\nS to go Down\n\nPlayer Two:\n↑ to go Up\n↓ to go Down");
	}

	public void gameAbout() {
		JOptionPane.showMessageDialog(menuFrame,
				"- Java Pong Game -" + "\nBy:\nRein Solis" + "\nJholichi Tempra" + "\nVino Supnet" + "\nJesus Agustin",
				"About", JOptionPane.INFORMATION_MESSAGE);
	}

	public void gameExit() {
		int userChoice = JOptionPane.showConfirmDialog(menuFrame, "Are you sure you want to exit Pong?",
				"Exit Confirmation", JOptionPane.YES_NO_OPTION);
		if (userChoice == JOptionPane.YES_OPTION) {
			menuFrame.dispose(); // close our menuFrame
		}
	}

	public void addMenuDetails() {
		addFrameIcon();
		addMenuPanel();
		addTitleLabel();
	}

	public void addMenuButtons() {
		addPlayButton();
		addSettingsButton();
		addInstructionsButton();
		addAboutButton();
		addExitButton();
	}

	public void addMenuPanel() {
		this.setPreferredSize(PongGamePlay.SCREEN_SIZE);
		this.setLayout(new GridLayout(6, 1, 0, 25));
		this.setBorder(new EmptyBorder(50, 300, 50, 300));
		this.setBackground(BACKGROUND_COLOR);
		menuFrame.add(this);
	}

	public void addFrameIcon() {
		menuFrame.setIconImage(PONG_ICON.getImage());
	}

	public void addTitleLabel() {
		titleLabel = new JLabel("PONG");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(TITLE_FONT);
		titleLabel.setForeground(FONT_COLOR);
		this.add(titleLabel);
	}

	public void addPlayButton() {
		playButton = new JButton("Play Pong!");
		createButton(playButton);
	}

	public void addSettingsButton() {
		settingsButton = new JButton("Settings");
		createButton(settingsButton);
	}

	public void addInstructionsButton() {
		instructionsButton = new JButton("Instructions");
		createButton(instructionsButton);
	}

	public void addAboutButton() {
		aboutButton = new JButton("About");
		createButton(aboutButton);
	}

	public void addExitButton() {
		exitButton = new JButton("Exit");
		createButton(exitButton);
	}

	public void createButton(JButton paraButton) {
		paraButton.addActionListener(this);
		paraButton.setFocusable(false);
		paraButton.setFont(BUTTON_FONT);
		paraButton.setForeground(FONT_COLOR);
		paraButton.setBackground(BUTTON_COLOR);
		paraButton.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(paraButton);
	}

}

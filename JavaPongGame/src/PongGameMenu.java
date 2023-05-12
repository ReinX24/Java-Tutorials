import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PongGameMenu extends JFrame implements ActionListener {

	JPanel menuPanel;

	JLabel titleLabel;

	JButton playButton;
	JButton settingsButton;
	JButton instructionsButton;
	JButton aboutButton;
	JButton exitButton;

	final Font titleFont = new Font("Arial", Font.BOLD, 48);
	final Font buttonFont = new Font("Arial", Font.BOLD, 16);

	final Color backgroundColor = new Color(0, 128, 128);
	final Color fontColor = new Color(238, 238, 238);
	final Color buttonColor = new Color(57, 62, 70);

	static ImageIcon PONG_ICON = new ImageIcon("pongGameIcon.png");

	public PongGameMenu() {
		createMenuPanel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == playButton) {
			new PongGameFrame(); // calling our PongGameFrame constructor
		}
		
		if (arg0.getSource() == instructionsButton) {
			JOptionPane.showMessageDialog(null, "- Instructions -\nPlayer One:\nW to go Up\nS to go Down\n\nPlayer Two:\n↑ to go Up\n↓ to go Down");
		}

		if (arg0.getSource() == aboutButton) {
			JOptionPane.showMessageDialog(this,
					"- Java Pong Game -" + "\nRein Solis" + "\nJholichi Tempra" + "\nVino Supnet" + "\nJesus Agustin",
					"About", JOptionPane.INFORMATION_MESSAGE);
		}
		
		// TODO : add JColorChooser and Max Points functionality for settingsButton

		if (arg0.getSource() == exitButton) {
			int userChoice = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit Pong?",
					"Exit Confirmation", JOptionPane.YES_NO_OPTION);
			if (userChoice == JOptionPane.YES_OPTION) {
				this.dispose();
			}
		}

	}

	public void createMenuPanel() {
		this.setTitle("Pong Game Menu");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addFrameIcon();
		addMenuPanel();
		addTitleLabel();
		addPlayButton();
		addSettingsButton();
		addInstructionsButton();
		addAboutButton();
		addExitButton();

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addMenuPanel() {
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(PongGamePanel.SCREEN_SIZE);
		menuPanel.setLayout(new GridLayout(6, 1, 0, 25));
		menuPanel.setBorder(new EmptyBorder(50, 300, 50, 300));
		menuPanel.setBackground(backgroundColor);
		this.add(menuPanel);
	}

	public void addFrameIcon() {
		this.setIconImage(PONG_ICON.getImage());
	}

	public void addTitleLabel() {
		titleLabel = new JLabel("-◉ PONG ◉-");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(fontColor);
		menuPanel.add(titleLabel);
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
		paraButton.setFont(buttonFont);
		paraButton.setForeground(fontColor);
		paraButton.setBackground(buttonColor);
		paraButton.setBorder(BorderFactory.createRaisedBevelBorder());
		menuPanel.add(paraButton);
	}

}

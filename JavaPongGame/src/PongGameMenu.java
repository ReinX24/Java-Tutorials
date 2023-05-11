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

	final Font titleFont = new Font("Arial", Font.BOLD, 32);
	final Font buttonFont = new Font("Arial", Font.PLAIN, 16);

	static ImageIcon PONG_ICON = new ImageIcon("pongGameIcon.png");

	public PongGameMenu() {
		createMenuPanel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == playButton) {
			new PongGameFrame(); // calling our PongGameFrame constructor
		}

		if (arg0.getSource() == aboutButton) {
			JOptionPane.showMessageDialog(this, "Pong Game by:"
					+ "\n\tRein Solis"
					+ "\n\tJholichi Tempra"
					+ "\n\tVino Supnet"
					+ "\n\tJesus Agustin", "About", JOptionPane.INFORMATION_MESSAGE);
		}

		if (arg0.getSource() == exitButton) {
			this.dispose();
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
		this.add(menuPanel);
	}

	public void addFrameIcon() {
		this.setIconImage(PONG_ICON.getImage());
	}

	public void addTitleLabel() {
		titleLabel = new JLabel("PONG");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.BLACK);
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
		menuPanel.add(paraButton);
	}

}

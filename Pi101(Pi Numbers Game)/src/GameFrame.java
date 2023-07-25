import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

	public GameFrame() {
		this.setTitle("Pi 101");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(1024, 768));
		gamePanel.setBackground(new Color(27, 36, 64));
		gamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

		this.add(gamePanel);

		titleLabel = new JLabel("Pi 101", JLabel.CENTER);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font(null, Font.BOLD, 32));
		titleLabel.setPreferredSize(new Dimension(1024, 64));

		gamePanel.add(titleLabel);

		instructionsLabel = new JLabel("Instructions: Type the first 101 digits of Pi", JLabel.CENTER);
		instructionsLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		instructionsLabel.setForeground(Color.WHITE);
		instructionsLabel.setFont(new Font(null, Font.PLAIN, 24));
		instructionsLabel.setPreferredSize(new Dimension(1024, 64));

		gamePanel.add(instructionsLabel);

		piTextArea = new JTextArea(12, 32);
		piTextArea.setBackground(new Color(17, 20, 38));
		piTextArea.setForeground(Color.WHITE);
		piTextArea.setLineWrap(true);
		piTextArea.setFont(new Font(null, Font.PLAIN, 24));
		piTextArea.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		piTextArea.setEditable(false);
		piTextArea.addKeyListener(this);

		gamePanel.add(piTextArea);

		scoreLabel = new JLabel("Score: " + piStartIndex, JLabel.CENTER);
		scoreLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setFont(new Font(null, Font.PLAIN, 24));
		scoreLabel.setPreferredSize(new Dimension(1024, 64));

		gamePanel.add(scoreLabel);

		skipButton = new JButton("Skip");
		skipButton.setBorder(BorderFactory.createLineBorder(Color.RED));
		skipButton.addActionListener(this);
		skipButton.setFocusable(false);
		skipButton.setPreferredSize(new Dimension(256, 64));

		gamePanel.add(skipButton);

		resetButton = new JButton("Reset");
		resetButton.setBorder(BorderFactory.createLineBorder(Color.RED));
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		resetButton.setPreferredSize(new Dimension(256, 64));

		gamePanel.add(resetButton);

		exitButton = new JButton("Exit");
		exitButton.setBorder(BorderFactory.createLineBorder(Color.RED));
		exitButton.addActionListener(this);
		exitButton.setFocusable(false);
		exitButton.setPreferredSize(new Dimension(256, 64));

		gamePanel.add(exitButton);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		try {
			String pressedKey = String.valueOf(arg0.getKeyChar());
			// Checks if the current entered key is the correct one for the current
			// position, also check if the entered key is not a decimal point
			if (pressedKey.equals(piValue.substring(piStartIndex, piEndIndex)) && !pressedKey.equals(".")) {
				piTextArea.append(pressedKey);
				piStartIndex++;
				piEndIndex++;
				piScore++;
				scoreLabel.setText("Score: " + piScore);
				// If the user finally reaches the 101th digit of Pi, print congratulations message
				if (piScore == 101) {
					JOptionPane.showMessageDialog(null,
							"Congratulations! You have correctly entered the first 101 digits of Pi!",
							"Congratulations Message", JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (pressedKey.equals(".") && !decimalPointAdded) { // if the entered key is a decimal point and it
				// has not been added yet
				piTextArea.append(pressedKey); // just add a period, no need to count it towards the score
				decimalPointAdded = true;
				piStartIndex++;
				piEndIndex++;
			} else {
				JOptionPane.showMessageDialog(null, "Wrong input!", "Wrong Input Message", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			// If the user is still trying to type while the 101 digits of Pi has already
			// been entered
			// DONE: test if this is working properly
			JOptionPane.showMessageDialog(null, "101 digits of Pi already entered!", "",
					JOptionPane.INFORMATION_MESSAGE);
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
			// TODO: Add functionality where it skips to a certain decimal place
			
		}
		if (arg0.getSource() == resetButton) {
			int confirmReset = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset your progress?",
					"Reset Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmReset == JOptionPane.YES_OPTION) {
				piTextArea.setText("");
				piStartIndex = 0;
				piEndIndex = 1;
				piScore = 0;
				decimalPointAdded = false;
				scoreLabel.setText("Score: " + piScore);
			}
		}
		if (arg0.getSource() == exitButton) {
			int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation",
					JOptionPane.YES_NO_OPTION);
			if (confirmExit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

}

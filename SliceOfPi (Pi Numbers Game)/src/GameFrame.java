import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame implements KeyListener {

	JPanel gamePanel;
	JLabel titleLabel;
	JLabel instructionsLabel;
	JLabel piLabel;
	JTextArea piTextArea;

	String piValue = String.valueOf(Math.PI);
	int piScore = 0;
	int piIndex = 1; // starts at 3
	
	JLabel scoreLabel;
	JButton resetButton;
	JButton exitButton;

	public GameFrame() {
		this.setTitle("Slice of Pi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(1024, 768));
		gamePanel.setBackground(new Color(27, 36, 64));
		gamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

		this.add(gamePanel);

		titleLabel = new JLabel("Slice of Pi", JLabel.CENTER);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font(null, Font.BOLD, 32));
		titleLabel.setPreferredSize(new Dimension(1024, 64));

		gamePanel.add(titleLabel);

		instructionsLabel = new JLabel("Instructions: Type as many number of Pi as you can!", JLabel.CENTER);
		instructionsLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		instructionsLabel.setForeground(Color.WHITE);
		instructionsLabel.setFont(new Font(null, Font.PLAIN, 24));
		instructionsLabel.setPreferredSize(new Dimension(1024, 64));

		gamePanel.add(instructionsLabel);

		piTextArea = new JTextArea(16, 32);
		piTextArea.setBackground(new Color(17, 20, 38));
		piTextArea.setForeground(Color.WHITE);
		piTextArea.setLineWrap(true);
		piTextArea.setFont(new Font(null, Font.PLAIN, 24));
		piTextArea.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		piTextArea.setEditable(false);
		piTextArea.addKeyListener(this);

		gamePanel.add(piTextArea);
		
		scoreLabel = new JLabel("Score: " + piScore);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		String pressedKey = String.valueOf(arg0.getKeyChar());
		if (pressedKey.equals(piValue.substring(piScore, piIndex))) {
			piTextArea.append(pressedKey);
			piScore++;
			piIndex++;
		} else {
			JOptionPane.showMessageDialog(this, "Wrong input!", "Wrong Input Message", JOptionPane.WARNING_MESSAGE);
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}

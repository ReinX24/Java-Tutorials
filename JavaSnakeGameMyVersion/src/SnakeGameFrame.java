import java.net.URL;

import javax.swing.*;

public class SnakeGameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	URL snakeGameIcon = getClass().getResource("snakeGameIcon.png");
		
	public void createGameFrame() {
		this.setTitle("Java Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon(snakeGameIcon).getImage());

		this.add(new SnakeGamePanel());

		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null); // this must be at the end for it to work properly
	}
	
	public void askTryAgain() {
		int userChoice = JOptionPane.showConfirmDialog(null, "Try Again?", "Try Again Message", JOptionPane.YES_NO_OPTION);
		
		if (userChoice == JOptionPane.YES_OPTION) {
			createGameFrame();
			this.dispose();
		}
	}

}

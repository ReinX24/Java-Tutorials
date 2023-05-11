import java.awt.*;
import javax.swing.*;

public class PongGameFrame extends JFrame implements Runnable {

	PongGamePanel gamePanel; // PongGamePanel object

	Color tableColor = new Color(119, 176, 83);

	Thread gameFrameThread;

	public PongGameFrame() {

		// Creating our JFrame
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(tableColor);
		this.setIconImage(PongGameMenu.PONG_ICON.getImage());

		// Adding our gamePanel to our JFrame
		gamePanel = new PongGamePanel();
		this.add(gamePanel);

		gameFrameThread = new Thread(this);
		gameFrameThread.start();

		this.pack(); // packing all of the components of our JFrame
		this.setLocationRelativeTo(null); // JFrame appears at the center
		this.setVisible(true);

	}

	@Override
	public void run() {
		while (true) { // continually checks if the game is over
			if (gamePanel.checkGameOver()) {
				System.out.println("Closed!");
				this.dispose();
				break;
			}
		}
	}

}

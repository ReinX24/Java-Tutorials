import java.awt.*;
import javax.swing.*;

public class PongGameFrame extends JFrame {

	PongGamePanel gamePanel; // PongGamePanel object

	Color tableColor = new Color(119, 176, 83);

	public PongGameFrame() {

		// Creating our JFrame
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(tableColor);
		this.setIconImage(PongGameMenu.PONG_ICON.getImage());
		
		// Adding our gamePanel to our JFrame
		gamePanel = new PongGamePanel();
		this.add(gamePanel);
		
		this.pack(); // packing all of the components of our JFrame
		this.setLocationRelativeTo(null); // JFrame appears at the center
		this.setVisible(true);
		
	}

}

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PongGameFrame extends JFrame {

	PongGamePanel gamePanel; // PongGamePanel object

	public PongGameFrame() {

		// Creating our JFrame
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Adding our gamePanel to our JFrame
		gamePanel = new PongGamePanel();
		this.add(gamePanel);

		this.pack(); // packing all of the components of our JFrame
		this.setLocationRelativeTo(null); // JFrame appears at the center
		this.setVisible(true);

	}

}

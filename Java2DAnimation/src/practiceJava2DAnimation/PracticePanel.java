package practiceJava2DAnimation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticePanel extends JPanel implements ActionListener {

	final int PANEL_WIDTH = 800;
	final int PANEL_HEIGHT = 500;

	int x = 0;
	int y = 0;

	int xVelocity = 10;
	int yVelocity = 10;

	Timer myTimer;
	Image enemyImage;
	Image backgroundImage;

	public PracticePanel() {

		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(new Color(0, 128, 128));
		
		// Finish creating our timer
		myTimer = new Timer(100, this);
		
		// Finish creating out Image objects
		enemyImage = new ImageIcon("enemyImage.png").getImage();
		backgroundImage = new ImageIcon("spaceBackground.jpg").getImage();
		
		myTimer.start(); // starts our timer object and performs actionPerformed method

	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		super.paint(g); // paints background color
		
		// Adding our backgroundImage
		g2D.drawImage(backgroundImage, 0, 0, null);
		
		// Adding our enemyImage
		g2D.drawImage(enemyImage, x, y, null);
		
	}
	
	public void actionPerformed (ActionEvent arg0) {
		
		// Moving the enemyImage horizontally
		if (x >= PANEL_WIDTH - enemyImage.getWidth(null) || x < 0) {
			xVelocity *= -1;
		}
		
		x += xVelocity;
		
		// Moving the enemyImage vertically
		if (y >= PANEL_HEIGHT - enemyImage.getHeight(null) || y < 0) {
			yVelocity *= -1;
		}
		
		y += yVelocity;
		
		// calls the paint method, repaints enemyImage location
		repaint();
		
	}

}

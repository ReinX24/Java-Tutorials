
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener {

	// instantiating width and height
	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 500;

	// creating Image objects
	Image enemyImage;
	Image backgroundImage;

	// creating a Timer object
	Timer timerNum;

	// speed of our image
	int xVelocity = 1;
	int yVelocity = 1;

	// starting position of our image
	int x = 0;
	int y = 0;

	public MyPanel() {

		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.BLACK);

		enemyImage = new ImageIcon("enemyImage.png").getImage(); // gets Image from ImageIcon

		timerNum = new Timer(10, this); // action frequency - 1 second, ActionListener
		timerNum.start(); // performs when constructor is called
		
		backgroundImage = new ImageIcon("spaceBackground.jpg").getImage();
		
	}

	// Always runs
	public void paint(Graphics g) {

		Graphics2D g2D = (Graphics2D) g;

		super.paint(g); // paints the background with method from MyPanel constructor

		// Adding backgroundImage before adding in our enemyImage
		g2D.drawImage(backgroundImage, 0, 0, null);
		
		// Drawing or adding an enemyImage to our JPanel
		g2D.drawImage(enemyImage, x, y, null); // image, x, y, observer (null for now)

	}

	// Performs every second since timerNum has an ActionListener
	public void actionPerformed(ActionEvent arg0) {
		
		// if the image reaches the end of the JPanel, if it reaches the start
		if (x >= PANEL_WIDTH - enemyImage.getWidth(null) || x < 0 ) {
			xVelocity *= -1;
		} 
		
		x += xVelocity;
		
		// Moving vertically
		if (y >= PANEL_HEIGHT - enemyImage.getHeight(null) || y < 0 ) {
			yVelocity *= -1;
		} 
		
		y += yVelocity;
		
		repaint(); // calls the paint() method each second, repaint instead of paint
		
	}

}

package practiceKaeya2DAnimation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KaeyaPanel extends JPanel implements ActionListener {

	final int PANEL_HEIGHT = 500;
	final int PANEL_WIDTH = 800;

	int x = 0;
	int y = 0;

	int xVelocity = 20;
	int yVelocity = 20;

	Timer myTimer;

	Image kaeyaBackground;
	Image kaeyaImage;

	public KaeyaPanel() {

		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(new Color(0, 128, 128));

		kaeyaBackground = new ImageIcon("kaeyaBackground.jpg").getImage();

		kaeyaImage = new ImageIcon("kaeyaImage.jpeg").getImage();
		
		myTimer = new Timer(100, this); // executes program every 100 ms
		myTimer.start();

	}

	public void paint(Graphics g) {

		Graphics2D g2D = (Graphics2D) g;

		super.paint(g);

		g2D.drawImage(kaeyaBackground, 0, 0, null);
		g2D.drawImage(kaeyaImage, x, y, null);

	}

	
	public void actionPerformed(ActionEvent arg0) {
		
		if (x >= PANEL_WIDTH - kaeyaImage.getWidth(null) || x < 0) {
			xVelocity *= -1;
		}
		
		x += xVelocity;
		
		if (y >= PANEL_HEIGHT - kaeyaImage.getHeight(null) || y < 0) {
			yVelocity *= -1;
		}
		
		y += yVelocity;
		
		repaint();
		
	}


}

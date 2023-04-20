package practiceLandscape;

import javax.swing.*;
import java.awt.*;

public class LandscapePanel extends JPanel {

	Image bgImage;

	public LandscapePanel() {

		this.setPreferredSize(new Dimension(500, 500));

		bgImage = new ImageIcon("skyBackground.jpg").getImage();

	}

	public void paint(Graphics g) {

		Graphics2D g2D = (Graphics2D) g;

		// Adding background image
		g2D.drawImage(bgImage, 0, 0, null);

		// Adding our sun
		g2D.setPaint(Color.YELLOW);
		g2D.fillOval(175, 175, 150, 150);

		// Adding green field
		g2D.setPaint(Color.GREEN);
		g2D.fillRect(0, 300, 500, 200);

		// Adding two mountains
		g2D.setPaint(new Color(150, 75, 0));
		int[] xLeftPoints = { 10, 125, 240 }; // 250 / 2 = 125
		int[] yLeftPoints = { 350, 200, 350 };

		g2D.fillPolygon(xLeftPoints, yLeftPoints, 3);

		int[] xRightPoints = { 260, 375, 490 }; // 500 / 2 = 250 + 125 (250 / 2) = 375
		int[] yRightPoints = { 350, 200, 350 };

		g2D.fillPolygon(xRightPoints, yRightPoints, 3);
		
		// TODO: add rectangles at the bottom

	}

}

package practiceJava2DGraphics;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

	Image bgImage;

	public MainPanel() {

		this.setPreferredSize(new Dimension(1000, 1000));
		bgImage = new ImageIcon("GitHub-Mark.png").getImage();

	}

	public void paint(Graphics g) {

		// Creating a Graphics 2D object
		Graphics2D g2D = (Graphics2D) g;

		// For Nikole :)
//		g2D.setPaint(new Color(255, 229, 180));
//
//		g2D.fillOval(10, 10, 100, 100);
//		g2D.fillOval(110, 10, 100, 100);
//
//		g2D.setPaint(new Color(255, 192, 203));
//		g2D.fillOval(55, 55, 10, 10);
//		g2D.fillOval(155, 55, 10, 10);

		// Adding an Image to our JPanel
		g2D.drawImage(bgImage, 0, 0, null);

		// Creating 2 Lines
		g2D.setPaint(Color.BLACK);
		g2D.drawLine(0, 0, 1000, 1000);
		g2D.drawLine(1000, 0, 0, 1000);

		// Creating an empty rectangle and filled one
		g2D.setPaint(Color.RED);
		g2D.drawRect(10, 10, 190, 90);
		g2D.fillRect(10, 110, 190, 90);

		// Drawing an empty and filled oval
		g2D.setPaint(Color.BLUE);
		g2D.drawOval(210, 10, 200, 80);
		g2D.fillOval(210, 110, 200, 80);

		// Drawing 2 arcs
		g2D.setStroke(new BasicStroke(2));
		g2D.setPaint(Color.ORANGE);
		g2D.drawArc(10, 220, 100, 100, 0, 180);

		g2D.fillArc(10, 220, 100, 100, 180, 180);

		// Drawing an empty and filled triangle
		g2D.setPaint(Color.YELLOW);
		int[] xPoints = { 300, 500, 700 };
		int[] yPoints = { 500, 200, 500 };

		g2D.drawPolygon(xPoints, yPoints, 3);

		int[] xPointsFillLeft = { 100, 300, 500 };
		int[] yPointsFillLeft = { 800, 500, 800 };
		g2D.fillPolygon(xPointsFillLeft, yPointsFillLeft, 3);

		int[] xPointsFillRight = { 500, 700, 900 };
		int[] yPointsFillRight = { 800, 500, 800 };
		g2D.fillPolygon(xPointsFillRight, yPointsFillRight, 3);

		// Adding text using Graphics2D
		g2D.setFont(new Font("Ink Free", Font.BOLD, 32));
		g2D.setPaint(new Color(0, 128, 128));
		g2D.drawString("Hello there :)", 400, 100);

	}

}

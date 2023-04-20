
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {

	Image bgImage;

	public MyPanel() {

		this.setPreferredSize(new Dimension(500, 500));

		bgImage = new ImageIcon("greenFrog.png").getImage();

	}

	// Overriding paint method, this method is invoked automatically
	public void paint(Graphics g) {

		// Creating a graphics 2D object
		Graphics2D g2D = (Graphics2D) g;

		// Adding an image to our JPanel or 2D Graphic
		// image, x, y, null (image observer)
		g2D.drawImage(bgImage, 0, 0, null);

		// Changing width of our line
//		g2D.setStroke(new BasicStroke(5)); // 5 pixels width

		// Changing line color
		g2D.setPaint(new Color(0, 128, 128));

		// x1 (first point), y1 (first point), x2 (second point), y2 (second point)
//		g2D.drawLine(10, 10, 490, 490); // will get overlapped by other added elements

		// Drawing a rectangle

		// Overrides old paint method
		// g2D.setPaint(new Color(0, 128, 128));

		// x, y, (starting positions), width, height
//		g2D.drawRect(10, 10, 300, 200);

		// Creating a filled rectangle
		// g2D.fillRect(10, 10, 300, 200);

		// Drawing an oval

		// x, y, (coordinates), width, height
//		g2D.setPaint(new Color(255, 128, 0));
//		g2D.drawOval(10, 10, 300, 200);

		// Filled oval
//		g2D.fillOval(10, 10, 300, 200);

		// x, y(starting coordinates), width, height, startAngle, arcAngle
//		g2D.drawArc(10, 10, 100, 100, 0, 180); // draws a half circle

		g2D.setPaint(Color.RED);
		g2D.fillArc(10, 10, 100, 100, 0, 180);

		g2D.setPaint(Color.WHITE);
		g2D.fillArc(10, 10, 100, 100, 180, 180);

		// Drawing a triangle

		int[] xPoints = { 150, 250, 350 }; // left, top, right (x axis points)
		int[] yPoints = { 300, 200, 300 }; // left, top, right (y axis points)
		g2D.setPaint(Color.BLACK);

		// xPoints array, yPoints array, amounts of points in each array
//		g2D.drawPolygon(xPoints, yPoints, 3);
		g2D.fillPolygon(xPoints, yPoints, 3);

		// Drawing a String of text

		// Setting font styles
//		g2D.setFont(new Font("Ink Free", Font.BOLD, 32));

		// Setting font color
//		g2D.setPaint(Color.RED);

		// String, x, y (starts at bottom left corner)
//		g2D.drawString("U R A WINNER! :D", 50, 50);

	}

}

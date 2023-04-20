package practiceJava2DGraphics;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

	public MainPanel() {

		this.setPreferredSize(new Dimension(1000, 1000));

	}

	public void paint(Graphics g) {

		// Creating a Graphics 2D object
		Graphics2D g2D = (Graphics2D) g;

		g2D.setPaint(Color.RED);
		g2D.drawOval(10, 10, 100, 100);

	}

}

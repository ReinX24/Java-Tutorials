
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {

	MyPanel mainPanel;

	public MyFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);

		/*
		 * Why did we add a JPanel? This is because when creating a JFrame, the title
		 * bar takes up space which could cause coordinates to look like they are in the
		 * wrong coordinates. To fix this, we instead add a JPanel where we will be
		 * adding our components and we will pack our JFrame so that the components will
		 * be in the right coordinates.
		 * 
		 */

		mainPanel = new MyPanel();

		this.add(mainPanel);
		this.pack();
		this.setLocationRelativeTo(null); // makes window appear in the center of the screen
		this.setVisible(true);

	}

}

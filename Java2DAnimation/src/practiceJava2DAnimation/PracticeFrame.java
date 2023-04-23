package practiceJava2DAnimation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeFrame extends JFrame {

	PracticePanel mainPanel;

	public PracticeFrame() {

		mainPanel = new PracticePanel();

		this.setTitle("[Java 2D Animation Practice]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(mainPanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}

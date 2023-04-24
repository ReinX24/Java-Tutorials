package practiceKaeya2DAnimation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KaeyaFrame extends JFrame {

	KaeyaPanel mainPanel;

	public KaeyaFrame() {

		mainPanel = new KaeyaPanel();

		// No need for "this" keyword
		this.setTitle("[Kaeya 2D Animation]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.add(mainPanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}

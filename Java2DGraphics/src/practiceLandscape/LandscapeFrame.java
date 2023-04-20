package practiceLandscape;

import javax.swing.*;
import java.awt.*;

public class LandscapeFrame extends JFrame {

	LandscapePanel mainPanel;

	public LandscapeFrame() {

		this.setTitle("[Landscape Graphics2D]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		mainPanel = new LandscapePanel();

		this.add(mainPanel);
		this.pack();

		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}

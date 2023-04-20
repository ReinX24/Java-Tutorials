package practiceJava2DGraphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	MainPanel basePanel;

	public MainFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		
		basePanel = new MainPanel();

		this.add(basePanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}

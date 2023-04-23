
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {

	MyPanel mainPanel;
	
	public MyFrame() {
		
		mainPanel = new MyPanel();
		
		this.setTitle("[Java 2D Animation]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(mainPanel);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
}

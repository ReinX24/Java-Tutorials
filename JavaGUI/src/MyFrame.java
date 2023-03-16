import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	// Another way of creating a JFrame
	public MyFrame() {
		this.setVisible(true);
		this.setSize(1024, 768);
		this.setTitle("JFrame Constructor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.getContentPane().setBackground(new Color(0, 128, 128));

		ImageIcon frameIcon = new ImageIcon("IBM_logo_in.jpg");
		this.setIconImage(frameIcon.getImage());
	}

}

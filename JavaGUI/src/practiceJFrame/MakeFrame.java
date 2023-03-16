package practiceJFrame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MakeFrame extends JFrame {

	public MakeFrame() {
		// 6 attributes that a JFrame must have
		this.setVisible(true);
		this.setSize(640, 480);
		this.setTitle("[ Constructed Frame ]");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(255, 128, 0));

		// Setting icon for JFrame
		ImageIcon frameIcon = new ImageIcon("GitHub-Mark.png");
		this.setIconImage(frameIcon.getImage());
	}

}

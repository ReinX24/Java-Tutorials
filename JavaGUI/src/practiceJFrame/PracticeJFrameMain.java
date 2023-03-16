package practiceJFrame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PracticeJFrameMain {

	public static void main(String[] args) {

		// Creating a JFrame using the main method
		JFrame frameOne = new JFrame();
		frameOne.setVisible(true);
		frameOne.setSize(1024, 768);
		frameOne.setTitle("[ JFrame Practice ]");
		frameOne.setResizable(false);
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameOne.getContentPane().setBackground(new Color(0, 128, 128));

		// Setting Icon for JFrame
		ImageIcon frameIcon = new ImageIcon("IBM_logo_in.jpg");
		frameOne.setIconImage(frameIcon.getImage());

		// Creating a JFrame using a constructor
		MakeFrame constructFrame = new MakeFrame();
	}

}

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JavaGUIMain {

	public static void main(String[] args) {
		// JFrame : A GUI window to add components to

//		JFrame frameOne = new JFrame(); // creates a frame
//		frameOne.setVisible(true); // make frame visible
//		frameOne.setSize(420, 500); // x, y dimensions
//		frameOne.setTitle("First JFrame!"); // title of the JFrame
//		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits application when you press x
//		frameOne.setResizable(false); // prevents frame from being resized
//
//		// Creating an ImageIcon
//		ImageIcon frameIcon = new ImageIcon("IBM_logo_in.jpg");
//		frameOne.setIconImage(frameIcon.getImage()); // change icon of JFrame
//
//		// Changing background color of our JFrame
//		frameOne.getContentPane().setBackground(Color.GRAY); // using built in colors
//		frameOne.getContentPane().setBackground(new Color(0, 128, 128)); // using RGB to set background color
//		frameOne.getContentPane().setBackground(new Color(0x008080)); // using hexadecimal values

		// Creating a JFrame using a contstructor
		MyFrame frameTest = new MyFrame();
	}

}

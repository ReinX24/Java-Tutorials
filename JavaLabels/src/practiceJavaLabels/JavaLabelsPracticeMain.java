package practiceJavaLabels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class JavaLabelsPracticeMain {

	public static void main(String[] args) {

		// Creating a JFrame to hold our JPanel
		JFrame myFrame = new JFrame();
		myFrame.setVisible(true);
		myFrame.setTitle("[ JFrame Practice ]");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(1025, 768);
		myFrame.setResizable(true); // JFrame can be resized with cursor
		myFrame.getContentPane().setBackground(new Color(0, 128, 128));

		// Creating a JLabel for our JFrame
		JLabel myLabel = new JLabel();
		myLabel.setText("[ JLabel Practice ]");
		myFrame.add(myLabel); // adding JLabel to JFrame

		// Adding an image to the JLabel
		ImageIcon myIcon = new ImageIcon("greenFrog.png");
		myLabel.setIcon(myIcon);

		// Moving the text and changing font style of text
		myLabel.setHorizontalTextPosition(JLabel.CENTER);
		myLabel.setVerticalTextPosition(JLabel.TOP);
		myLabel.setIconTextGap(20);
		myLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		myLabel.setForeground(Color.WHITE);

		// Moving the JPanel to the center of the JFrame
		myLabel.setHorizontalAlignment(JLabel.CENTER);

		// Adding a border to our JFrame
		Border myBorder = BorderFactory.createLineBorder(Color.WHITE);
		myLabel.setBorder(myBorder);

		// Setting the background color of our JLabel
		// Changes the background of the entire JFrame because JPanel like to take up
		// entire JFrames
		myLabel.setBackground(Color.DARK_GRAY);
		myLabel.setOpaque(true);
		
		// Resizes the JFrame to fit all of the components to their sizes
		myFrame.pack();

	}

}

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class JavaLabelsMain {

	public static void main(String[] args) {

		// JLabel : A GUI display area for a String of text, an image, or both

		// First, we need to create a JFrame
		JFrame frameOne = new JFrame();

		// Setting layout manager to null
//		frameOne.setLayout(null);
		// We now need to set the coordinates of our JLabels accordingly

		frameOne.setVisible(true);
		frameOne.setSize(1024, 768);
		frameOne.setTitle("[ JFrame - frameOne ]");
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameOne.setResizable(false);
		frameOne.getContentPane().setBackground(new Color(255, 128, 0));

		// Creating a JLabel
		JLabel labelOne = new JLabel();
		labelOne.setText("[ Bro, do you even code? ]"); // set text of label
		frameOne.add(labelOne);

		// Creating an ImageIcon
		ImageIcon iconOne = new ImageIcon("The_Rock.jpeg");

		// Adding ImageIcon to JPanel
		labelOne.setIcon(iconOne);

		// Moving text around JLabel

		// Moving text horizontally
		// OPTIONS: LEFT, CENTER, RIGHT, of ImageIcon
		labelOne.setHorizontalTextPosition(JLabel.CENTER); // moves JLabel to the center of our image

		// Moving text vertically
		// OPTIONS: TOP, CENTER, BOTTOM, of ImageIcon
		labelOne.setVerticalTextPosition(JLabel.TOP);

		// Changing the text color of our label
		labelOne.setForeground(new Color(0, 128, 128));

		// Changing font style and size
		labelOne.setFont(new Font("MV Boli", Font.PLAIN, 50));

		// Adds a gap between the text and the ImageIcon
		labelOne.setIconTextGap(30);

		// Changing background color
		labelOne.setBackground(Color.BLACK);
		labelOne.setOpaque(true); // displays background color
		// changes background color of the entire JFrame because the JLabel likes to
		// take the entire JFrame

		// Adding a border to our JLabel
		Border borderOne = BorderFactory.createLineBorder(new Color(255, 128, 0));
		labelOne.setBorder(borderOne);

		// Changing where text and image is placed
		labelOne.setVerticalAlignment(JLabel.CENTER);
		labelOne.setHorizontalAlignment(JLabel.CENTER);

		// Placing coordinates for our JLabel
//		labelOne.setBounds(100, 150, 640, 480); // x, y, width, height position of JLabel in JFrame
		
		// Resizing the JFrame to accommodate the components within it
		frameOne.pack(); // basically resizes frame to match the size of it's components
		// NOTE: ADD ALL COMPONENTS BEFORE PACKING JFRAME

	}

}

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PracticeMain {

	public static void main(String[] args) {

		// Creating a JFrame
		JFrame frameOne = new JFrame();
		frameOne.setVisible(true);
		frameOne.setTitle("[ Minecraft ]");
		frameOne.setSize(1024, 768);
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameOne.getContentPane().setBackground(new Color(0, 128, 128));
		frameOne.setResizable(false);

		// Adding an ImageIcon to JFrame
		ImageIcon frameIcon = new ImageIcon("minecraft_icon.png");
		frameOne.setIconImage(frameIcon.getImage());

		// Creating a JLabel for the JFrame
		JLabel labelOne = new JLabel();
		labelOne.setText("< MINECRAFT >");
		labelOne.setSize(640, 480);

		// Adding JLabel to JFrame
		frameOne.add(labelOne);

		// Adding an image to the JLabel
		ImageIcon labelIcon = new ImageIcon("play_button.png");
		labelOne.setIcon(labelIcon);

		// Moving and modifying the text of our JLabel
		labelOne.setHorizontalTextPosition(JLabel.CENTER);
		labelOne.setVerticalTextPosition(JLabel.TOP);
		labelOne.setFont(new Font("Arial", Font.PLAIN, 30));
		labelOne.setForeground(Color.WHITE);
		labelOne.setIconTextGap(20);
		
		// Moving the JLabel around our JFrame
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		labelOne.setVerticalAlignment(JLabel.CENTER);
		
		// Changing the layout manager of our JFrame
		frameOne.setLayout(null);
		labelOne.setBounds(192, 144, 640, 480); // x y width height
		// moves its contents to the x y axis within the JFrame
		
		// Packing our JFrame, resized it to use only space used by its components (JLabel)
//		frameOne.pack();
	}

}

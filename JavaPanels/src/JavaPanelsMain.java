import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaPanelsMain {

	public static void main(String[] args) {

		// JPanel : a GUI component that functions as a container to hold other
		// components

		// Creating a JFrame
		JFrame frameOne = new JFrame();
		frameOne.setVisible(true);
		frameOne.setSize(1024, 768);
		frameOne.setTitle("[ JFrame Practice ]");
		frameOne.setResizable(false);
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameOne.getContentPane().setBackground(new Color(255, 128, 0));

		// Using null layout manager
		frameOne.setLayout(null);

		// Creating a JPanel
		JPanel panelOne = new JPanel();
		panelOne.setBackground(Color.RED);
		panelOne.setBounds(0, 0, 512, 384); // x y width height

		// Creating more JPanel objects
		JPanel panelTwo = new JPanel();
		panelTwo.setBackground(Color.BLUE);
		panelTwo.setBounds(512, 0, 512, 384);

		JPanel panelThree = new JPanel();
		panelThree.setBackground(Color.YELLOW);
		panelThree.setBounds(256, 384, 512, 384);

		// Adding JPanels to the JFrame
		frameOne.add(panelOne);
		frameOne.add(panelTwo);
		frameOne.add(panelThree);

	}

}

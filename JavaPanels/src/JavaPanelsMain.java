import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		panelOne.setBounds(0, 0, 512, 384); // x y width height, need to set bounds because JFrame is using a null
											// layout manager
		panelOne.setLayout(new BorderLayout());

		// Creating more JPanel objects
		JPanel panelTwo = new JPanel();
		panelTwo.setBackground(Color.BLUE);
		panelTwo.setBounds(512, 0, 512, 384);
		panelTwo.setLayout(null);

		JPanel panelThree = new JPanel();
		panelThree.setBackground(Color.YELLOW);
		panelThree.setBounds(256, 384, 512, 384);
		// Setting the layout for panelThree
		panelThree.setLayout(new BorderLayout()); // uses the JFrame layout (border layout)

		// Adding JPanels to the JFrame
		frameOne.add(panelOne);
		frameOne.add(panelTwo);
		frameOne.add(panelThree);

		// Creating a JLabel to be added to the JFrame
		JLabel labelOne = new JLabel();
		labelOne.setText("[ JLabel Practice ]");

		/* RUNS IF THE LAYOUT IS BORDER LAYOUT */
		labelOne.setIconTextGap(20);
		labelOne.setHorizontalTextPosition(JLabel.CENTER);
		labelOne.setVerticalTextPosition(JLabel.TOP);
		labelOne.setHorizontalAlignment(JLabel.RIGHT);
		labelOne.setVerticalAlignment(JLabel.BOTTOM);

		/* RUNS IF THE LAYOUT IS NULL */
		// Setting bounds for JLabel if the layout method of the JPanel is null
		labelOne.setBounds(0, 0, 250, 250); // x y width height

		// ImageIcon for our JLabel
		ImageIcon labelIcon = new ImageIcon("greenFrog.png");
		labelOne.setIcon(labelIcon);
		// setIcon for JLabel
		// setIconImage for JFrame

		// Adding the JLabel to a JPanel
//		panelOne.add(labelOne);
		panelTwo.add(labelOne);
//		panelThree.add(labelOne);

		// JLabel : Border layout, starts from center (y) left (x)
		// JPanel : Flow Layout, starts from the top (y) center (x)

	}

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaBorderLayoutMain {

	public static void main(String[] args) {

		// Layout Manager = Defines the natural layout for components within a container

		// 3 common managers

		// BorderLayout = A BorderLayout places components in five areas:
		// NORTH,SOUTH,WEST,EAST,CENTER.
		// All extra space is placed in the center area.

		// Creating a JFrame
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("[Main Frame]");
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setResizable(true);
		mainFrame.getContentPane().setBackground(new Color(0, 128, 128));

		// Setting layout manager
		mainFrame.setLayout(new BorderLayout(20, 20)); // default layout manager of JFrame, not for others though
		// ^ Numbers in parameters are margins for width & height, measured in pixels

		// Creating panels for our frame
		JPanel panelOne = new JPanel();
		JPanel panelTwo = new JPanel();
		JPanel panelThree = new JPanel();
		JPanel panelFour = new JPanel();
		JPanel panelFive = new JPanel();

		// Setting background colors
		panelOne.setBackground(Color.RED);
		panelTwo.setBackground(Color.GREEN);
		panelThree.setBackground(Color.YELLOW);
		panelFour.setBackground(Color.MAGENTA);
		panelFive.setBackground(Color.BLUE);

		// Setting size for each of our panels
		panelOne.setPreferredSize(new Dimension(100, 100)); // x y (y is changeable, x takes up entire row)
		panelTwo.setPreferredSize(new Dimension(100, 100));
		panelThree.setPreferredSize(new Dimension(100, 100));
		panelFour.setPreferredSize(new Dimension(100, 100));
		panelFive.setPreferredSize(new Dimension(100, 100));

		// Adding JPanels to JFrame
		mainFrame.add(panelOne, BorderLayout.NORTH);
		mainFrame.add(panelTwo, BorderLayout.WEST);
		mainFrame.add(panelThree, BorderLayout.EAST);
		mainFrame.add(panelFour, BorderLayout.SOUTH);
		mainFrame.add(panelFive, BorderLayout.CENTER);

		// Adding JPanels within our existing JPanels, sub panels
		JPanel subPanelOne = new JPanel();
		JPanel subPanelTwo = new JPanel();
		JPanel subPanelThree = new JPanel();
		JPanel subPanelFour = new JPanel();
		JPanel subPanelFive = new JPanel();

		subPanelOne.setBackground(Color.BLACK);
		subPanelTwo.setBackground(Color.CYAN);
		subPanelThree.setBackground(Color.GRAY);
		subPanelFour.setBackground(Color.LIGHT_GRAY);
		subPanelFive.setBackground(Color.WHITE);

		subPanelOne.setPreferredSize(new Dimension(50, 50)); // x y (y is changeable, x takes up entire row)
		subPanelTwo.setPreferredSize(new Dimension(50, 50));
		subPanelThree.setPreferredSize(new Dimension(50, 50));
		subPanelFour.setPreferredSize(new Dimension(50, 50));
		subPanelFive.setPreferredSize(new Dimension(50, 50));

		// Setting panelFive's layout
		panelFive.setLayout(new BorderLayout(4, 4));

		// Adding subPanels to panelFive
		panelFive.add(subPanelOne, BorderLayout.NORTH);
		panelFive.add(subPanelTwo, BorderLayout.SOUTH);
		panelFive.add(subPanelThree, BorderLayout.WEST);
		panelFive.add(subPanelFour, BorderLayout.EAST);
		panelFive.add(subPanelFive, BorderLayout.CENTER);

	}

}

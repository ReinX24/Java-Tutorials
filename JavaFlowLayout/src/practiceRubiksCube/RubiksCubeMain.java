package practiceRubiksCube;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RubiksCubeMain {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Rubik's Cube");
		mainFrame.setSize(1000, 1000);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(true);
		mainFrame.getContentPane().setBackground(Color.GRAY);
		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 18));

		// Creating JPanels for our Rubik's Cube
		JPanel panelOne = new JPanel();
		panelOne.setPreferredSize(new Dimension(300, 300));
		panelOne.setBackground(Color.WHITE);
		mainFrame.add(panelOne);

		JPanel panelTwo = new JPanel();
		panelTwo.setPreferredSize(new Dimension(300, 300));
		panelTwo.setBackground(Color.GREEN);
		mainFrame.add(panelTwo);

		JPanel panelThree = new JPanel();
		panelThree.setPreferredSize(new Dimension(300, 300));
		panelThree.setBackground(Color.RED);
		mainFrame.add(panelThree);

		JPanel panelFour = new JPanel();
		panelFour.setPreferredSize(new Dimension(300, 300));
		panelFour.setBackground(Color.BLUE);
		mainFrame.add(panelFour);

		JPanel panelFive = new JPanel();
		panelFive.setPreferredSize(new Dimension(300, 300));
		panelFive.setBackground(Color.ORANGE);
		mainFrame.add(panelFive);

		JPanel panelSix = new JPanel();
		panelSix.setPreferredSize(new Dimension(300, 300));
		panelSix.setBackground(Color.YELLOW);
		mainFrame.add(panelSix);

		JPanel panelSeven = new JPanel();
		panelSeven.setPreferredSize(new Dimension(300, 300));
		panelSeven.setBackground(Color.WHITE);
		mainFrame.add(panelSeven);

		JPanel panelEight = new JPanel();
		panelEight.setPreferredSize(new Dimension(300, 300));
		panelEight.setBackground(Color.GREEN);
		mainFrame.add(panelEight);

		JPanel panelNine = new JPanel();
		panelNine.setPreferredSize(new Dimension(300, 300));
		panelNine.setBackground(Color.RED);
		mainFrame.add(panelNine);

		mainFrame.setVisible(true); // should be at the end of the program

	}

}

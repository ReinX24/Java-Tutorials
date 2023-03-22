package practicePhoneNumpad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhoneNumpadMain {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("[Phone Numpad]");
		mainFrame.setSize(600, 600);
		mainFrame.setResizable(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setBackground(Color.DARK_GRAY);
		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Creating a JPanel that will hold our buttons
		JPanel panelOne = new JPanel();
		panelOne.setPreferredSize(new Dimension(510, 560));
		panelOne.setBackground(Color.GRAY);
		panelOne.setForeground(Color.WHITE);
		panelOne.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));

		// Adding JButtons to our JPanel
		JButton buttonOne = new JButton("1");
		buttonOne.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonOne);

		JButton buttonTwo = new JButton("2 ABC");
		buttonTwo.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonTwo);

		JButton buttonThree = new JButton("3 DEF");
		buttonThree.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonThree);

		JButton buttonFour = new JButton("4 GHI");
		buttonFour.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonFour);

		JButton buttonFive = new JButton("5 JKL");
		buttonFive.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonFive);

		JButton buttonSix = new JButton("6 MNO");
		buttonSix.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonSix);

		JButton buttonSeven = new JButton("7 PQRS");
		buttonSeven.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonSeven);

		JButton buttonEight = new JButton("8 TUV");
		buttonEight.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonEight);

		JButton buttonNine = new JButton("9 WXYZ");
		buttonNine.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonNine);

		JButton buttonAsterisk = new JButton("*");
		buttonAsterisk.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonAsterisk);

		JButton buttonZero = new JButton("0");
		buttonZero.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonZero);

		JButton buttonHashtag = new JButton("#");
		buttonHashtag.setPreferredSize(new Dimension(100, 100));
		panelOne.add(buttonHashtag);

		// Adding our JPanel to our JFrame
		mainFrame.add(panelOne);

		mainFrame.setVisible(true); // should be at the last part of the program

	}

}

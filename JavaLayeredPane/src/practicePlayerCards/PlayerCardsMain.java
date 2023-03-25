package practicePlayerCards;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class PlayerCardsMain {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Player Cards");
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(new Color(0, 128, 128));
		mainFrame.setLayout(null); // for this example, we will be using the null layout manager for our JFrame

		// Adding components to our JFrame

		// Adding a JPanel to hold our JLayeredPanes
		JLayeredPane mainLayeredPane = new JLayeredPane();
		mainLayeredPane.setBounds(50, 50, 400, 400);
		mainLayeredPane.setLayout(null); // null layout manager for our JLayeredPane
		mainLayeredPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		mainLayeredPane.setBackground(Color.WHITE);

		// Creating and adding JLayeredPanes for our JPanel
		JLabel labelOne = new JLabel();
		labelOne.setBounds(10, 10, 100, 100);
		labelOne.setOpaque(true); // for JLabels, need to be true to show background color
		labelOne.setBackground(Color.BLUE);

		JLabel labelTwo = new JLabel();
		labelTwo.setBounds(20, 20, 100, 100);
		labelTwo.setOpaque(true);
		labelTwo.setBackground(Color.ORANGE);

		JLabel labelThree = new JLabel();
		labelThree.setBounds(30, 30, 100, 100);
		labelThree.setOpaque(true);
		labelThree.setBackground(Color.RED);

		JLabel labelFour = new JLabel();
		labelFour.setBounds(40, 40, 100, 100);
		labelFour.setOpaque(true);
		labelFour.setBackground(Color.CYAN);

		mainLayeredPane.add(labelOne, Integer.valueOf(0));
		mainLayeredPane.add(labelTwo, Integer.valueOf(0)); // will be at the bottom of labelOne
		mainLayeredPane.add(labelThree, Integer.valueOf(1));
		mainLayeredPane.add(labelFour, Integer.valueOf(2));

		mainFrame.add(mainLayeredPane);

		mainFrame.setVisible(true);

	}

}

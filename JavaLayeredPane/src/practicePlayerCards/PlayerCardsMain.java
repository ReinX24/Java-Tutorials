package practicePlayerCards;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PlayerCardsMain {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Player Cards");
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(new Color(0, 128, 128));
		mainFrame.setLayout(null); // for this example, we will be using the null layout manager

		// Adding components to our JFrame

		// Adding a JPanel to hold our JLayeredPanes
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(50, 50, 400, 400);
		mainPanel.setLayout(null);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

		// Creating and adding JLayeredPanes for our JPanel
		JLayeredPane layeredPaneOne = new JLayeredPane();
		layeredPaneOne.setBounds(50, 50, 100, 100);
		layeredPaneOne.setOpaque(true); // for JLabels, need to be true to show background color
		layeredPaneOne.setBackground(Color.BLUE);

		JLayeredPane layeredPaneTwo = new JLayeredPane();
		layeredPaneOne.setBounds(100, 100, 100, 100);
		layeredPaneTwo.setOpaque(true);
		layeredPaneTwo.setBackground(Color.ORANGE);

		mainPanel.add(layeredPaneOne, Integer.valueOf(0));
		mainPanel.add(layeredPaneTwo, Integer.valueOf(1));

		mainFrame.add(mainPanel);

		mainFrame.setVisible(true);

	}

}

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class JavaLayeredPaneMain {

	public static void main(String[] args) {

		// JLayeredPane = Swing container that provides a
		// third dimension for positioning components
		// ex. depth, Z-index

		// Creating a JFrame that will hold our JLayeredPane
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("[JLayeredPane]");
		mainFrame.setSize(500, 500);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null); // layout for our JFrame should be null

		// Creating a JLayeredPane
		JLayeredPane layeredPaneOne = new JLayeredPane();
		layeredPaneOne.setBounds(0, 0, 500, 500);

		// Adding components to our JLayeredPane
		JLabel labelOne = new JLabel();
		labelOne.setOpaque(true);
		labelOne.setBackground(Color.RED);
		labelOne.setBounds(50, 50, 200, 200);

		JLabel labelTwo = new JLabel();
		labelTwo.setOpaque(true);
		labelTwo.setBackground(Color.GREEN);
		labelTwo.setBounds(100, 100, 200, 200);

		JLabel labelThree = new JLabel();
		labelThree.setOpaque(true);
		labelThree.setBackground(Color.BLUE);
		labelThree.setBounds(150, 150, 200, 200);

		// Adding JLabels to our JLayeredPane
//		layeredPaneOne.add(labelOne, JLayeredPane.DEFAULT_LAYER); // bottom most layer
//		layeredPaneOne.add(labelTwo, JLayeredPane.DEFAULT_LAYER);
//		layeredPaneOne.add(labelThree, JLayeredPane.DRAG_LAYER); // top most layer
		
		// Another way of adding JLabels in JLayeredPane while setting their order
		layeredPaneOne.add(labelOne, Integer.valueOf(0)); // bottom most layer
		layeredPaneOne.add(labelTwo, Integer.valueOf(1)); // top of labelOne
		layeredPaneOne.add(labelThree, Integer.valueOf(2));

		mainFrame.add(layeredPaneOne);

		mainFrame.setVisible(true);
	}

}

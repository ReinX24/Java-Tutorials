import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JavaGridLayoutMain {

	public static void main(String[] args) {

		// Layout Manager = Defines the natural layout for components within a container

		// GridLayout = places components in a grid of cells.
		// Each component takes all the available space within its cell,
		// and each cell is the same size.

		// Creating a JFrame with a Grid Layout
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("[Java Grid Layout]");
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(true);
//		mainFrame.getContentPane().setBackground(Color.WHITE);

		// Setting our JFrame to have a Grid Layout manager
		mainFrame.setLayout(new GridLayout(3, 3, 5, 5)); // number of rows, columns, x margins (between columns), y
															// margins (between rows)

		// Creating and adding JButtons to our JFrame
//		JButton BUTTON_1 = new JButton("1");
//		mainFrame.add(BUTTON_1);

		mainFrame.add(new Button("1"));
		mainFrame.add(new Button("2"));
		mainFrame.add(new Button("3"));
		mainFrame.add(new Button("4"));
		mainFrame.add(new Button("5"));
		mainFrame.add(new Button("6"));
		mainFrame.add(new Button("7"));
		mainFrame.add(new Button("8"));
		mainFrame.add(new Button("9"));
		mainFrame.add(new Button("10")); // breaks 3 x 3 window

		mainFrame.setVisible(true);
	}

}

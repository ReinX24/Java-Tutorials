import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaFlowLayoutMain {

	public static void main(String[] args) {

		// Layout Manager = Defines the natural layout for components within a container

		// FlowLayout = places components in a row, sized at their preferred size.
		// If the horizontal space in the container is too small,
		// the FlowLayout class uses the next available row.

		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("[Flow Layout]");
		mainFrame.setSize(500, 500);
		mainFrame.getContentPane().setBackground(new Color(0, 128, 128));
		mainFrame.setResizable(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Setting the layout of mainFrame to FlowLayout, JFrames use BorderLayout by
		// default
//		mainFrame.setLayout(new FlowLayout(FlowLayout.LEADING)); // moves the components to the left side
//		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER)); // default orientation, components are at the center
//		mainFrame.setLayout(new FlowLayout(FlowLayout.TRAILING)); // right hand side

		// Adding spaces between the components
		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20)); // x y spacing

		// Creating a JPanel to hold our JButtons
		JPanel panelOne = new JPanel();
		panelOne.setBackground(new Color(255, 128, 0));
		panelOne.setPreferredSize(new Dimension(400, 400));
		panelOne.setForeground(Color.WHITE);

		panelOne.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		// Creating buttons to add to the JFrame
//		JButton buttonOne = new JButton("1");
//		mainFrame.add(buttonOne);

		// Another way of adding buttons to the JFrame
		panelOne.add(new Button("1"));
		panelOne.add(new Button("2"));
		panelOne.add(new Button("3"));
		panelOne.add(new Button("4"));
		panelOne.add(new Button("5"));
		panelOne.add(new Button("6"));
		panelOne.add(new Button("7"));
		panelOne.add(new Button("8"));
		panelOne.add(new Button("9"));

		// Adding JPanel to JFrame
		mainFrame.add(panelOne);

		// Set visibility at the end, this is so that all components will show at
		// runtime
		mainFrame.setVisible(true);

	}

}

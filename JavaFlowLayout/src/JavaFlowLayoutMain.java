import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER)); // default orientation, components are at the center
//		mainFrame.setLayout(new FlowLayout(FlowLayout.TRAILING)); // right hand side

		// Creating buttons to add to the JFrame
//		JButton buttonOne = new JButton("1");
//		mainFrame.add(buttonOne);

		// Another way of adding buttons to the JFrame
		mainFrame.add(new Button("1"));
		mainFrame.add(new Button("2"));
		mainFrame.add(new Button("3"));
		mainFrame.add(new Button("4"));
		mainFrame.add(new Button("5"));
		mainFrame.add(new Button("6"));
		mainFrame.add(new Button("7"));
		mainFrame.add(new Button("8"));
		mainFrame.add(new Button("9"));

		// Set visibility at the end, this is so that all components will show at
		// runtime
		mainFrame.setVisible(true);

	}

}

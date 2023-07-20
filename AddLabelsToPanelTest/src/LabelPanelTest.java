import java.awt.Dimension;

import javax.swing.*;
import java.util.Stack;

public class LabelPanelTest extends JFrame {

	JPanel mainPanel;

	public LabelPanelTest() {
		this.setTitle("Label Panel Test");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(640, 480));

		this.add(mainPanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		addJLabelArray();
		addStack();
	}

	public void addJLabelArray() {
		JLabel[] jLabelArray = new JLabel[5];
		JLabel labelOne = new JLabel("Label 1");
		JLabel labelTwo = new JLabel("Label 2");
		JLabel labelThree = new JLabel("Label 3");
		JLabel labelFour = new JLabel("Label 4");
		JLabel labelFive = new JLabel("Label 5");

		jLabelArray[0] = labelOne;
		jLabelArray[1] = labelTwo;
		jLabelArray[2] = labelThree;
		jLabelArray[3] = labelFour;
		jLabelArray[4] = labelFive;

		for (int i = 0; i < jLabelArray.length; i++) {
			mainPanel.add(jLabelArray[i]);
		}
		// This works normally, adds the JLabels to the mainPanel as expected
	}

	public void addStack() {
		Stack<String> myStack = new Stack<String>();
		myStack.add("Mouse");
		myStack.add("Keyboard");
		myStack.add("Monitor");

		for (int i = 0; i < myStack.size(); i++) {
			mainPanel.add(new JLabel(myStack.elementAt(i)));
		}
		// This also works normally, I guess I just messed something up in my Grocery
		// list project
	}

	public static void main(String[] args) {
		new LabelPanelTest();
	}

}

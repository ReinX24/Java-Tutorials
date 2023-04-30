package LambdaActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {

	JButton buttonOne = new JButton("#1");
	JButton buttonTwo = new JButton("#2");
	JButton buttonThree = new JButton("#3");

	public MyFrame() {

		this.setTitle("[Lambda Expressions ActionListener]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0, 128, 128));

		buttonOne.setBounds(100, 150, 100, 100);
		buttonOne.setFocusable(false);
		buttonOne.addActionListener((arg0) -> System.out.println("#1 Pressed!"));
		this.add(buttonOne);

		buttonTwo.setBounds(200, 150, 100, 100);
		buttonTwo.setFocusable(false);
		buttonTwo.addActionListener((arg0) -> System.out.println("#2 Pressed!"));
		this.add(buttonTwo);

		buttonThree.setBounds(300, 150, 100, 100);
		buttonThree.setFocusable(false);
		buttonThree.addActionListener((arg0) -> System.out.println("#3 Pressed!"));
		this.add(buttonThree);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}

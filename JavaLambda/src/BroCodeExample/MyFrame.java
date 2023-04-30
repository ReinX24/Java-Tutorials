package BroCodeExample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame {

	JButton myButton = new JButton("< MY BUTTON >");
	JButton myButton2 = new JButton("< ANOTHER BUTTON >");

	public MyFrame() {

		this.setTitle("Lambda Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(null);

		myButton.setBounds(100, 100, 300, 100);
		myButton.setFocusable(false);

		// instead of adding an ActionListener and creating an actionPerformed method,
		// we use lambda expressions instead
		myButton.addActionListener((arg0) -> System.out.println("You clicked a button!"));

		this.add(myButton);

		myButton2.setBounds(100, 250, 300, 100);
		myButton2.setFocusable(false);
		myButton2.addActionListener((e) -> System.out.println("You clicked button two!"));
		
		this.add(myButton2);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}

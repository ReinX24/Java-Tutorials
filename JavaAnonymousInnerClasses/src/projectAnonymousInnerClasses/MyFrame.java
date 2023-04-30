package projectAnonymousInnerClasses;

import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame {

	JButton buttonOne = new JButton("#1");
	JButton buttonTwo = new JButton("#2");
	JButton buttonThree = new JButton("#3");

	public MyFrame() {

		this.setTitle("Anonymous Inner Classes Project by Bro Code");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(null);

		buttonOne.setBounds(100, 100, 100, 100);
		// Using Anonymous inner classes
		buttonOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You pressed button #1!");
			}

		});

		this.add(buttonOne);

		buttonTwo.setBounds(200, 100, 100, 100);
		buttonTwo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You pressed button #2!");
			}

		});

		this.add(buttonTwo);

		buttonThree.setBounds(300, 100, 100, 100);
		buttonThree.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You pressed button #3!");
			}
		});

		this.add(buttonThree);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}

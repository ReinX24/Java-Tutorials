package practiceAnonymousInnerClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PracticeFrame extends JFrame {

	JButton buttonOne = new JButton("[#1]");
	JButton buttonTwo = new JButton("[#2]");
	JButton buttonThree = new JButton("[#3]");

	public PracticeFrame() {

		this.setTitle("[Anonymous Inner Classes Practice]");
		this.setSize(500, 500);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		buttonOne.setBounds(100, 100, 100, 100);
		buttonOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("#1 Pressed!");
			}
		});

		this.add(buttonOne);

		buttonTwo.setBounds(200, 100, 100, 100);
		buttonTwo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("#2 Pressed!");
			}
		});

		this.add(buttonTwo);

		buttonThree.setBounds(300, 100, 100, 100);
		buttonThree.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("#3 Pressed!");
			}

		});

		this.add(buttonThree);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}

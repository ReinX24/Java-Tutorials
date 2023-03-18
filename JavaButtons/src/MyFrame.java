import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MyFrame extends JFrame implements ActionListener { // extends JFrame & implements ActionListener

	JButton buttonOne;
	JLabel labelOne;

	public MyFrame() {
		this.setVisible(true);
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);
		this.setResizable(false);
		this.setTitle("[ MyFrame : JFrame ]");
		this.setLayout(null);

		// Creating a button
		buttonOne = new JButton();
		buttonOne.setBounds(200, 300, 600, 400);
//		buttonOne.addActionListener(e -> System.out.println("[Lambda Expression in Java!]")); // using lambda expressions
		// ^ we need this so that the button executes its function
		buttonOne.addActionListener(this);

		// Adding text to our button
		buttonOne.setText("[I am a button!]");
		buttonOne.setFocusable(false); // gets rid of text around our button
		buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
		buttonOne.setIconTextGap(20);
		buttonOne.setForeground(new Color(0, 128, 128));
		buttonOne.setBackground(new Color(255, 128, 0));

		// Adding a border to our button
		buttonOne.setBorder(BorderFactory.createEtchedBorder());

		// Adding a photo to our button
		ImageIcon buttonIcon = new ImageIcon("greenFrog.png");
		buttonOne.setIcon(buttonIcon);

		// Moving the text of the button
		buttonOne.setHorizontalTextPosition(JButton.CENTER);
		buttonOne.setVerticalTextPosition(JButton.TOP);

		// Disabling a button
//		buttonOne.setEnabled(false); // makes it so that you cannot press the button

		// Adding button to our JFrame
		this.add(buttonOne);

		// When the button is pressed, add a JLabel to it
		labelOne = new JLabel();
		ImageIcon buttonActionPhoto = new ImageIcon("play_button.png");
		labelOne.setIcon(buttonActionPhoto);
		labelOne.setBounds(350, 0, 300, 300); // icon will appear above the button
		labelOne.setVisible(false); // false for now, when the button is pressed it will turn true
		this.add(labelOne); // adding the label to our frame

	}

	// From implementing ActionListener
	@Override
	public void actionPerformed(ActionEvent buttonAction) {
		if (buttonAction.getSource() == buttonOne) {
			System.out.println("[Button Pressed]");
			// Disabling the button after it was clicked on once
			buttonOne.setEnabled(false);
			// Show our JLabel when we click the button
			labelOne.setVisible(true);
		}
	}

}

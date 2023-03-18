package practiceJavaButtons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PracticeFrame extends JFrame implements ActionListener {

	JButton fighterButton;
	JButton wizardButton;
	JButton healerButton;

	public PracticeFrame() {
		// Instantiating the attributes of our JFrame
		this.setVisible(true);
		this.setSize(1000, 1000);
		this.getContentPane().setBackground(Color.GRAY);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("[ RPG Class Menu]");
		this.setLayout(null);

		// Adding 3 buttons to our JFrame, each button represents a class (Fighter,
		// Wizard, Healer)
		fighterButton = new JButton();
		fighterButton.setBounds(100, 100, 200, 200);
		fighterButton.setFocusable(false);
		fighterButton.addActionListener(this);
		this.add(fighterButton);

		wizardButton = new JButton();
		wizardButton.setBounds(400, 100, 200, 200);
		wizardButton.setFocusable(false);
		wizardButton.addActionListener(this);
		this.add(wizardButton);

		healerButton = new JButton();
		healerButton.setBounds(700, 100, 200, 200);
		healerButton.setFocusable(false);
		healerButton.addActionListener(this);
		this.add(healerButton);

		// Adding JLabels to each of our buttons
		JLabel fighterLabel = new JLabel();
		fighterLabel.setText("[Fighter]");
		fighterLabel.setFont(new Font("Arial", Font.BOLD, 16));
		fighterLabel.setHorizontalTextPosition(JLabel.CENTER);
		fighterLabel.setVerticalTextPosition(JLabel.TOP);
		fighterButton.add(fighterLabel);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// if the Fighter button is the one pressed
		if (arg0.getSource() == fighterButton) {
			System.out.println("[Fighter Chosen!]");
		} else if (arg0.getSource() == wizardButton) {
			System.out.println("[Wizard Chosen!]");
		} else if (arg0.getSource() == healerButton) {
			System.out.println("[Healer Chosen!]");
		}
	}

}

package practiceJavaButtons;

import java.awt.BorderLayout;
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

public class PracticeFrame extends JFrame implements ActionListener {

	JButton fighterButton;
	JButton wizardButton;
	JButton healerButton;
	
	JLabel fighterPortrait;
	JLabel wizardPortrait;
	JLabel healerPortrait;

	public PracticeFrame() {
		// Instantiating the attributes of our JFrame
		this.setVisible(true);
		this.setSize(1000, 1000);
		this.getContentPane().setBackground(Color.GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("[ RPG Class Menu]");
		this.setLayout(null);

		// Adding 3 buttons to our JFrame, each button represents a class (Fighter,
		// Wizard, Healer)
		fighterButton = new JButton();
		fighterButton.setBounds(100, 100, 200, 300); // x y width height
		fighterButton.setFocusable(false);
		fighterButton.addActionListener(this);
		fighterButton.setBackground(new Color(255, 128, 0));
		fighterButton.setBorder(BorderFactory.createEtchedBorder());
		fighterButton.setLayout(new BorderLayout());
		this.add(fighterButton);

		wizardButton = new JButton();
		wizardButton.setBounds(400, 100, 200, 300);
		wizardButton.setFocusable(false);
		wizardButton.addActionListener(this);
		wizardButton.setBackground(new Color(0, 128, 128));
		wizardButton.setBorder(BorderFactory.createEtchedBorder());
		wizardButton.setLayout(new BorderLayout());
		this.add(wizardButton);

		healerButton = new JButton();
		healerButton.setBounds(700, 100, 200, 300);
		healerButton.setFocusable(false);
		healerButton.addActionListener(this);
		healerButton.setBackground(new Color(248, 240, 227));
		healerButton.setBorder(BorderFactory.createEtchedBorder());
		healerButton.setLayout(new BorderLayout());
		this.add(healerButton);

		// Adding JLabels to each of our buttons

		// Fighter Class
		JLabel fighterLabel = new JLabel();
		fighterLabel.setText("[Fighter]");
		fighterLabel.setFont(new Font("Arial", Font.BOLD, 16));
		fighterLabel.setVisible(true);

		ImageIcon fighterIcon = new ImageIcon("warriorSword.png");
		fighterLabel.setHorizontalAlignment(JLabel.CENTER);
		fighterLabel.setVerticalAlignment(JLabel.CENTER);
		fighterLabel.setHorizontalTextPosition(JLabel.CENTER);
		fighterLabel.setVerticalTextPosition(JLabel.TOP);
		fighterLabel.setIcon(fighterIcon);

		fighterButton.add(fighterLabel);

		// Wizard Class
		JLabel wizardLabel = new JLabel();
		wizardLabel.setText("[Wizard]");
		wizardLabel.setFont(new Font("Arial", Font.BOLD, 16));
		wizardLabel.setVisible(true);

		ImageIcon wizardIcon = new ImageIcon("wizardStaff.png");
		wizardLabel.setHorizontalAlignment(JLabel.CENTER);
		wizardLabel.setVerticalAlignment(JLabel.CENTER);
		wizardLabel.setHorizontalTextPosition(JLabel.CENTER);
		wizardLabel.setVerticalTextPosition(JLabel.TOP);
		wizardLabel.setIcon(wizardIcon);

		wizardButton.add(wizardLabel);

		// Healer Class
		JLabel healerLabel = new JLabel();
		healerLabel.setText("[Healer]");
		healerLabel.setFont(new Font("Arial", Font.BOLD, 16));
		healerLabel.setVisible(true);

		ImageIcon healerIcon = new ImageIcon("healerStaff.png");
		healerLabel.setHorizontalAlignment(JLabel.CENTER);
		healerLabel.setVerticalAlignment(JLabel.TOP);
		healerLabel.setHorizontalTextPosition(JLabel.CENTER);
		healerLabel.setVerticalTextPosition(JLabel.CENTER);
		healerLabel.setIcon(healerIcon);

		healerButton.add(healerLabel);

		// TODO: move the photos outside of the buttons, putting them inside the buttons
		// does not show them sometimes
		
		

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

		// Disables the buttons once the user has pressed one
		fighterButton.setEnabled(false);
		wizardButton.setEnabled(false);
		healerButton.setEnabled(false);
	}

}

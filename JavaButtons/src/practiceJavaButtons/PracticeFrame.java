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
		fighterButton.setText("[Fighter]");
		fighterButton.setFont(new Font("Arial", Font.BOLD, 16));
		fighterButton.setBounds(100, 100, 200, 300); // x y width height
		fighterButton.setFocusable(false);
		fighterButton.addActionListener(this);
		fighterButton.setBackground(new Color(255, 128, 0));
		fighterButton.setBorder(BorderFactory.createEtchedBorder());
		fighterButton.setLayout(new BorderLayout());
		fighterButton.setHorizontalTextPosition(JButton.CENTER);
		fighterButton.setVerticalTextPosition(JButton.TOP);
		this.add(fighterButton);

		wizardButton = new JButton();
		wizardButton.setText("[Wizard]");
		wizardButton.setFont(new Font("Arial", Font.BOLD, 16));
		wizardButton.setBounds(400, 100, 200, 300);
		wizardButton.setFocusable(false);
		wizardButton.addActionListener(this);
		wizardButton.setBackground(new Color(0, 128, 128));
		wizardButton.setBorder(BorderFactory.createEtchedBorder());
		wizardButton.setLayout(new BorderLayout());
		wizardButton.setHorizontalTextPosition(JButton.CENTER);
		wizardButton.setVerticalTextPosition(JButton.TOP);
		this.add(wizardButton);

		healerButton = new JButton();
		healerButton.setText("[Healer]");
		healerButton.setFont(new Font("Arial", Font.BOLD, 16));
		healerButton.setBounds(700, 100, 200, 300);
		healerButton.setFocusable(false);
		healerButton.addActionListener(this);
		healerButton.setBackground(new Color(248, 240, 227));
		healerButton.setBorder(BorderFactory.createEtchedBorder());
		healerButton.setLayout(new BorderLayout());
		healerButton.setHorizontalTextPosition(JButton.CENTER);
		healerButton.setVerticalTextPosition(JButton.TOP);
		this.add(healerButton);

		// Adding JLabels to each of our buttons

		// Fighter Class
		ImageIcon fighterIcon = new ImageIcon("warriorSword.png");
		fighterButton.setIcon(fighterIcon);

		// Wizard Class
		ImageIcon wizardIcon = new ImageIcon("wizardStaff.png");
		wizardButton.setIcon(wizardIcon);

		// Healer Class
		ImageIcon healerIcon = new ImageIcon("healerStaff.png");
		healerButton.setIcon(healerIcon);

		// Fighter Portrait
		fighterPortrait = new JLabel();
		fighterPortrait.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		fighterPortrait.setBounds(140, 500, 720, 400);
		fighterPortrait.setVisible(false);

		ImageIcon fighterPortraitImage = new ImageIcon("fighterPortrait.jpeg");
		fighterPortrait.setIcon(fighterPortraitImage);
		this.add(fighterPortrait);

		// Magician Portrait
		wizardPortrait = new JLabel();
		wizardPortrait.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		wizardPortrait.setBounds(140, 500, 720, 400);
		wizardPortrait.setVisible(false);

		ImageIcon wizardPortraitImage = new ImageIcon("wizardPortrait.jpg");
		wizardPortrait.setIcon(wizardPortraitImage);
		this.add(wizardPortrait);

		// Healer Portrait
		healerPortrait = new JLabel();
		healerPortrait.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		healerPortrait.setBounds(140, 500, 720, 400);
		healerPortrait.setVisible(false);

		ImageIcon healerPortraitImage = new ImageIcon("healerPortrait.jpg");
		healerPortrait.setIcon(healerPortraitImage);
		this.add(healerPortrait);

		// TODO: Add text to each of the class' portraits & add a title at the top

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// if the Fighter button is the one pressed
		if (arg0.getSource() == fighterButton) {
			System.out.println("[Fighter Chosen!]");
			fighterPortrait.setVisible(true);
		} else if (arg0.getSource() == wizardButton) {
			System.out.println("[Wizard Chosen!]");
			wizardPortrait.setVisible(true);
		} else if (arg0.getSource() == healerButton) {
			System.out.println("[Healer Chosen!]");
			healerPortrait.setVisible(true);
		}

		// Disables the buttons once the user has pressed one
		fighterButton.setEnabled(false);
		wizardButton.setEnabled(false);
		healerButton.setEnabled(false);
	}

}

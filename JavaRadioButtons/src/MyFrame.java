import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class MyFrame extends JFrame implements ActionListener {

	JRadioButton pizzaButton;
	JRadioButton hamburgerButton;
	JRadioButton hotdogButton;

	ImageIcon pizzaIcon;
	ImageIcon hamburgerIcon;
	ImageIcon hotdogIcon;

	public MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		// Creating 3 radio buttons for our JFrame

		pizzaButton = new JRadioButton("Pizza 🍕");
		hamburgerButton = new JRadioButton("Hamburger 🍔");
		hotdogButton = new JRadioButton("Hotdog 🌭");

		// Creating a button group, this is so that we can only choose one option at a
		// time

		ButtonGroup foodButtons = new ButtonGroup(); // no need to add to our JFrame
		foodButtons.add(pizzaButton);
		foodButtons.add(hamburgerButton);
		foodButtons.add(hotdogButton);

		pizzaButton.addActionListener(this);
		hamburgerButton.addActionListener(this);
		hotdogButton.addActionListener(this);

		// Adding ImageIcons to our radio buttons
		pizzaIcon = new ImageIcon("healerStaff.png");
		hamburgerIcon = new ImageIcon("warriorSword.png");
		hotdogIcon = new ImageIcon("wizardStaff.png");

		// Replacing the buttons' images
		pizzaButton.setIcon(pizzaIcon);
		hamburgerButton.setIcon(hamburgerIcon);
		hotdogButton.setIcon(hotdogIcon);

		this.add(pizzaButton);
		this.add(hamburgerButton);
		this.add(hotdogButton);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == pizzaButton) {
			JOptionPane.showMessageDialog(null, "You ordered a pizza! 🍕", "[Pizza Order]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == hamburgerButton) {
			JOptionPane.showMessageDialog(null, "You ordered a hamburger! 🍔", "[Hamburger Order]",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == hotdogButton) {
			JOptionPane.showMessageDialog(null, "You ordered a hotdog! 🌭", "[Hotdog Order]",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

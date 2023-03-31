package practiceChooseClass;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class ClassFrame extends JFrame implements ActionListener {

	JRadioButton warriorClass;
	JRadioButton wizardClass;
	JRadioButton healerClass;

	public ClassFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		JLabel instructionText = new JLabel("[Choose Your Class]");

		warriorClass = new JRadioButton("[Warrior]");
		warriorClass.setFocusable(false);
		warriorClass.addActionListener(this);

		wizardClass = new JRadioButton("[Wizard]");
		wizardClass.setFocusable(false);
		wizardClass.addActionListener(this);

		healerClass = new JRadioButton("[Healer]");
		healerClass.setFocusable(false);
		healerClass.addActionListener(this);

		this.add(instructionText);
		this.add(warriorClass);
		this.add(wizardClass);
		this.add(healerClass);

		// Adding Icons to our JRadioButtons
		ImageIcon warriorIcon = new ImageIcon("warriorSword.png");
		ImageIcon wizardIcon = new ImageIcon("wizardStaff.png");
		ImageIcon healerIcon = new ImageIcon("healerStaff.png");

		warriorClass.setIcon(warriorIcon);
		wizardClass.setIcon(wizardIcon);
		healerClass.setIcon(healerIcon);

		ButtonGroup classButtons = new ButtonGroup();
		classButtons.add(warriorClass);
		classButtons.add(wizardClass);
		classButtons.add(healerClass);

		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == warriorClass) {
			JOptionPane.showMessageDialog(null, "Warrior Chosen!", "[Warrior Class]", JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == wizardClass) {
			JOptionPane.showMessageDialog(null, "Wizard Chosen!", "[Wizard Class]", JOptionPane.INFORMATION_MESSAGE);
		} else if (arg0.getSource() == healerClass) {
			JOptionPane.showMessageDialog(null, "Healer Chosen!", "[Healer Class]", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

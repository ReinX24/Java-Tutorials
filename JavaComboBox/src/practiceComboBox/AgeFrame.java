package practiceComboBox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Year;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AgeFrame extends JFrame implements ActionListener {

	JLabel enterNamePrompt;
	JComboBox<Integer> ageNumbersBox;
	JButton submitAgeButton;

	int eachYear;
	Integer[] ageArray;

	public AgeFrame() {
		this.setTitle("[Age Combo Box]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		enterNamePrompt = new JLabel("[Enter Year Born]");
		enterNamePrompt.setBounds(150, 50, 200, 50);
		enterNamePrompt.setHorizontalAlignment(JLabel.CENTER);
		enterNamePrompt.setOpaque(true);
		enterNamePrompt.setBackground(Color.WHITE);
		enterNamePrompt.setForeground(Color.BLACK);
		enterNamePrompt.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		ageArray = new Integer[Year.now().getValue() - 1900 + 1];

		eachYear = 1900;
		for (int i = 0; i < ageArray.length; i++) {
			ageArray[i] = eachYear++;
		}

		ageNumbersBox = new JComboBox<Integer>(ageArray);
		ageNumbersBox.setBounds(100, 150, 300, 50);
		ageNumbersBox.setSelectedIndex(-1); // starts at no number

		// Using JComboBox methods
//		ageNumbersBox.setEditable(true); // user can type in their own number
//		System.out.println(ageNumbersBox.getItemCount()); // prints amount of choices
//		ageNumbersBox.addItem(2024); // adds to the list of choices
//		ageNumbersBox.insertItemAt(1899, 0); // adds a choice to a specific index
//		ageNumbersBox.setSelectedIndex(2); // changes index of where the choices start for the user
//		ageNumbersBox.removeItem(1901); // removes an item from the JComboBox
//		ageNumbersBox.removeItemAt(1); // removes an item at a certain index
//		ageNumbersBox.removeAllItems(); // removes all of the choices

		submitAgeButton = new JButton("[Submit]");
		submitAgeButton.setBounds(150, 250, 200, 50);
		submitAgeButton.setFocusable(false);
		submitAgeButton.addActionListener(this);

		this.add(enterNamePrompt);
		this.add(ageNumbersBox);
		this.add(submitAgeButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == submitAgeButton) {
			int userAge = Year.now().getValue() - Integer.parseInt(ageNumbersBox.getSelectedItem().toString());

			JOptionPane.showMessageDialog(null, "Birthyear : " + ageNumbersBox.getSelectedItem() + "\nAge : " + userAge,
					"[Age Window]", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {

	JComboBox mainComboBox;

	public MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		String[] myAnimals = { "Dog", "Cat", "Bird" }; // will serve as choices for our JComboBox
		Integer[] myIntegers = { 1, 2, 3 }; // we need to use Integer instead of int because Combo Boxes only accept
											// object data types

		mainComboBox = new JComboBox(myIntegers); // pass in an array of Strings (object data type)
		mainComboBox.addActionListener(this);

//		mainComboBox.setEditable(true); // makes user able to type in their choice
//		System.out.println(mainComboBox.getItemCount());
//		mainComboBox.addItem("Horse");
//		mainComboBox.insertItemAt("Pig", 0); // String, index
//		mainComboBox.setSelectedIndex(2);
//		mainComboBox.removeItem("Cat"); // removes Cat from choices
//		mainComboBox.removeItemAt(0); // removes item at index 0
//		mainComboBox.removeAllItems(); // removes all choices

		this.add(mainComboBox);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mainComboBox) {
//			System.out.println(mainComboBox.getSelectedItem()); // returns String
			System.out.println(mainComboBox.getSelectedIndex()); // returns index
		}
	}

}

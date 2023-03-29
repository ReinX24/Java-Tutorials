import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {

	JTextField textField;
	JButton buttonOne;

	public MainFrame() {
		this.setTitle("[Java Text Field]");
		this.setLayout(new FlowLayout());

		// Creating JTextField
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250, 40));
		
		// Changing different attributes in our TextField
		textField.setFont(new Font("Consolas", Font.PLAIN, 16));
		textField.setForeground(new Color(0x008080)); // changes text color
		textField.setBackground(Color.LIGHT_GRAY); // changes background
		textField.setCaretColor(Color.RED); // changes blinking cursor color
		textField.setText("[Enter your name]"); // adds text to TextField
//		textField.setEditable(false); // cannot type in TextField

		// Creating a JButton for TextField
		buttonOne = new JButton("[Submit]");
		buttonOne.addActionListener(this);

		this.add(buttonOne);
		this.add(textField); // add TextField before packing frame
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == buttonOne) {
			System.out.println("Welcome " + textField.getText());
			textField.setEditable(false); // cannot type in TextField
			buttonOne.setEnabled(false); // cannot click on button
		}
	}

}

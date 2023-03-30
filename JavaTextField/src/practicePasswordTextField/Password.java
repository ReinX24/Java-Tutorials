package practicePasswordTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Password extends JFrame implements ActionListener {

	TextField mainTextField;
	JButton submitButton;

	public Password() {
		// Finish creating a JFrame for our Java Text Field
		this.setTitle("[Enter Password]");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		// Creating a TextField for our JFrame
		mainTextField = new TextField();
		mainTextField.setPreferredSize(new Dimension(300, 50));
		mainTextField.setForeground(Color.WHITE);
		mainTextField.setBackground(new Color(0, 128, 128));
		mainTextField.setFont(new Font("Arial", Font.PLAIN, 18));
		mainTextField.setText("[Enter Password]");

		// Creating a button for our TextField
		submitButton = new JButton("[Submit]");
		submitButton.setPreferredSize(new Dimension(100, 50));
		submitButton.setBackground(new Color(156, 157, 151));
		submitButton.setForeground(new Color(249, 255, 255));
		submitButton.setFocusable(false);
		submitButton.addActionListener(this);

		// Adding components to JFrame
		this.add(submitButton);
		this.add(mainTextField);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == submitButton) {
			String userInput = mainTextField.getText();
			if (userInput.equals("minecraft64")) {
				JOptionPane.showMessageDialog(null, "[Password Confirmed!]", "[Password Check]",
						JOptionPane.INFORMATION_MESSAGE);
				mainTextField.setEditable(false);
				submitButton.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(null, "[Password Denied!]", "[Password Denied]",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}

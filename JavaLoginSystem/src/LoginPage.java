import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {

	HashMap<String, String> loginInfoMap;

	JFrame loginPageFrame = new JFrame("Java Login Page");
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");

	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();

	JLabel userIDLabel = new JLabel("User ID:");
	JLabel userPasswordLabel = new JLabel("Password:");

	JLabel loginStatusLabel = new JLabel();

	public LoginPage(HashMap<String, String> loginInfoMapOriginal) {
		this.loginInfoMap = loginInfoMapOriginal; // copies our hashmap to a local variable

		loginPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginPageFrame.setSize(420, 420);
		loginPageFrame.setLayout(null);

		userIDLabel.setBounds(50, 100, 75, 25);

		userPasswordLabel.setBounds(50, 150, 75, 25);

		loginStatusLabel.setBounds(125, 250, 250, 32);
		loginStatusLabel.setFont(new Font("Arial", Font.ITALIC, 20));

		userIDField.setBounds(125, 100, 200, 25);

		userPasswordField.setBounds(125, 150, 200, 25);

		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);

		resetButton.setBounds(225, 200, 100, 25);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);

		loginPageFrame.add(userIDLabel);
		loginPageFrame.add(userPasswordLabel);
		loginPageFrame.add(loginStatusLabel);

		loginPageFrame.add(userIDField);
		loginPageFrame.add(userPasswordField);

		loginPageFrame.add(loginButton);
		loginPageFrame.add(resetButton);

		loginPageFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == loginButton) {
			String userIDInput = userIDField.getText();
			String userPasswordInput = String.valueOf(userPasswordField.getPassword());

			// Checking if the entered user id is contained in our hashmap
			if (loginInfoMap.containsKey(userIDInput)) {
				// Verifying password
				if (loginInfoMap.get(userIDInput).equals(userPasswordInput)) { // getting userIDInput value (password)
																				// and verifying it
					loginStatusLabel.setForeground(Color.GREEN);
					loginStatusLabel.setText("Login Successful!");

					// Create a new WelcomePage password
					WelcomePage programWelcomePage = new WelcomePage();
				} else { // If the password is wrong
					loginStatusLabel.setForeground(Color.RED);
					loginStatusLabel.setText("Wrong Password!");
				}
			} else {
				loginStatusLabel.setForeground(Color.RED);
				loginStatusLabel.setText("Username Not Found!");
			}
		}

		if (arg0.getSource() == resetButton) {
			// Resetting text fields
			userIDField.setText("");
			userPasswordField.setText("");
		}

	}

}

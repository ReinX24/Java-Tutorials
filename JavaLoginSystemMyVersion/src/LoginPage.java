import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	HashMap<String, String> programIDsAndPasswords;

	JPanel mainPanel = new JPanel();

	JLabel loginTitleLabel = new JLabel("LOGIN");

	// TODO: align userIDLabel and userPasswordLabel
	String userIDLabelString = String.format("%20s", "User ID:");
	String userPasswordLabelString = String.format("%20s", "Password:");

	JLabel userIDLabel = new JLabel(userIDLabelString);
	JLabel userPasswordLabel = new JLabel(userPasswordLabelString);

	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");

	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();

	JLabel loginStatusLabel = new JLabel();

	Color backgroundPanelColor = new Color(224, 224, 224);

	public LoginPage(HashMap<String, String> programIDsAndPasswords) {
		this.programIDsAndPasswords = programIDsAndPasswords;

		this.setTitle("Java Login System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		mainPanel.setPreferredSize(new Dimension(640, 480));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
		mainPanel.setBackground(backgroundPanelColor);

		loginTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		loginTitleLabel.setPreferredSize(new Dimension(600, 50));
		loginTitleLabel.setFont(new Font(null, Font.BOLD, 32));

		mainPanel.add(loginTitleLabel);

		userIDLabel.setPreferredSize(new Dimension(300, 50));
		userIDLabel.setFont(new Font(null, Font.PLAIN, 26));
		userIDLabel.setHorizontalAlignment(JLabel.LEFT);

		userIDField.setPreferredSize(new Dimension(300, 50));
		userIDField.setFont(new Font(null, Font.PLAIN, 26));

		mainPanel.add(userIDLabel);
		mainPanel.add(userIDField);

		userPasswordLabel.setPreferredSize(new Dimension(300, 50));
		userPasswordLabel.setFont(new Font(null, Font.PLAIN, 26));
		userPasswordLabel.setHorizontalAlignment(JLabel.LEFT);

		userPasswordField.setPreferredSize(new Dimension(300, 50));
		userPasswordField.setFont(new Font(null, Font.PLAIN, 26));

		mainPanel.add(userPasswordLabel);
		mainPanel.add(userPasswordField);

		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		loginButton.setPreferredSize(new Dimension(300, 50));

		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		resetButton.setPreferredSize(new Dimension(300, 50));

		mainPanel.add(loginButton);
		mainPanel.add(resetButton);

		mainPanel.add(loginStatusLabel);

		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == loginButton) {

			String userIDInput = userIDField.getText();
			String userPasswordInput = String.valueOf(userPasswordField.getPassword());

			if (programIDsAndPasswords.containsKey(userIDInput)) {
				// Getting password of userIDInput key in programIDsAndPasswords hashmap and
				// checking if similar to userPasswordInput
				if (programIDsAndPasswords.get(userIDInput).equals(userPasswordInput)) {
					loginStatusLabel.setText("Login Successful!");
				} else {
					// If the user types in the wrong password but right user ID
					loginStatusLabel.setText("Wrong Password!");
				}
			} else {
				// User ID does not exit
				loginStatusLabel.setText("User ID Not Found!");
			}
		}

		if (arg0.getSource() == resetButton) {
			int confirmResetChoice = JOptionPane.showConfirmDialog(this, "Reset Inputs?", "Reset Confirmation",
					JOptionPane.YES_NO_OPTION);

			if (confirmResetChoice == JOptionPane.YES_OPTION) {
				userIDField.setText("");
				userPasswordField.setText("");
				loginStatusLabel.setText("");
			}
		}

	}

}

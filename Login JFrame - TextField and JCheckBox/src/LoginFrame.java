import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginFrame extends JFrame implements ActionListener {

	JLabel userNamePrompt;
	JLabel userPasswordPrompt;

	TextField userName;
	TextField userPassword;

	JButton loginButton;

	JCheckBox termsAndConditionsBox;

	public LoginFrame() {

		// Creating a JFrame
		this.setSize(500, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		userNamePrompt = new JLabel("Username: ");
		userNamePrompt.setBounds(50, 80, 100, 50);
		userNamePrompt.setForeground(Color.WHITE);

		userPasswordPrompt = new JLabel("Password: ");
		userPasswordPrompt.setBounds(50, 150, 100, 50);
		userPasswordPrompt.setForeground(Color.WHITE);

		userName = new TextField();
		userName.setBounds(150, 80, 300, 50);
		userName.setFont(new Font("Arial", Font.PLAIN, 16));

		userPassword = new TextField();
		userPassword.setBounds(150, 150, 300, 50);
		userPassword.setFont(new Font("Arial", Font.PLAIN, 16));

		termsAndConditionsBox = new JCheckBox();
		termsAndConditionsBox.setText("[Accept Terms & Conditions]");
		termsAndConditionsBox.setHorizontalAlignment(JCheckBox.CENTER);
		termsAndConditionsBox.setFocusable(false);
		termsAndConditionsBox.setBounds(125, 250, 250, 50);
		
		loginButton = new JButton("[Login]");
		loginButton.setBounds(100, 325, 300, 50);
		loginButton.setFocusable(false);

		this.add(userNamePrompt);
		this.add(userPasswordPrompt);
		this.add(userName);
		this.add(userPassword);
		this.add(termsAndConditionsBox);
		this.add(loginButton);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}

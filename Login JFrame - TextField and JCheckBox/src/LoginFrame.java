import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

public class LoginFrame extends JFrame implements ActionListener {

	JLabel loginText;
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

		loginText = new JLabel("[Login Account]");
		loginText.setBounds(50, 15, 400, 50);
		loginText.setHorizontalAlignment(JLabel.CENTER);
		loginText.setOpaque(true);
		loginText.setForeground(Color.WHITE);
		loginText.setBackground(new Color(22, 156, 157));
		loginText.setFont(new Font("Arial", Font.BOLD, 16));
		loginText.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		userNamePrompt = new JLabel("Username: ");
		userNamePrompt.setBounds(50, 90, 100, 50);
		userNamePrompt.setForeground(Color.WHITE);

		userPasswordPrompt = new JLabel("Password: ");
		userPasswordPrompt.setBounds(50, 160, 100, 50);
		userPasswordPrompt.setForeground(Color.WHITE);

		userName = new TextField();
		userName.setBounds(150, 90, 300, 50);
		userName.setFont(new Font("Arial", Font.PLAIN, 16));

		userPassword = new TextField();
		userPassword.setBounds(150, 160, 300, 50);
		userPassword.setFont(new Font("Arial", Font.PLAIN, 16));

		termsAndConditionsBox = new JCheckBox();
		termsAndConditionsBox.setText("[Accept Terms & Conditions]");
		termsAndConditionsBox.setHorizontalAlignment(JCheckBox.CENTER);
		termsAndConditionsBox.setFocusable(false);
		termsAndConditionsBox.setBounds(125, 250, 250, 50);

		loginButton = new JButton("[Login]");
		loginButton.setBounds(100, 325, 300, 50);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);

		this.add(loginText);
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
		if (arg0.getSource() == loginButton) {
			if (userName.getText().equals("Rein") && userPassword.getText().equals("minecraft64")
					&& termsAndConditionsBox.isEnabled()) {

				JOptionPane.showMessageDialog(null, "[Login Successful!]", "[Login Message]",
						JOptionPane.INFORMATION_MESSAGE);

				userName.setEditable(false);
				userPassword.setEditable(false);
				termsAndConditionsBox.setEnabled(false);
				loginButton.setEnabled(false);

			} else {
				JOptionPane.showMessageDialog(null, "[Login Unsuccessful!]", "[Login Message]",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

}

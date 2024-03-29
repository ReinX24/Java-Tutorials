package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PasswordResetPanel extends JPanel implements ActionListener {

	JLabel currentPasswordLabel;
	JLabel confirmCurrentPasswordLabel;
	JLabel newPasswordLabel;
	JLabel confirmNewPasswordLabel;

	static JPasswordField currentPasswordField;
	static JPasswordField confirmPasswordField;
	static JPasswordField newPasswordField;
	static JPasswordField confirmNewPasswordField;
	JCheckBox showPasswordsCheckBox;

	public PasswordResetPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.setPreferredSize(new Dimension(1024, 768));
	}

	public void addResetPasswordPanelComponents() {
		currentPasswordLabel = new JLabel("Current Password:");
		currentPasswordLabel.setPreferredSize(new Dimension(192, 32));

		this.add(currentPasswordLabel);

		currentPasswordField = new JPasswordField();
		currentPasswordField.setPreferredSize(new Dimension(640, 40));

		this.add(currentPasswordField);

		confirmCurrentPasswordLabel = new JLabel("Current Password Again:");
		confirmCurrentPasswordLabel.setPreferredSize(new Dimension(192, 32));

		this.add(confirmCurrentPasswordLabel);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setPreferredSize(new Dimension(640, 40));

		this.add(confirmPasswordField);

		newPasswordLabel = new JLabel("New Password:");
		newPasswordLabel.setPreferredSize(new Dimension(192, 32));

		this.add(newPasswordLabel);

		newPasswordField = new JPasswordField();
		newPasswordField.setPreferredSize(new Dimension(640, 40));

		this.add(newPasswordField);

		confirmNewPasswordLabel = new JLabel("New Password Again:");
		confirmNewPasswordLabel.setPreferredSize(new Dimension(192, 32));

		this.add(confirmNewPasswordLabel);

		confirmNewPasswordField = new JPasswordField();
		confirmNewPasswordField.setPreferredSize(new Dimension(640, 40));

		this.add(confirmNewPasswordField);

		showPasswordsCheckBox = new JCheckBox("Show Passwords");
		showPasswordsCheckBox.setPreferredSize(new Dimension(192, 32));
		showPasswordsCheckBox.setFocusable(false);
		showPasswordsCheckBox.addActionListener(this);

		this.add(showPasswordsCheckBox);

		AccountButtons accountButtons = new AccountButtons();
		this.add(accountButtons.addConfirmResetPasswordButton());
	}

	public static String getCurrentPassword() {
		return String.valueOf(currentPasswordField.getPassword());
	}

	public static String getConfirmCurrentPassword() {
		return String.valueOf(confirmPasswordField.getPassword());
	}

	public static String getNewPassword() {
		return String.valueOf(newPasswordField.getPassword());
	}

	public static String getConfirmNewPassword() {
		return String.valueOf(confirmNewPasswordField.getPassword());
	}

	public static void clearPasswordResetFields() {
		currentPasswordField.setText("");
		confirmPasswordField.setText("");
		newPasswordField.setText("");
		confirmNewPasswordField.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (showPasswordsCheckBox.isSelected()) {
			// Shows the passwords instead of asterisks
			currentPasswordField.setEchoChar((char) 0);
			confirmPasswordField.setEchoChar((char) 0);
			newPasswordField.setEchoChar((char) 0);
			confirmNewPasswordField.setEchoChar((char) 0);

		} else {
			// Goes back to showing asterisks
			currentPasswordField.setEchoChar('*');
			confirmPasswordField.setEchoChar('*');
			newPasswordField.setEchoChar('*');
			confirmNewPasswordField.setEchoChar('*');

		}

	}

}

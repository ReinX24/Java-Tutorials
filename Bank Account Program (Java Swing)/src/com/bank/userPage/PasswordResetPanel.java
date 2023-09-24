package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordResetPanel extends JPanel {

	JLabel currentPasswordLabel;
	JLabel confirmCurrentPasswordLabel;
	JLabel newPasswordLabel;
	JLabel confirmNewPasswordLabel;

	// TODO: convert into password fields and find a way to show passwords to the
	// user as text
	static JTextField currentPasswordField;
	static JTextField confirmPasswordField;
	static JTextField newPasswordField;
	static JTextField confirmNewPasswordField;

	public PasswordResetPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.setPreferredSize(new Dimension(1024, 768));
	}

	public void addResetPasswordPanelComponents() {
		currentPasswordLabel = new JLabel("Current Password:");
		currentPasswordLabel.setPreferredSize(new Dimension(192, 32));

		this.add(currentPasswordLabel);

		currentPasswordField = new JTextField();
		currentPasswordField.setPreferredSize(new Dimension(640, 40));

		this.add(currentPasswordField);

		confirmCurrentPasswordLabel = new JLabel("Current Password Again:");
		confirmCurrentPasswordLabel.setPreferredSize(new Dimension(192, 32));

		this.add(confirmCurrentPasswordLabel);

		confirmPasswordField = new JTextField();
		confirmPasswordField.setPreferredSize(new Dimension(640, 40));

		this.add(confirmPasswordField);

		newPasswordLabel = new JLabel("New Password:");
		newPasswordLabel.setPreferredSize(new Dimension(192, 32));

		this.add(newPasswordLabel);

		newPasswordField = new JTextField();
		newPasswordField.setPreferredSize(new Dimension(640, 40));

		this.add(newPasswordField);

		confirmNewPasswordLabel = new JLabel("New Password Again:");
		confirmNewPasswordLabel.setPreferredSize(new Dimension(192, 32));

		this.add(confirmNewPasswordLabel);

		confirmNewPasswordField = new JTextField();
		confirmNewPasswordField.setPreferredSize(new Dimension(640, 40));

		this.add(confirmNewPasswordField);

		AccountButtons accountButtons = new AccountButtons();
		this.add(accountButtons.addConfirmResetPasswordButton());
	}

	public static String getCurrentPassword() {
		return currentPasswordField.getText();
	}

	public static String getNewPassword() {
		return confirmNewPasswordField.getText();
	}

}

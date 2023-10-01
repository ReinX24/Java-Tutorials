package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bank.loginPage.MainPanel;

public class DeleteAccountPanel extends JPanel {

	JLabel instructionsLabel;
	JLabel warningLabel;
	JLabel mailLabel;
	JLabel nameLabel;
	JLabel currentPasswordLabel;
	JLabel confirmCurrentPasswordLabel;

	static JTextField mailField;
	static JTextField nameField;
	static JPasswordField passwordField;
	static JPasswordField confirmPasswordField;

	JCheckBox showPasswordsCheckBox;

	public DeleteAccountPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.setPreferredSize(new Dimension(1024, 768));
	}

	public void addDeleteAccountPanelComponents() {

		instructionsLabel = new JLabel("Enter Account Details To Confirm Account Deletion");
		instructionsLabel.setPreferredSize(new Dimension(1024, 32));
		instructionsLabel.setFont(new Font(null, Font.BOLD, 32));
		instructionsLabel.setForeground(MainPanel.BLACK);
		instructionsLabel.setHorizontalAlignment(JLabel.CENTER);

		this.add(instructionsLabel);

		warningLabel = new JLabel("WARNING: This will permanently delete your account.");
		warningLabel.setPreferredSize(new Dimension(1024, 32));
		warningLabel.setFont(new Font(null, Font.ITALIC, 28));
		warningLabel.setForeground(MainPanel.BLACK);
		warningLabel.setHorizontalAlignment(JLabel.CENTER);

		this.add(warningLabel);

		mailLabel = new JLabel("Email:");
		mailLabel.setPreferredSize(new Dimension(192, 32));
		mailLabel.setFont(new Font(null, Font.BOLD, 16));
		mailLabel.setForeground(MainPanel.BLACK);

		this.add(mailLabel);

		mailField = new JTextField("");
		mailField.setPreferredSize(new Dimension(640, 40));
		mailField.setFont(new Font(null, Font.PLAIN, 16));
		mailField.setForeground(MainPanel.BLACK);

		this.add(mailField);

		nameLabel = new JLabel("Name:");
		nameLabel.setPreferredSize(new Dimension(192, 32));
		nameLabel.setFont(new Font(null, Font.BOLD, 16));
		nameLabel.setForeground(MainPanel.BLACK);

		this.add(nameLabel);

		nameField = new JTextField("");
		nameField.setPreferredSize(new Dimension(640, 40));
		nameField.setFont(new Font(null, Font.PLAIN, 16));
		nameField.setForeground(MainPanel.BLACK);

		this.add(nameField);

		currentPasswordLabel = new JLabel("Password");
		currentPasswordLabel.setPreferredSize(new Dimension(192, 32));
		currentPasswordLabel.setFont(new Font(null, Font.BOLD, 16));
		currentPasswordLabel.setForeground(MainPanel.BLACK);

		this.add(currentPasswordLabel);

		passwordField = new JPasswordField("");
		passwordField.setPreferredSize(new Dimension(640, 40));
		passwordField.setFont(new Font(null, Font.PLAIN, 16));
		passwordField.setForeground(MainPanel.BLACK);

		this.add(passwordField);

		confirmCurrentPasswordLabel = new JLabel("Re-enter Password:");
		confirmCurrentPasswordLabel.setPreferredSize(new Dimension(192, 32));
		confirmCurrentPasswordLabel.setFont(new Font(null, Font.BOLD, 16));
		confirmCurrentPasswordLabel.setForeground(MainPanel.BLACK);

		this.add(confirmCurrentPasswordLabel);

		confirmPasswordField = new JPasswordField("");
		confirmPasswordField.setPreferredSize(new Dimension(640, 40));
		confirmPasswordField.setFont(new Font(null, Font.PLAIN, 16));
		confirmPasswordField.setForeground(MainPanel.BLACK);

		this.add(confirmPasswordField);

		AccountButtons accountButtons = new AccountButtons();
		this.add(accountButtons.addConfirmDeleteAccountButton());

	}
	
	public static String getUserMail() {
		return mailField.getText();
	}
	
	public static String getUserName() {
		return nameField.getText();
	}
	
	public static String getPassword() {
		return String.valueOf(passwordField.getPassword());
	}
	
	public static String getConfirmPassword() {
		return String.valueOf(confirmPasswordField.getPassword());
	}

}

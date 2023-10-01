package com.bank.loginPage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel {

	JLabel enterMailLabel;
	JLabel enterNameLabel;
	JLabel enterPasswordLabel;
	JLabel reEnterPasswordLabel;

	public static JTextField mailField;
	public static JTextField nameField;
	public static JPasswordField passwordField;
	public static JPasswordField reEnterPasswordField;
	
	JCheckBox showRegisterPasswords;

	public RegisterPanel() {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

		enterMailLabel = new JLabel("Email:");
		enterMailLabel.setPreferredSize(new Dimension(192, 32));
		enterMailLabel.setFont(new Font(null, Font.BOLD, 16));
		enterMailLabel.setForeground(MainPanel.BLACK);

		enterNameLabel = new JLabel("Name:");
		enterNameLabel.setPreferredSize(new Dimension(192, 32));
		enterNameLabel.setFont(new Font(null, Font.BOLD, 16));
		enterNameLabel.setForeground(MainPanel.BLACK);

		enterPasswordLabel = new JLabel("Password:");
		enterPasswordLabel.setPreferredSize(new Dimension(192, 32));
		enterPasswordLabel.setFont(new Font(null, Font.BOLD, 16));
		enterPasswordLabel.setForeground(MainPanel.BLACK);

		reEnterPasswordLabel = new JLabel("Re-enter Password:");
		reEnterPasswordLabel.setPreferredSize(new Dimension(192, 32));
		reEnterPasswordLabel.setFont(new Font(null, Font.BOLD, 16));
		reEnterPasswordLabel.setForeground(MainPanel.BLACK);

		mailField = new JTextField("");
		mailField.setPreferredSize(new Dimension(640, 40));
		mailField.setFont(new Font(null, Font.PLAIN, 16));
		mailField.setForeground(MainPanel.BLACK);

		nameField = new JTextField("");
		nameField.setPreferredSize(new Dimension(640, 40));
		nameField.setFont(new Font(null, Font.PLAIN, 16));
		nameField.setForeground(MainPanel.BLACK);

		// TODO: create a JCheckBox that asks the user if they want to show their
		// password or not
		passwordField = new JPasswordField("");
		passwordField.setPreferredSize(new Dimension(640, 40));
		passwordField.setFont(new Font(null, Font.PLAIN, 16));
		passwordField.setForeground(MainPanel.BLACK);

		reEnterPasswordField = new JPasswordField("");
		reEnterPasswordField.setPreferredSize(new Dimension(640, 40));
		reEnterPasswordField.setFont(new Font(null, Font.PLAIN, 16));
		reEnterPasswordField.setForeground(MainPanel.BLACK);

	}

	public void addRegisterPanelComponents() {
		this.add(enterMailLabel);
		this.add(mailField);

		this.add(enterNameLabel);
		this.add(nameField);

		this.add(enterPasswordLabel);
		this.add(passwordField);

		this.add(reEnterPasswordLabel);
		this.add(reEnterPasswordField);

		MainButtons registerButton = new MainButtons();
		this.add(registerButton.getRegisterAccountButton());
		this.add(registerButton.getClearDetailsButton());
	}

	public static String getRegisterMail() {
		return mailField.getText();
	}

	public static String getRegisterName() {
		return nameField.getText();
	}

	public static String getRegisterPassword() {
		return String.valueOf(passwordField.getPassword());
	}

	public static String getRegisterRePassword() {
		return String.valueOf(reEnterPasswordField.getPassword());
	}

}

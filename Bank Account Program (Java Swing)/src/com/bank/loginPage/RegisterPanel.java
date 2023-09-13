package com.bank.loginPage;

import java.awt.Dimension;
import java.awt.FlowLayout;

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

	public RegisterPanel() {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

		enterMailLabel = new JLabel("Email:");
		enterMailLabel.setPreferredSize(new Dimension(192, 32));

		enterNameLabel = new JLabel("Name:");
		enterNameLabel.setPreferredSize(new Dimension(192, 32));

		enterPasswordLabel = new JLabel("Password:");
		enterPasswordLabel.setPreferredSize(new Dimension(192, 32));

		reEnterPasswordLabel = new JLabel("Re-enter Password:");
		reEnterPasswordLabel.setPreferredSize(new Dimension(192, 32));

		mailField = new JTextField();
		mailField.setPreferredSize(new Dimension(640, 40));

		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(640, 40));

		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(640, 40));

		reEnterPasswordField = new JPasswordField();
		reEnterPasswordField.setPreferredSize(new Dimension(640, 40));
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
		this.add(registerButton.addRegisterAccountButton());
		this.add(registerButton.addClearDetailsButton());
	}

	// TODO: add getters for RegisterPanel textfields and refactor code when registering in UserData class
	
}

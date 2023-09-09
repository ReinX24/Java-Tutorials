package com.bank.loginPage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	JLabel enterMailLabel;
	JLabel enterPasswordLabel;
	JLabel reEnterPasswordLabel;

	public static JTextField mailField;
	public static JPasswordField passwordField;
	public static JPasswordField reEnterPasswordField;

	public LoginPanel() {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

		enterMailLabel = new JLabel("Email:");
		enterMailLabel.setPreferredSize(new Dimension(192, 32));

		enterPasswordLabel = new JLabel("Password:");
		enterPasswordLabel.setPreferredSize(new Dimension(192, 32));

		reEnterPasswordLabel = new JLabel("Re-enter Password:");
		reEnterPasswordLabel.setPreferredSize(new Dimension(192, 32));

		mailField = new JTextField();
		mailField.setPreferredSize(new Dimension(640, 40));

		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(640, 40));

		reEnterPasswordField = new JPasswordField();
		reEnterPasswordField.setPreferredSize(new Dimension(640, 40));
	}

	public void addLoginPanelComponents() {
		this.add(enterMailLabel);
		this.add(mailField);

		this.add(enterPasswordLabel);
		this.add(passwordField);

		this.add(reEnterPasswordLabel);
		this.add(reEnterPasswordField);

		MainButtons loginButton = new MainButtons();
		this.add(loginButton.addLoginAccountButton());
		this.add(loginButton.addClearDetailsButton());
	}

}

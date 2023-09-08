package com.bank.loginPage;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class LoginPanel extends JPanel {

	public LoginPanel() {

		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

	}
	// TODO: replace this with a void method
	public LoginPanel initializeLoginPanel() {

		this.add(LoginPage.enterMailLabel);
		this.add(LoginPage.mailField);

		this.add(LoginPage.enterPasswordLabel);
		this.add(LoginPage.passwordField);

		this.add(LoginPage.reEnterPasswordLabel);
		this.add(LoginPage.reEnterPasswordField);

		this.add(LoginPage.loginUserButton);
		this.add(LoginPage.clearButton);

		return this;

	}

}

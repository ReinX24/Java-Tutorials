package com.bank.loginPage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SideButtons implements ActionListener {

	JButton loginButton;
	JButton registerButton;
	JButton aboutButton;

	public SideButtons() {
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		loginButton.setPreferredSize(new Dimension(256, 64));

		registerButton = new JButton("Sign Up");
		registerButton.addActionListener(this);
		registerButton.setFocusable(false);
		registerButton.setPreferredSize(new Dimension(256, 64));

		aboutButton = new JButton("About");
		aboutButton.addActionListener(this);
		aboutButton.setFocusable(false);
		aboutButton.setPreferredSize(new Dimension(256, 64));
	}

	public JButton addLoginButton() {
		return loginButton;
	}

	public JButton addRegisterButton() {
		return registerButton;
	}

	public JButton addAboutButton() {
		return aboutButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {

			LoginPage.mainPanel.remove(LoginPage.aboutPanel);
			LoginPage.mainPanel.add(LoginPage.userPanel);

			LoginPage.userPanel.removeAll();

			LoginPage.userPanel.add(LoginPage.enterMailLabel);
			LoginPage.userPanel.add(LoginPage.mailField);

			LoginPage.userPanel.add(LoginPage.enterPasswordLabel);
			LoginPage.userPanel.add(LoginPage.passwordField);

			LoginPage.userPanel.add(LoginPage.reEnterPasswordLabel);
			LoginPage.userPanel.add(LoginPage.reEnterPasswordField);

			LoginPage.userPanel.add(LoginPage.loginUserButton);
			LoginPage.userPanel.add(LoginPage.clearButton);

			LoginPage.mainPanel.validate();
			LoginPage.mainPanel.repaint();
		}

		if (e.getSource() == registerButton) {

			LoginPage.mainPanel.remove(LoginPage.aboutPanel);
			LoginPage.mainPanel.add(LoginPage.userPanel);

			LoginPage.userPanel.removeAll();

			LoginPage.userPanel.add(LoginPage.enterMailLabel);
			LoginPage.userPanel.add(LoginPage.mailField);

			LoginPage.userPanel.add(LoginPage.enterNameLabel);
			LoginPage.userPanel.add(LoginPage.nameField);

			LoginPage.userPanel.add(LoginPage.enterPasswordLabel);
			LoginPage.userPanel.add(LoginPage.passwordField);

			LoginPage.userPanel.add(LoginPage.reEnterPasswordLabel);
			LoginPage.userPanel.add(LoginPage.reEnterPasswordField);

			LoginPage.userPanel.add(LoginPage.registerUserButton);
			LoginPage.userPanel.add(LoginPage.clearButton);

			LoginPage.mainPanel.validate();
			LoginPage.mainPanel.repaint();

		}

		if (e.getSource() == aboutButton) {
			LoginPage.mainPanel.remove(LoginPage.userPanel);
			LoginPage.mainPanel.add(LoginPage.aboutPanel);
			LoginPage.mainPanel.revalidate();
			LoginPage.mainPanel.repaint();
		}

	}

}

package com.bank.loginPage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.bank.accountStorage.UserData;

public class MainButtons implements ActionListener {

	JButton loginButton;
	JButton registerButton;
	JButton aboutButton;

	JButton loginAccountButton;
	JButton registerAccountButton;
	JButton clearDetailsButton;

	public MainButtons() {
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

		loginAccountButton = new JButton("Login");
		loginAccountButton.addActionListener(this);
		loginAccountButton.setPreferredSize(new Dimension(160, 40));
		loginAccountButton.setFocusable(false);

		registerAccountButton = new JButton("Register");
		registerAccountButton.addActionListener(this);
		registerAccountButton.setPreferredSize(new Dimension(160, 40));
		registerAccountButton.setFocusable(false);

		clearDetailsButton = new JButton("Clear");
		clearDetailsButton.addActionListener(this);
		clearDetailsButton.setPreferredSize(new Dimension(160, 40));
		clearDetailsButton.setFocusable(false);
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

	public JButton addLoginAccountButton() {
		return loginAccountButton;
	}

	public JButton addRegisterAccountButton() {
		return registerAccountButton;
	}

	public JButton addClearDetailsButton() {
		return clearDetailsButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			MainPanel.mainPanel.add(MainPanel.userPanel);
			MainPanel.userPanel.removeAll();

			LoginPanel loginPanel = new LoginPanel();
			loginPanel.addLoginPanelComponents();
			MainPanel.userPanel.add(loginPanel);

			MainPanel.mainPanel.validate();
			MainPanel.mainPanel.repaint();
		}

		if (e.getSource() == registerButton) {
			MainPanel.mainPanel.add(MainPanel.userPanel);
			MainPanel.userPanel.removeAll();

			RegisterPanel registerPanel = new RegisterPanel();
			registerPanel.addRegisterPanelComponents();
			MainPanel.userPanel.add(registerPanel);

			MainPanel.mainPanel.validate();
			MainPanel.mainPanel.repaint();

		}

		if (e.getSource() == aboutButton) {
			MainPanel.mainPanel.add(MainPanel.userPanel);
			MainPanel.userPanel.removeAll();

			AboutPanel aboutPanel = new AboutPanel();
			aboutPanel.addAboutPanelComponents();
			MainPanel.userPanel.add(aboutPanel);

			MainPanel.mainPanel.revalidate();
			MainPanel.mainPanel.repaint();
		}

		if (e.getSource() == loginAccountButton) {

			String loginMail = LoginPanel.getLoginMail();
			String loginPassword = LoginPanel.getLoginPassword();
			String loginReEnterPassword = LoginPanel.getLoginReEnterPassword();

			// Checking if the email typed in is valid
			if (!UserData.validEmail(loginMail)) {
				JOptionPane.showMessageDialog(null, "Invalid Email", "Invalid Email Message",
						JOptionPane.ERROR_MESSAGE);
			} else if (loginPassword.equals(loginReEnterPassword)) {
				
				UserData loginUserData = new UserData(loginMail,
						loginPassword);
				loginUserData.readUserData();

			} else {
				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == registerAccountButton) {
			if (String.valueOf(RegisterPanel.passwordField.getPassword())
					.equals(String.valueOf(RegisterPanel.reEnterPasswordField.getPassword()))) {

				UserData newUserData = new UserData(RegisterPanel.mailField.getText(),
						RegisterPanel.nameField.getText(), String.valueOf(RegisterPanel.passwordField.getPassword()),
						new BigDecimal(0));
				newUserData.recordUserData();

			} else {
				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == clearDetailsButton) {
			LoginPanel.mailField.setText("");
			LoginPanel.passwordField.setText("");
			LoginPanel.reEnterPasswordField.setText("");

			RegisterPanel.mailField.setText("");
			RegisterPanel.nameField.setText("");
			RegisterPanel.passwordField.setText("");
			RegisterPanel.reEnterPasswordField.setText("");
		}

	}

}

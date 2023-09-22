package com.bank.loginPage;

import java.awt.Dimension;
import java.awt.Font;
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
	
	final BigDecimal DEFAULT_BALANCE = BigDecimal.valueOf(0);

	public MainButtons() {
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		loginButton.setPreferredSize(new Dimension(256, 64));
		loginButton.setFont(new Font(null, Font.BOLD, 16));
		loginButton.setForeground(MainPanel.BLACK);

		registerButton = new JButton("Sign Up");
		registerButton.addActionListener(this);
		registerButton.setFocusable(false);
		registerButton.setPreferredSize(new Dimension(256, 64));
		registerButton.setFont(new Font(null, Font.BOLD, 16));
		registerButton.setForeground(MainPanel.BLACK);
		
		aboutButton = new JButton("About");
		aboutButton.addActionListener(this);
		aboutButton.setFocusable(false);
		aboutButton.setPreferredSize(new Dimension(256, 64));
		aboutButton.setFont(new Font(null, Font.BOLD, 16));
		aboutButton.setForeground(MainPanel.BLACK);

		loginAccountButton = new JButton("Login");
		loginAccountButton.addActionListener(this);
		loginAccountButton.setPreferredSize(new Dimension(160, 40));
		loginAccountButton.setFocusable(false);
		loginAccountButton.setFont(new Font(null, Font.BOLD, 16));
		loginAccountButton.setForeground(MainPanel.BLACK);

		registerAccountButton = new JButton("Register");
		registerAccountButton.addActionListener(this);
		registerAccountButton.setPreferredSize(new Dimension(160, 40));
		registerAccountButton.setFocusable(false);
		registerAccountButton.setFont(new Font(null, Font.BOLD, 16));
		registerAccountButton.setForeground(MainPanel.BLACK);

		clearDetailsButton = new JButton("Clear");
		clearDetailsButton.addActionListener(this);
		clearDetailsButton.setPreferredSize(new Dimension(160, 40));
		clearDetailsButton.setFocusable(false);
		clearDetailsButton.setFont(new Font(null, Font.BOLD, 16));
		clearDetailsButton.setForeground(MainPanel.BLACK);
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public JButton getAboutButton() {
		return aboutButton;
	}

	public JButton getLoginAccountButton() {
		return loginAccountButton;
	}

	public JButton getRegisterAccountButton() {
		return registerAccountButton;
	}

	public JButton getClearDetailsButton() {
		return clearDetailsButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == loginButton) {
			
			MainPanel.addAndClearUserPanel();

			LoginPanel loginPanel = new LoginPanel();
			loginPanel.addLoginPanelComponents();
			MainPanel.userPanel.add(loginPanel);

			MainPanel.repaintAndRevalidate();
			
		}

		if (e.getSource() == registerButton) {
			
			MainPanel.addAndClearUserPanel();
			
			RegisterPanel registerPanel = new RegisterPanel();
			registerPanel.addRegisterPanelComponents();
			MainPanel.userPanel.add(registerPanel);

			MainPanel.repaintAndRevalidate();

		}

		if (e.getSource() == aboutButton) {
			
			MainPanel.addAndClearUserPanel();
			
			AboutPanel aboutPanel = new AboutPanel();
			aboutPanel.addAboutPanelComponents();
			MainPanel.userPanel.add(aboutPanel);

			MainPanel.repaintAndRevalidate();
			
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

				UserData loginUserData = new UserData(loginMail, loginPassword);
				loginUserData.readUserData();

			} else {

				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch",
						JOptionPane.WARNING_MESSAGE);

			}
		}

		if (e.getSource() == registerAccountButton) {

			String registerMail = RegisterPanel.getRegisterMail();
			String registerName = RegisterPanel.getRegisterName();
			String registerPassword = RegisterPanel.getRegisterPassword();
			String registerRePassword = RegisterPanel.getRegisterRePassword();

			if (registerPassword.equals(registerRePassword)) {

				UserData newUserData = new UserData(registerMail, registerName, registerPassword, DEFAULT_BALANCE);
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

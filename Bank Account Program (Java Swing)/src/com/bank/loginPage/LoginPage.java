package com.bank.loginPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.*;

import com.bank.accountStorage.UserData;

public class LoginPage implements ActionListener {

	JFrame loginFrame;
	public static JPanel mainPanel;

	JLabel headerLabel;
	JPanel headerPanel;

	public static SidePanel sideBarPanel;
	public static JPanel userPanel;
	static JPanel aboutPanel;

	JLabel aboutTitleLabel;
	JLabel aboutDescriptionLabel;
	JLabel featuresLabel;

	public static JButton loginButton;
	public static JButton registerButton;
	public static JButton aboutButton;

	static JButton loginUserButton;
	static JButton registerUserButton;
	static JButton clearButton;

	static JLabel enterMailLabel;
	static JLabel enterNameLabel;
	static JLabel enterPasswordLabel;
	static JLabel reEnterPasswordLabel;

	public static JTextField mailField;
	public static JTextField nameField;
	public static JPasswordField passwordField;
	public static JPasswordField reEnterPasswordField;

	public static JPanel loggedInAccountPanel;

	static final Color DARK_GREEN = new Color(20, 89, 80);
	static final Color WHITE = new Color(234, 236, 236);
	static final Color BLACK = new Color(34, 34, 34);

	public LoginPage() {
		loginFrame = new JFrame();
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.setTitle("bAccess | Login Page");

		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1280, 720));
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		headerLabel = new JLabel("bAccess | Online Banking Software Solutions");
		headerLabel.setFont(new Font("Arial", Font.PLAIN, 26));
		headerLabel.setForeground(WHITE);
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		headerPanel = new JPanel();
		headerPanel.setPreferredSize(new Dimension(1280, 128));
		headerPanel.setBackground(DARK_GREEN);
		headerPanel.setLayout(new BorderLayout());

		headerPanel.add(headerLabel, BorderLayout.CENTER);

		mainPanel.add(headerPanel);

		sideBarPanel = new SidePanel();
		sideBarPanel.addMenuSidePanelButtons();

		mainPanel.add(sideBarPanel);

		/* For adding labels and fields that ask for login details */
		userPanel = new JPanel();
		userPanel.setPreferredSize(new Dimension(1024, 768));
		userPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
s

		aboutPanel.add(aboutDescriptionLabel);
		
		// TODO: add a list that contains the programs features
		featuresLabel = new JLabel("<html> "
				+ "<body>"
				+ "<h3>bAccess Features<h3>"
				+ "<ul>"
				+ "<li>Test</li>"
				+ "</ul>"
				+ "</body>"
				+ " <html>");
		aboutPanel.add(featuresLabel);

		mainPanel.add(aboutPanel);

		loginFrame.getContentPane().add(mainPanel);
		loginFrame.pack();
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setVisible(true);

		/*
		 * For the fields and buttons in the userPanel, the panel where the user could
		 * login and register
		 */
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

		registerUserButton = new JButton("Register");
		registerUserButton.addActionListener(this);
		registerUserButton.setPreferredSize(new Dimension(160, 40));
		registerUserButton.setFocusable(false);

		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		clearButton.setPreferredSize(new Dimension(160, 40));
		clearButton.setFocusable(false);

		loginUserButton = new JButton("Login");
		loginUserButton.addActionListener(this);
		loginUserButton.setPreferredSize(new Dimension(160, 40));
		loginUserButton.setFocusable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clearButton) {
			LoginPage.mailField.setText("");
			LoginPage.nameField.setText("");
			LoginPage.passwordField.setText("");
			LoginPage.reEnterPasswordField.setText("");
		}

		if (e.getSource() == loginUserButton) {
			if (String.valueOf(LoginPage.passwordField.getPassword())
					.equals(String.valueOf(LoginPage.reEnterPasswordField.getPassword()))) {

				UserData loginUserData = new UserData(LoginPage.mailField.getText(),
						String.valueOf(LoginPage.passwordField.getPassword()));
				loginUserData.readUserData();

			} else {
				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		if (e.getSource() == registerUserButton) {
			if (String.valueOf(LoginPage.passwordField.getPassword())
					.equals(String.valueOf(LoginPage.reEnterPasswordField.getPassword()))) {

				UserData newUserData = new UserData(LoginPage.mailField.getText(), LoginPage.nameField.getText(),
						String.valueOf(LoginPage.passwordField.getPassword()), new BigDecimal(0));
				newUserData.recordUserData();

			} else {
				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch",
						JOptionPane.WARNING_MESSAGE);
			}
		}

//		if (e.getSource() == loginButton) {
//
//			System.out.println("Login button pressed");
//
//			userPanel.removeAll();
//
//			userPanel.add(enterMailLabel);
//			userPanel.add(mailField);
//
//			userPanel.add(enterPasswordLabel);
//			userPanel.add(passwordField);
//
//			userPanel.add(reEnterPasswordLabel);
//			userPanel.add(reEnterPasswordField);
//
//			userPanel.add(loginUserButton);
//			userPanel.add(clearButton);
//
//			userPanel.validate();
//			userPanel.repaint();
//		}
//
//		if (e.getSource() == registerButton) {
//
//			System.out.println("Sign up button pressed");
//
//			userPanel.removeAll();
//
//			userPanel.add(enterMailLabel);
//			userPanel.add(mailField);
//
//			userPanel.add(enterNameLabel);
//			userPanel.add(nameField);
//
//			userPanel.add(enterPasswordLabel);
//			userPanel.add(passwordField);
//
//			userPanel.add(reEnterPasswordLabel);
//			userPanel.add(reEnterPasswordField);
//
//			userPanel.add(registerUserButton);
//			userPanel.add(clearButton);
//
//			userPanel.validate();
//			userPanel.repaint();
//
//		}
//
//		if (e.getSource() == clearButton) {
//			mailField.setText("");
//			nameField.setText("");
//			passwordField.setText("");
//			reEnterPasswordField.setText("");
//		}
//
//		if (e.getSource() == aboutButton) {
//			System.out.println("About button pressed");
//		}
//
//		if (e.getSource() == loginUserButton) {
//			if (String.valueOf(passwordField.getPassword())
//					.equals(String.valueOf(reEnterPasswordField.getPassword()))) {
//
//				UserData loginUserData = new UserData(mailField.getText(), String.valueOf(passwordField.getPassword()));
//				loginUserData.readUserData();
//
//			} else {
//				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch",
//						JOptionPane.WARNING_MESSAGE);
//			}
//
//		}
//
//		if (e.getSource() == registerUserButton) {
//			if (String.valueOf(passwordField.getPassword())
//					.equals(String.valueOf(reEnterPasswordField.getPassword()))) {
//
//				UserData newUserData = new UserData(mailField.getText(), nameField.getText(),
//						String.valueOf(passwordField.getPassword()), new BigDecimal(0));
//				newUserData.recordUserData();
//
//			} else {
//				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch",
//						JOptionPane.WARNING_MESSAGE);
//			}
//		}

	}

}

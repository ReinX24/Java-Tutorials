package com.bank.loginPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sql.rowset.CachedRowSet;
import javax.swing.*;

import com.bank.accountStorage.UserData;
import com.bank.userPage.AccountPanel;

public class LoginPage implements ActionListener {

	JFrame loginFrame;
	public static JPanel mainPanel;

	JLabel headerLabel;
	JPanel headerPanel;

	JPanel sideBarPanel;
	public static JPanel userPanel;
	JPanel aboutPanel;

	JButton loginButton;
	JButton registerButton;
	JButton aboutButton;

	JButton loginUserButton;
	JButton registerUserButton;
	JButton clearButton;

	JLabel enterMailLabel;
	JLabel enterNameLabel;
	JLabel enterPasswordLabel;
	JLabel reEnterPasswordLabel;

	JTextField mailField;
	JTextField nameField;
	JPasswordField passwordField;
	JPasswordField reEnterPasswordField;

	final Color HEADER_BACKGROUND_COLOR = new Color(20, 89, 80);
	final Color HEADER_FONT_COLOR = new Color(234, 236, 236);

	public LoginPage() {
		loginFrame = new JFrame();
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.setTitle("bAccess | Login Page");

		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1280, 720));
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		headerLabel = new JLabel("bAccess | Online Banking Software Solutions");
		headerLabel.setFont(new Font("Monospace", Font.PLAIN, 26));
		headerLabel.setForeground(HEADER_FONT_COLOR);
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		headerPanel = new JPanel();
		headerPanel.setPreferredSize(new Dimension(1280, 128));
		headerPanel.setBackground(HEADER_BACKGROUND_COLOR);
		headerPanel.setLayout(new BorderLayout());

		headerPanel.add(headerLabel, BorderLayout.CENTER);

		mainPanel.add(headerPanel);

		sideBarPanel = new JPanel();
		sideBarPanel.setPreferredSize(new Dimension(256, 768));
		sideBarPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		sideBarPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

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

		sideBarPanel.add(loginButton);
		sideBarPanel.add(registerButton);
		sideBarPanel.add(aboutButton);

		mainPanel.add(sideBarPanel);

		userPanel = new JPanel();
		userPanel.setPreferredSize(new Dimension(768, 768));
		userPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		userPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

		mainPanel.add(userPanel);

		loginFrame.getContentPane().add(mainPanel);
		loginFrame.pack();
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setVisible(true);

		/*
		 * For the fields and buttons in the userPanel, the panel where the user could
		 * login and register
		 */
		enterMailLabel = new JLabel("Email:");
		enterMailLabel.setPreferredSize(new Dimension(128, 32));

		enterNameLabel = new JLabel("Name:");
		enterNameLabel.setPreferredSize(new Dimension(128, 32));

		enterPasswordLabel = new JLabel("Password:");
		enterPasswordLabel.setPreferredSize(new Dimension(128, 32));

		reEnterPasswordLabel = new JLabel("Re-enter Password:");
		reEnterPasswordLabel.setPreferredSize(new Dimension(128, 32));

		mailField = new JTextField();
		mailField.setPreferredSize(new Dimension(512, 32));

		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(512, 32));

		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(512, 32));

		reEnterPasswordField = new JPasswordField();
		reEnterPasswordField.setPreferredSize(new Dimension(512, 32));

		registerUserButton = new JButton("Register");
		registerUserButton.addActionListener(this);
		registerUserButton.setPreferredSize(new Dimension(128, 32));
		registerUserButton.setFocusable(false);

		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		clearButton.setPreferredSize(new Dimension(128, 32));
		clearButton.setFocusable(false);

		loginUserButton = new JButton("Login");
		loginUserButton.addActionListener(this);
		loginUserButton.setPreferredSize(new Dimension(128, 32));
		loginUserButton.setFocusable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginButton) {

			System.out.println("Login button pressed");

			userPanel.removeAll();

			userPanel.add(enterMailLabel);
			userPanel.add(mailField);

			userPanel.add(enterPasswordLabel);
			userPanel.add(passwordField);

			userPanel.add(reEnterPasswordLabel);
			userPanel.add(reEnterPasswordField);

			userPanel.add(loginUserButton);
			userPanel.add(clearButton);

			userPanel.validate();
			userPanel.repaint();
		}

		if (e.getSource() == registerButton) {

			System.out.println("Sign up button pressed");

			userPanel.removeAll();

			userPanel.add(enterMailLabel);
			userPanel.add(mailField);

			userPanel.add(enterNameLabel);
			userPanel.add(nameField);

			userPanel.add(enterPasswordLabel);
			userPanel.add(passwordField);

			userPanel.add(reEnterPasswordLabel);
			userPanel.add(reEnterPasswordField);

			userPanel.add(registerUserButton);
			userPanel.add(clearButton);

			userPanel.validate();
			userPanel.repaint();

		}

		if (e.getSource() == clearButton) {
			mailField.setText("");
			nameField.setText("");
			passwordField.setText("");
			reEnterPasswordField.setText("");
		}

		if (e.getSource() == aboutButton) {
			System.out.println("About button pressed");
		}

		if (e.getSource() == loginUserButton) {
			if (String.valueOf(passwordField.getPassword())
					.equals(String.valueOf(reEnterPasswordField.getPassword()))) {
				UserData.readUserData(mailField.getText(), String.valueOf(passwordField.getPassword()));
			} else {
				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		if (e.getSource() == registerUserButton) {
			if (String.valueOf(passwordField.getPassword())
					.equals(String.valueOf(reEnterPasswordField.getPassword()))) {
				UserData.recordUserData(mailField.getText(), nameField.getText(),
						String.valueOf(passwordField.getPassword()));
			} else {
				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password Mismatch",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}

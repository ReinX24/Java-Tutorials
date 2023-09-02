package com.bank.loginPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPage implements ActionListener {

	JFrame loginFrame;
	JPanel loginPanel;

	JLabel headerLabel;
	JPanel headerPanel;

	JPanel sideBarPanel;
	JPanel mainPanel;
	JPanel aboutPanel;

	JLabel enterNameLabel;
	JLabel enterPasswordLabel;
	JTextField nameField;
	JPasswordField passwordField;

	final Color HEADER_BACKGROUND_COLOR = new Color(20, 89, 80);
	final Color HEADER_FONT_COLOR = new Color(234, 236, 236);

	public LoginPage() {
		loginFrame = new JFrame();
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.setTitle("bAccess | Login Page");

		loginPanel = new JPanel();
		loginPanel.setPreferredSize(new Dimension(1280, 720));
		loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		headerLabel = new JLabel("bAccess | Online Banking Software Solutions");
		headerLabel.setFont(new Font("Monospace", Font.PLAIN, 26));
		headerLabel.setForeground(HEADER_FONT_COLOR);
		
		headerPanel = new JPanel();
		headerPanel.setPreferredSize(new Dimension(1280, 128));
		headerPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		headerPanel.setBackground(HEADER_BACKGROUND_COLOR);
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		headerPanel.add(headerLabel);

		loginPanel.add(headerPanel);

		sideBarPanel = new JPanel();
		sideBarPanel.setPreferredSize(new Dimension(256, 768));
		sideBarPanel.setBorder(BorderFactory.createLineBorder(Color.RED));

		loginPanel.add(sideBarPanel);

		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1024, 768));
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));

		loginPanel.add(mainPanel);

		loginFrame.getContentPane().add(loginPanel);
		loginFrame.pack();
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}

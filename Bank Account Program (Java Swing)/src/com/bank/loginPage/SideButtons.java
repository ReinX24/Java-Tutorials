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

	}

}

package com.bank.loginPage;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class LoginPanel extends JPanel {

	public LoginPanel() {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
	}
	
	public void addLoginPanelComponents() {
		this.add(MainPanel.enterMailLabel);
		this.add(MainPanel.mailField);

		this.add(MainPanel.enterPasswordLabel);
		this.add(MainPanel.passwordField);

		this.add(MainPanel.reEnterPasswordLabel);
		this.add(MainPanel.reEnterPasswordField);

		this.add(MainPanel.loginUserButton);
		this.add(MainPanel.clearButton);
	}

}

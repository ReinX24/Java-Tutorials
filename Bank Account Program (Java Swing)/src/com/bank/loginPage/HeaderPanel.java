package com.bank.loginPage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel {

	JLabel headerLabel;

	public HeaderPanel() {
		this.setPreferredSize(new Dimension(1280, 128));
		this.setBackground(LoginPage.DARK_GREEN);
		this.setLayout(new BorderLayout());

	}

	public void addHeaderLabel() {
		headerLabel = new JLabel("bAccess | Online Banking Software Solutions");
		headerLabel.setFont(new Font(null, Font.PLAIN, 32));
		headerLabel.setForeground(LoginPage.WHITE);
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(headerLabel, BorderLayout.CENTER);
	}

}

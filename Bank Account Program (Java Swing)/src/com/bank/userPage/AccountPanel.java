package com.bank.userPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AccountPanel extends JPanel {

	public AccountPanel() {
		this.setPreferredSize(new Dimension(768, 768));
		this.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.setBackground(Color.GREEN);
	}
	
}

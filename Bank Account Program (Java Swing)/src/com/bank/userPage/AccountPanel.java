package com.bank.userPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bank.accountStorage.UserData;

public class AccountPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	UserData currentUser;

	JLabel userNameLabel;
	JLabel balanceLabel;

	public AccountPanel(UserData currentUser) {
		this.setPreferredSize(new Dimension(768, 768));
		this.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));

		this.currentUser = currentUser;

		userNameLabel = new JLabel("Welcome " + this.currentUser.getUserName() + "!");
		balanceLabel = new JLabel("Balance: P" + this.currentUser.getUserBalance());

		this.add(userNameLabel);
		this.add(balanceLabel);

	}

}

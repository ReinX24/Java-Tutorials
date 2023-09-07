package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bank.accountStorage.UserData;

public class AccountPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	static UserData currentUser;

	static JLabel userNameLabel;
	static JLabel balanceLabel;

	public AccountPanel(UserData currentUser) {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		AccountPanel.currentUser = currentUser;

		userNameLabel = new JLabel("Welcome " + AccountPanel.currentUser.getUserName() + "!");
		balanceLabel = new JLabel("Balance: P" + AccountPanel.currentUser.getUserBalance());

		this.add(userNameLabel);
		this.add(balanceLabel);

	}

}

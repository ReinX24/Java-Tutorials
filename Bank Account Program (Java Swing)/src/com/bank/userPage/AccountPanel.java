package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bank.accountStorage.UserData;

public class AccountPanel extends JPanel {

	public AccountPanel(UserData currentUser) {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		AccountInfoPanel loggedInAccountInfo = new AccountInfoPanel();
		loggedInAccountInfo.setAccountInfo(currentUser);		
	}

}

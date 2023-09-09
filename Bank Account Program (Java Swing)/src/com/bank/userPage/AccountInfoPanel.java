package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bank.accountStorage.UserData;

public class AccountInfoPanel extends JPanel {

	static String userMail;
	static String userName;
	static String userPassword;
	static BigDecimal userBalance;

	JLabel userMailLabel;
	JLabel userNameLabel;
	JLabel userBalanceLabel;

	public AccountInfoPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.setPreferredSize(new Dimension(1024, 768));
	}

	public void setAccountInfo(UserData userInfo) {
		userMail = userInfo.getUserMail();
		userName = userInfo.getUserName();
		userPassword = userInfo.getUserPassword();
		userBalance = userInfo.getUserBalance();
	}

	public void addAccountInfoPanelComponents() {
		userMailLabel = new JLabel("Email: " + getUserMail());

		this.add(userMailLabel);

		userNameLabel = new JLabel("Name: " + getUserName());

		this.add(userNameLabel);

		userBalanceLabel = new JLabel("Balance: " + getUserBalance());

		this.add(userBalanceLabel);

	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		AccountInfoPanel.userMail = userMail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		AccountInfoPanel.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		AccountInfoPanel.userPassword = userPassword;
	}

	public BigDecimal getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(BigDecimal userBalance) {
		AccountInfoPanel.userBalance = userBalance;
	}

}

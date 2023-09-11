package com.bank.userPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bank.accountStorage.UserData;
import com.bank.loginPage.MainPanel;

public class AccountInfoPanel extends JPanel {

	static String userMail;
	static String userName;
	static String userPassword;
	static BigDecimal userBalance;

	JLabel userMailLabel;
	JLabel userNameLabel;
	JLabel userBalanceLabel;

	static NumberFormat numberFormat;
	
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
		userMailLabel.setPreferredSize(new Dimension(1024, 64));
		userMailLabel.setBorder(BorderFactory.createLineBorder(Color.RED));

		this.add(userMailLabel);

		userNameLabel = new JLabel("Name: " + getUserName());
		userNameLabel.setPreferredSize(new Dimension(1024, 64));
		userNameLabel.setBorder(BorderFactory.createLineBorder(Color.RED));

		this.add(userNameLabel);

		numberFormat = NumberFormat.getInstance();
		userBalanceLabel = new JLabel("Balance: " + numberFormat.format(getUserBalance()));
		userBalanceLabel.setPreferredSize(new Dimension(1024, 64));
		userBalanceLabel.setBorder(BorderFactory.createLineBorder(Color.RED));

		this.add(userBalanceLabel);

	}

	public static String getUserMail() {
		return userMail;
	}

	public static void setUserMail(String userMail) {
		AccountInfoPanel.userMail = userMail;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		AccountInfoPanel.userName = userName;
	}

	public static String getUserPassword() {
		return userPassword;
	}

	public static void setUserPassword(String userPassword) {
		AccountInfoPanel.userPassword = userPassword;
	}

	public static BigDecimal getUserBalance() {
		return userBalance;
	}

	public static void setUserBalance(BigDecimal userBalance) {
		AccountInfoPanel.userBalance = userBalance;
	}

}

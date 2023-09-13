package com.bank.userPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

	JLabel greetUserLabel;
	JLabel userMailLabel;
	JLabel userNameLabel;
	JLabel userBalanceLabel;

	static NumberFormat numberFormat;

	public AccountInfoPanel() {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 16, 16));
	}

	public void setAccountInfo(UserData userInfo) {
		userMail = userInfo.getUserMail();
		userName = userInfo.getUserName();
		userPassword = userInfo.getUserPassword();
		userBalance = userInfo.getUserBalance();
	}

	public void addAccountInfoPanelComponents() {

		// TODO: greet the user with a good morning, good afternoon, or good evening,
		// depending on the system's time
		greetUserLabel = new JLabel("Hello " + getUserName() + "!");
		greetUserLabel.setPreferredSize(new Dimension(1024, 96));
		greetUserLabel.setFont(new Font(null, Font.BOLD, 32));

		this.add(greetUserLabel);

		userMailLabel = new JLabel("Email: " + getUserMail());
		userMailLabel.setPreferredSize(new Dimension(1024, 32));
		userMailLabel.setFont(new Font(null, Font.PLAIN, 18));

		this.add(userMailLabel);

		userNameLabel = new JLabel("Name: " + getUserName());
		userNameLabel.setPreferredSize(new Dimension(1024, 32));
		userNameLabel.setFont(new Font(null, Font.PLAIN, 18));

		this.add(userNameLabel);

		numberFormat = NumberFormat.getInstance();
		userBalanceLabel = new JLabel("Balance: " + numberFormat.format(getUserBalance()));
		userBalanceLabel.setPreferredSize(new Dimension(1024, 32));
		userBalanceLabel.setFont(new Font(null, Font.PLAIN, 18));

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

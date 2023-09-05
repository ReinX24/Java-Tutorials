package com.bank.userPage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bank.loginPage.LoginPage;

import javax.swing.JButton;

public class AccountButtons implements ActionListener {

	JButton depositButton;
	JButton withdrawButton;
	JButton sendFundsButton;
	JButton logoutButton;

	public AccountButtons() {
		depositButton = new JButton("Deposit Funds");
		depositButton.addActionListener(this);
		depositButton.setFocusable(false);
		depositButton.setPreferredSize(new Dimension(256, 64));

		withdrawButton = new JButton("Withdraw Funds");
		withdrawButton.addActionListener(this);
		withdrawButton.setFocusable(false);
		withdrawButton.setPreferredSize(new Dimension(256, 64));

		sendFundsButton = new JButton("Send Funds");
		sendFundsButton.addActionListener(this);
		sendFundsButton.setFocusable(false);
		sendFundsButton.setPreferredSize(new Dimension(256, 64));

		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(this);
		logoutButton.setFocusable(false);
		logoutButton.setPreferredSize(new Dimension(256, 64));
	}

	public JButton addDepositButton() {
		return depositButton;
	}

	public JButton addWithdrawButton() {
		return withdrawButton;
	}

	public JButton addSendFundsButton() {
		return sendFundsButton;
	}

	public JButton addLogoutButton() {
		return logoutButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == depositButton) {
			System.out.println("Deposit button clicked!");
		}
		if (e.getSource() == withdrawButton) {
			System.out.println("Withdraw button clicked!");
		}
		if (e.getSource() == sendFundsButton) {
			System.out.println("Send funds button clicked!");
		}
		if (e.getSource() == logoutButton) {
			System.out.println("Logout button clicked");
			
			LoginPage.mainPanel.remove(LoginPage.loggedInAccountPanel);
			LoginPage.mainPanel.add(LoginPage.userPanel);
						
			LoginPage.sideBarPanel.removeAll();
			LoginPage.sideBarPanel.addMenuSidePanelButtons();
			
			LoginPage.mainPanel.repaint();
			LoginPage.mainPanel.revalidate();
		}

	}

}

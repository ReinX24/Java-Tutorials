package com.bank.userPage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import com.bank.loginPage.MainPanel;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AccountButtons implements ActionListener {

	JButton depositButton;
	JButton withdrawButton;
	JButton sendFundsButton;
	JButton logoutButton;

	JButton confirmDespositButton;
	JButton confirmWithdrawButton;

	public AccountButtons() {
		/* New side buttons that will lead to deposit, withdraw, or send funds panels */
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

		/* Buttons that the user clicks to deposit, withdraw, or send funds */
		confirmDespositButton = new JButton("Confirm Deposit");
		confirmDespositButton.setPreferredSize(new Dimension(180, 40));

		confirmWithdrawButton = new JButton("Confirm Withdraw");
		confirmWithdrawButton.setPreferredSize(new Dimension(180, 40));
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

	public JButton addConfirmDepositButton() {
		return confirmDespositButton;
	}

	public JButton addConfirmWithdrawButton() {
		return confirmWithdrawButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO: add checks for if the user enters a String instead of a number valid
		// for BigInteger
		if (e.getSource() == depositButton) {

			MainPanel.loggedInAccountPanel.removeAll();

			DepositPanel depositPanel = new DepositPanel();
			depositPanel.addDepositLabelComponents();
			MainPanel.loggedInAccountPanel.add(depositPanel);

			MainPanel.loggedInAccountPanel.revalidate();
			MainPanel.loggedInAccountPanel.repaint();

//			System.out.println("Deposit button clicked!");
//			BigDecimal depositAmount = new BigDecimal(JOptionPane.showInputDialog(null, "Enter funds to be deposited",
//					"Deposit Funds", JOptionPane.INFORMATION_MESSAGE));
//			AccountPanel.currentUser.setUserBalance(AccountPanel.currentUser.getUserBalance().add(depositAmount));
//			AccountPanel.balanceLabel.setText("Balance: P" + AccountPanel.currentUser.getUserBalance());
		}
		if (e.getSource() == withdrawButton) {
			
			MainPanel.loggedInAccountPanel.removeAll();
			
			WithdrawPanel withdrawPanel = new WithdrawPanel();
			withdrawPanel.addWithdrawPanelComponents();
			MainPanel.loggedInAccountPanel.add(withdrawPanel);
			
			MainPanel.loggedInAccountPanel.revalidate();
			MainPanel.loggedInAccountPanel.repaint();
			
//			System.out.println("Withdraw button clicked!");
//			BigDecimal withdrawAmount = new BigDecimal(JOptionPane.showInputDialog(null, "Enter funds to be withdrawn",
//					"Deposit Funds", JOptionPane.INFORMATION_MESSAGE));
//			// Checks if the currentUser's balance is less than the withdrawAmount
//			if (AccountPanel.currentUser.getUserBalance().compareTo(withdrawAmount) < 0) {
//				JOptionPane.showMessageDialog(null, "Not enough funds!", "Insufficient Funds",
//						JOptionPane.WARNING_MESSAGE);
//			} else {
//				int confirmWithdraw = JOptionPane.showConfirmDialog(null, "Withdraw P" + withdrawAmount + "?");
//				if (confirmWithdraw == JOptionPane.YES_OPTION) {
//					AccountPanel.currentUser
//							.setUserBalance(AccountPanel.currentUser.getUserBalance().subtract(withdrawAmount));
//					AccountPanel.balanceLabel.setText("Balance: P" + AccountPanel.currentUser.getUserBalance());
//				}
//			}
		}
		if (e.getSource() == sendFundsButton) {
			System.out.println("Send funds button clicked!");
		}
		if (e.getSource() == logoutButton) {
			// TODO: when the user is logging out, update their information in their
			// respective text file
			System.out.println("Logout button clicked");

			MainPanel.mainPanel.remove(MainPanel.loggedInAccountPanel);
			MainPanel.mainPanel.add(MainPanel.userPanel);

			MainPanel.sideBarPanel.removeAll();
			MainPanel.sideBarPanel.addMenuSidePanelButtons();

			MainPanel.mainPanel.repaint();
			MainPanel.mainPanel.revalidate();
		}

	}

}

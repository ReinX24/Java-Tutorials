package com.bank.userPage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

import com.bank.accountStorage.UserData;
import com.bank.loginPage.MainPanel;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AccountButtons implements ActionListener {

	JButton accountInfoButton;
	JButton depositButton;
	JButton withdrawButton;
	JButton sendFundsButton;
	JButton logoutButton;

	JButton confirmDespositButton;
	JButton confirmWithdrawButton;
	JButton confirmSendButton;

	public AccountButtons() {
		/* New side buttons that will lead to deposit, withdraw, or send funds panels */
		accountInfoButton = new JButton("Account Information");
		accountInfoButton.addActionListener(this);
		accountInfoButton.setFocusable(false);
		accountInfoButton.setPreferredSize(new Dimension(256, 64));

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

		// TODO: add a button that lets the user reset their password
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(this);
		logoutButton.setFocusable(false);
		logoutButton.setPreferredSize(new Dimension(256, 64));

		/* Buttons that the user clicks to deposit, withdraw, or send funds */
		confirmDespositButton = new JButton("Confirm Deposit");
		confirmDespositButton.addActionListener(this);
		confirmDespositButton.setPreferredSize(new Dimension(180, 40));

		confirmWithdrawButton = new JButton("Confirm Withdraw");
		confirmWithdrawButton.addActionListener(this);
		confirmWithdrawButton.setPreferredSize(new Dimension(180, 40));

		confirmSendButton = new JButton("Confirm Sending Funds");
		confirmSendButton.addActionListener(this);
		confirmSendButton.setPreferredSize(new Dimension(240, 40));
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

	public JButton addConfirmSendFundsButton() {
		return confirmSendButton;
	}

	public JButton addAccountInfoButton() {
		return accountInfoButton;
	}

	public static boolean recipientExists(String recipientMail) {
		// TODO: use a Path object to point to the recipient's text fil;e
		File recipientFile = new File("src/com/bank/accountStorage/" + recipientMail + ".txt");
		return recipientFile.exists();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == accountInfoButton) {

			MainPanel.loggedInAccountPanel.removeAll();

			AccountInfoPanel accountInfoPanel = new AccountInfoPanel();
			accountInfoPanel.addAccountInfoPanelComponents();
			MainPanel.loggedInAccountPanel.add(accountInfoPanel);

			MainPanel.loggedInAccountPanel.revalidate();
			MainPanel.loggedInAccountPanel.repaint();

		}

		if (e.getSource() == depositButton) {

			MainPanel.loggedInAccountPanel.removeAll();

			DepositPanel depositPanel = new DepositPanel();
			depositPanel.addDepositLabelComponents();
			MainPanel.loggedInAccountPanel.add(depositPanel);

			MainPanel.loggedInAccountPanel.revalidate();
			MainPanel.loggedInAccountPanel.repaint();
		}

		if (e.getSource() == withdrawButton) {

			MainPanel.loggedInAccountPanel.removeAll();

			WithdrawPanel withdrawPanel = new WithdrawPanel();
			withdrawPanel.addWithdrawPanelComponents();
			MainPanel.loggedInAccountPanel.add(withdrawPanel);

			MainPanel.loggedInAccountPanel.revalidate();
			MainPanel.loggedInAccountPanel.repaint();

		}

		if (e.getSource() == sendFundsButton) {

			MainPanel.loggedInAccountPanel.removeAll();

			SendFundsPanel sendFundsPanel = new SendFundsPanel();
			sendFundsPanel.addSendFundsPanelComponents();
			MainPanel.loggedInAccountPanel.add(sendFundsPanel);

			MainPanel.loggedInAccountPanel.revalidate();
			MainPanel.loggedInAccountPanel.repaint();

		}

		if (e.getSource() == confirmDespositButton) {
			BigDecimal currentUserBalance = AccountInfoPanel.getUserBalance();
			String userMail = AccountInfoPanel.getUserMail();
			String userName = AccountInfoPanel.getUserName();
			String userPassword = AccountInfoPanel.getUserPassword();
			BigDecimal newBalance = AccountInfoPanel.getUserBalance().add(DepositPanel.getDepositAmount());
			UserData.updateUserBalance(userMail, userName, userPassword, newBalance);
			JOptionPane.showMessageDialog(null, "You have deposited P" + currentUserBalance, "Deposit Message",
					JOptionPane.INFORMATION_MESSAGE);
		}

		if (e.getSource() == confirmWithdrawButton) {
			BigDecimal currentUserBalance = AccountInfoPanel.getUserBalance();
			BigDecimal withdrawAmount = WithdrawPanel.getWithdrawAmount();
			// if the withdrawAmount is greater than currentUserBalance
			if (withdrawAmount.compareTo(currentUserBalance) == 1) {
				JOptionPane.showMessageDialog(null, "Not Enough Funds To Withdraw!", "Withdraw Amount Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String userMail = AccountInfoPanel.getUserMail();
				String userName = AccountInfoPanel.getUserName();
				String userPassword = AccountInfoPanel.getUserPassword();
				BigDecimal newBalance = currentUserBalance.subtract(withdrawAmount);
				UserData.updateUserBalance(userMail, userName, userPassword, newBalance);
				JOptionPane.showMessageDialog(null, "You have withdrawn P" + withdrawAmount, "Withdraw Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == confirmSendButton) {
			BigDecimal currentUserBalance = AccountInfoPanel.getUserBalance();
			BigDecimal sendAmount = SendFundsPanel.getSendAmount();
			String recipientMail = SendFundsPanel.getRecipientMail();
			// sendAmount is greater than currentUserBalance
			if (sendAmount.compareTo(currentUserBalance) == 1) {
				JOptionPane.showMessageDialog(null, "Not Enough Funds To Send!", "Send Amount Error",
						JOptionPane.ERROR_MESSAGE);
			} else if (recipientExists(recipientMail)) {

				BufferedReader fileReader;
				try {
					fileReader = new BufferedReader(
							new FileReader("src/com/bank/accountStorage/" + recipientMail + ".txt"));
					
					String userDataTemp;
					StringBuilder userData = new StringBuilder();
					
					while ((userDataTemp = fileReader.readLine()) != null) {
						userData.append(userDataTemp);
					}

					String[] userDataArray = new String[4];
					userDataArray = userData.toString().split(",");

					HashMap<String, String> userDataMap = new HashMap<>();
					for (int i = 0; i < userDataArray.length; i++) {
						String[] tempArr = userDataArray[i].split(":");
						userDataMap.put(tempArr[0], tempArr[1]);
					}
					// TODO: update the recipient and the user's data after sending funds
					System.out.println(userDataMap);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
				
//				String userMail = AccountInfoPanel.getUserMail();
//				String userName = AccountInfoPanel.getUserName();
//				String userPassword = AccountInfoPanel.getUserPassword();
//				BigDecimal newBalance = currentUserBalance.subtract(sendAmount);
//				
//				UserData.updateUserBalance(userMail, userName, userPassword, newBalance);
//				JOptionPane.showMessageDialog(null, "You have sent P" + sendAmount, "Withdraw Message",
//						JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "Recipient Not Found!", "Recipient Mail Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == logoutButton) {
			MainPanel.mainPanel.remove(MainPanel.loggedInAccountPanel);
			MainPanel.mainPanel.add(MainPanel.userPanel);

			MainPanel.sideBarPanel.removeAll();
			MainPanel.sideBarPanel.addMenuSidePanelButtons();

			MainPanel.mainPanel.repaint();
			MainPanel.mainPanel.revalidate();
		}

	}

}

package com.bank.accountStorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.bank.loginPage.LoginPage;
import com.bank.userPage.AccountPanel;

public class UserData {

	String userMail;
	String userName;
	String userPassword;
	BigDecimal userBalance;

	public UserData(String userMail, String userName, String userPassword, BigDecimal userBalance) {
		this.userMail = userMail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userBalance = userBalance;
	}

	public UserData(String userMail, String userPassword) {
		this.userMail = userMail;
		this.userPassword = userPassword;
	}

	public void recordUserData() {
		// Regex that checks if the email is a valid email, checks if it has and @
		// between text
		if (Pattern.matches("^(.+)@(.+)$", userMail)) {
			// For creating the text file with the user's email, user name, and password
			File userFile = new File("src/com/bank/accountStorage/" + userMail + ".txt");
			try {
				if (userFile.createNewFile()) {
					FileWriter userWriter = new FileWriter(userFile);
					userWriter.write("email:" + this.userMail + ",\n");
					userWriter.write("username:" + this.userName + ",\n");
					userWriter.write("password:" + this.userPassword + ",\n");
					userWriter.write("balance:" + this.userBalance);
					userWriter.close();
					JOptionPane.showMessageDialog(null, this.userMail + " account created!", "Account Created",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Account already exists!", "Account Exists",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Not a valid email!", "Invalid email", JOptionPane.WARNING_MESSAGE);
		}

	}

	public void readUserData() {
		// For finding a text file and reading its data
		try {

			BufferedReader fileReader = new BufferedReader(
					new FileReader("src/com/bank/accountStorage/" + userMail + ".txt"));
			String userDataTemp;
			StringBuilder userData = new StringBuilder();
			while ((userDataTemp = fileReader.readLine()) != null) {
				userData.append(userDataTemp);
			}

			// Storing the user's email, user name password, and funds in a hash map
			String[] userDataArray = new String[4];
			userDataArray = userData.toString().split(",");

			HashMap<String, String> userDataMap = new HashMap<>();
			for (int i = 0; i < userDataArray.length; i++) {
				String[] tempArr = userDataArray[i].split(":");
				userDataMap.put(tempArr[0], tempArr[1]);
			}

			this.userName = userDataMap.get("username");
			this.userBalance = new BigDecimal(userDataMap.get("balance"));

			// Checking if the user's email is the same with the aligned password
			if (userPassword.equals(userDataMap.get("password"))) {
				JOptionPane.showMessageDialog(null, "Login Successful!", "Login Successful",
						JOptionPane.INFORMATION_MESSAGE);

				/*
				 * Removing entered data in fields and replacing side buttons and mainPanel with
				 * UI for logged in users
				 */
				LoginPage.mailField.setText("");
				LoginPage.nameField.setText("");
				LoginPage.passwordField.setText("");
				LoginPage.reEnterPasswordField.setText("");

				// DONE: When we add userAccountPanel, we will be adding the user's information
				LoginPage.loggedInAccountPanel = new AccountPanel(this);

				LoginPage.mainPanel.remove(LoginPage.userPanel);
				LoginPage.mainPanel.add(LoginPage.loggedInAccountPanel);

				LoginPage.sideBarPanel.removeAll();
				LoginPage.sideBarPanel.addLoggedInSidePanelButtons();

				LoginPage.mainPanel.validate();
				LoginPage.mainPanel.repaint();

				fileReader.close();

			} else {
				JOptionPane.showMessageDialog(null, "Wrong Password!", "Incorrect Password",
						JOptionPane.WARNING_MESSAGE);
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Account not found!", "No Account Fount", JOptionPane.WARNING_MESSAGE);
		}
	}

	// TODO: create a custom method that reads a file and updates the balance field
	// within that file

	/* Helper methods for our program */

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public BigDecimal getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(BigDecimal userBalance) {
		this.userBalance = userBalance;
	}

	@Override
	public String toString() {
		return "UserData [userMail=" + userMail + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userBalance=" + userBalance + "]";
	}

}

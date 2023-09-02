package com.bank.accountStorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class UserData {

	public static void recordUserData(String userMail, String userName, String userPassword) {
		// For creating the text file with the user's email, user name, and password
		File userFile = new File("src/com/bank/accountStorage/" + userMail + ".txt");
		try {
			if (userFile.createNewFile()) {
				FileWriter userWriter = new FileWriter(userFile);
				// TODO: write a regex that checks if this is a valid email
				userWriter.write("email:" + userMail + ",\n");
				userWriter.write("username:" + userName + ",\n");
				userWriter.write("password:" + userPassword);
				userWriter.close();
				JOptionPane.showMessageDialog(null, userMail + " account created!", "Account Created",
						JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "Account already exists!", "Account Exists",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void readUserData(String userMail, String userPassword) {
		// For finding a text file and reading its data
		try {

			BufferedReader fileReader = new BufferedReader(
					new FileReader("src/com/bank/accountStorage/" + userMail + ".txt"));
			String userDataTemp;
			StringBuilder userData = new StringBuilder();
			while ((userDataTemp = fileReader.readLine()) != null) {
				userData.append(userDataTemp);
			}

			// Storing the user's email, user name, and password in a hash map
			String[] userDataArray = new String[3];
			userDataArray = userData.toString().split(",");

			HashMap<String, String> userDataMap = new HashMap<>();
			for (int i = 0; i < userDataArray.length; i++) {
				String[] tempArr = userDataArray[i].split(":");
				userDataMap.put(tempArr[0], tempArr[1]);
			}

			// Checking if the user's email is the same with the aligned password
			if (userPassword.equals(userDataMap.get("password"))) {
				JOptionPane.showMessageDialog(null, "Valid Password!", "Login Successful",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Wrong Password!", "Incorrect Password",
						JOptionPane.WARNING_MESSAGE);
			}

			fileReader.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Account not found!", "No Account Fount", JOptionPane.WARNING_MESSAGE);
		}
	}

}
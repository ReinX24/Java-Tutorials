package com.bank.userPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepositPanel extends JPanel {
	
	JLabel depositFundsLabel;
	JTextField depositFundsField;
	
	public DepositPanel() {
		
		this.setPreferredSize(new Dimension(1024, 768));
	
	};
	
	public DepositPanel initializePanel() {
		
		depositFundsLabel = new JLabel("Deposit Funds:");
		
		this.add(depositFundsLabel);
		
		depositFundsField = new JTextField();
		depositFundsField.setPreferredSize(new Dimension(640, 40));
		
		this.add(depositFundsField);
		
		AccountButtons accountButtons = new AccountButtons();
		this.add(accountButtons.addConfirmDepositButton());
		return this;
	}

}

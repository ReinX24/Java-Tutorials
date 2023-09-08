package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepositPanel extends JPanel {

	JLabel depositFundsLabel;
	JTextField depositFundsField;

	public DepositPanel() {
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.setPreferredSize(new Dimension(1024, 768));
	
	};

	public void initializePanel() {

		depositFundsLabel = new JLabel("Deposit Funds:");
		depositFundsLabel.setPreferredSize(new Dimension(192, 32));
		
		this.add(depositFundsLabel);

		depositFundsField = new JTextField();
		depositFundsField.setPreferredSize(new Dimension(640, 40));

		this.add(depositFundsField);

		AccountButtons accountButtons = new AccountButtons();
		this.add(accountButtons.addConfirmDepositButton());

	}

}

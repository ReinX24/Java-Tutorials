package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WithdrawPanel extends JPanel {

	JLabel withdrawFundsLabel;
	static JTextField withdrawFundsField;

	public WithdrawPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.setPreferredSize(new Dimension(1024, 768));
	}

	public void addWithdrawPanelComponents() {
		withdrawFundsLabel = new JLabel("Withdraw Funds:");
		withdrawFundsLabel.setPreferredSize(new Dimension(192, 32));

		this.add(withdrawFundsLabel);

		withdrawFundsField = new JTextField();
		withdrawFundsField.setPreferredSize(new Dimension(640, 40));

		this.add(withdrawFundsField);

		AccountButtons accountButtons = new AccountButtons();
		this.add(accountButtons.addConfirmWithdrawButton());
	}

	public static BigDecimal getWithdrawAmount() {
		// TODO: check if the user enters a number and not a string when withdrawing
		return BigDecimal.valueOf(Long.parseLong(withdrawFundsField.getText().toString()));
	}

}

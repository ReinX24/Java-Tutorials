package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendFundsPanel extends JPanel {

	JLabel recipientMailLabel;
	static JTextField recipientNameField;

	JLabel sendFundsAmount;
	static JTextField sendFundsField;

	public SendFundsPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.setPreferredSize(new Dimension(1024, 768));
	}

	public void addSendFundsPanelComponents() {
		recipientMailLabel = new JLabel("Enter Recipient Email:");
		recipientMailLabel.setPreferredSize(new Dimension(192, 32));

		this.add(recipientMailLabel);

		recipientNameField = new JTextField();
		recipientNameField.setPreferredSize(new Dimension(640, 40));

		this.add(recipientNameField);

		sendFundsAmount = new JLabel("Enter Funds Amount:");
		sendFundsAmount.setPreferredSize(new Dimension(192, 32));

		this.add(sendFundsAmount);

		sendFundsField = new JTextField();
		sendFundsField.setPreferredSize(new Dimension(640, 40));

		this.add(sendFundsField);

		AccountButtons accountButtons = new AccountButtons();
		this.add(accountButtons.addConfirmSendFundsButton());
	}

	public static BigDecimal getSendAmount() {
		return BigDecimal.valueOf(Long.parseLong(sendFundsField.getText().toString()));
	}

	public static String getRecipientMail() {
		return recipientNameField.getText();
	}

}

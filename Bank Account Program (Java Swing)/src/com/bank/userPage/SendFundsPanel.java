package com.bank.userPage;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendFundsPanel extends JPanel {

	JLabel recipientNameLabel;
	JTextField recipientNameField;

	JLabel sendFundsAmount;
	JTextField sendFunndsField;

	public SendFundsPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.setPreferredSize(new Dimension(1024, 768));
	}

	public void addSendFundsPanelComponents() {
		recipientNameLabel = new JLabel("Enter Recipient Name:");
		recipientNameLabel.setPreferredSize(new Dimension(192, 32));

		this.add(recipientNameLabel);

		recipientNameField = new JTextField();
		recipientNameField.setPreferredSize(new Dimension(640, 40));

		this.add(recipientNameField);

		AccountButtons accountButtons = new AccountButtons();
		this.add(accountButtons.addConfirmSendFundsButton());
	}

}

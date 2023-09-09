package com.bank.loginPage;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.bank.userPage.AccountButtons;
import com.bank.userPage.AccountInfoPanel;

public class SidePanel extends JPanel {

	public SidePanel() {
		this.setPreferredSize(new Dimension(256, 768));
		this.setBorder(BorderFactory.createLineBorder(MainPanel.DARK_GREEN));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	}

	public void addMenuSidePanelButtons() {
		MainButtons sidePanelButtons = new MainButtons();
		this.add(sidePanelButtons.addLoginButton());
		this.add(sidePanelButtons.addRegisterButton());
		this.add(sidePanelButtons.addAboutButton());
	}

	public void addLoggedInSidePanelButtons() {
		AccountButtons loggedInSidePanelButtons = new AccountButtons();
		this.add(loggedInSidePanelButtons.addAccountInfoButton());
		this.add(loggedInSidePanelButtons.addDepositButton());
		this.add(loggedInSidePanelButtons.addWithdrawButton());
		this.add(loggedInSidePanelButtons.addSendFundsButton());
		this.add(loggedInSidePanelButtons.addLogoutButton());
	}

}

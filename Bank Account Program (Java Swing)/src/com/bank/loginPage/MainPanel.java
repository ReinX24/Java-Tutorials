package com.bank.loginPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.*;

import com.bank.accountStorage.UserData;
import com.bank.userPage.AccountPanel;

public class MainPanel {

	JFrame loginFrame;
	public static JPanel mainPanel;

	HeaderPanel headerPanel;
	public static SidePanel sideBarPanel;
	public static JPanel userPanel;

	public static AccountPanel loggedInAccountPanel;

	static final Color DARK_GREEN = new Color(20, 89, 80);
	static final Color WHITE = new Color(234, 236, 236);
	static final Color BLACK = new Color(34, 34, 34);

	public MainPanel() {

		loginFrame = new JFrame();
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.setTitle("bAccess | Login Page");

		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1280, 720));
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		/* Header of program */
		headerPanel = new HeaderPanel();
		headerPanel.addHeaderLabelComponents();
		mainPanel.add(headerPanel);

		/* Side bar that contains buttons with different functions */
		sideBarPanel = new SidePanel();
		sideBarPanel.addMenuSidePanelButtons();
		mainPanel.add(sideBarPanel);

		/* For adding labels and fields that ask for login details */
		userPanel = new JPanel();
		userPanel.setPreferredSize(new Dimension(1024, 768));
		mainPanel.add(userPanel);

		/* Starting page that shows that the program is about */
		AboutPanel aboutPanel = new AboutPanel();
		aboutPanel.addAboutPanelComponents();
		userPanel.add(aboutPanel);		

		/* Finish instantiating our loginFrame */
		loginFrame.getContentPane().add(mainPanel);
		loginFrame.pack();
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setVisible(true);
	}

}

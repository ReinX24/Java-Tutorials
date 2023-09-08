package com.bank.loginPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPanel extends JPanel {

	JLabel aboutTitleLabel;
	JLabel aboutDescriptionLabel;
	JLabel featuresLabelTitle;
	JLabel featureOne;
	JLabel featureTwo;
	JLabel featureThree;
	JLabel featureFour;

	public AboutPanel() {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 16, 16));
	}
	
	public void addAboutPanelComponents() {
		aboutTitleLabel = new JLabel("Welcome to bAccess!");
		aboutTitleLabel.setFont(new Font(null, Font.BOLD, 32));
		aboutTitleLabel.setForeground(MainPanel.BLACK);
		aboutTitleLabel.setPreferredSize(new Dimension(1024, 32));

		this.add(aboutTitleLabel);

		aboutDescriptionLabel = new JLabel("\"Empowering Your Financial Future With Technology\"");
		aboutDescriptionLabel.setFont(new Font(null, Font.ITALIC, 28));
		aboutDescriptionLabel.setForeground(MainPanel.BLACK);
		aboutDescriptionLabel.setPreferredSize(new Dimension(1024, 32));

		this.add(aboutDescriptionLabel);

		featuresLabelTitle = new JLabel("Features:");
		featuresLabelTitle.setFont(new Font(null, Font.PLAIN, 24));
		featuresLabelTitle.setForeground(MainPanel.BLACK);
		featuresLabelTitle.setPreferredSize(new Dimension(1024, 32));

		this.add(featuresLabelTitle);

		featureOne = new JLabel(" - 24/7 Accessibility");
		featureOne.setFont(new Font(null, Font.PLAIN, 20));
		featureOne.setForeground(MainPanel.BLACK);
		featureOne.setPreferredSize(new Dimension(1024, 32));

		this.add(featureOne);

		featureTwo = new JLabel(" - Real-Time Account Monitoring");
		featureTwo.setFont(new Font(null, Font.PLAIN, 20));
		featureTwo.setForeground(MainPanel.BLACK);
		featureTwo.setPreferredSize(new Dimension(1024, 32));

		this.add(featureTwo);

		featureThree = new JLabel(" - Easy Fund Transfers");
		featureThree.setFont(new Font(null, Font.PLAIN, 20));
		featureThree.setForeground(MainPanel.BLACK);
		featureThree.setPreferredSize(new Dimension(1024, 32));

		this.add(featureThree);

		featureFour = new JLabel(" - Enhanced Security");
		featureFour.setFont(new Font(null, Font.PLAIN, 20));
		featureFour.setForeground(MainPanel.BLACK);
		featureFour.setPreferredSize(new Dimension(1024, 32));

		this.add(featureFour);
	}
}

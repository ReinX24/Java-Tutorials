package practiceFlagGenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseFlag extends JFrame implements ActionListener {

	JButton germanFlagButton;
	JButton frenchFlagButton;
	JButton italianFlagButton;

	public ChooseFlag() {
		// Program that asks which flag the user wants to generate, it will then
		// generate that flag

		// Banner photo of our JFrame
		ImageIcon bannerPhoto = new ImageIcon("pepeBanner.webp");

		JLabel bannerPhotoLabel = new JLabel();
		bannerPhotoLabel.setBounds(50, 20, 800, 150);
		bannerPhotoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		bannerPhotoLabel.setIcon(bannerPhoto);

		// Title text for our program
		JLabel titleText = new JLabel();
		titleText.setText("[Choose a Flag]");
		titleText.setBounds(300, 200, 300, 50);
		titleText.setOpaque(true);
		titleText.setBackground(Color.WHITE);
		titleText.setHorizontalAlignment(JLabel.CENTER);
		titleText.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		titleText.setFont(new Font("Arial", Font.BOLD, 14));

		// Footer for our program
		JLabel footerText = new JLabel();
		footerText.setText("[Flag Generator Program by Rein Solis]");
		footerText.setBounds(300, 500, 300, 50);
		footerText.setOpaque(true);
		footerText.setBackground(Color.WHITE);
		footerText.setHorizontalAlignment(JLabel.CENTER);
		footerText.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		footerText.setFont(new Font("Arial", Font.BOLD, 12));

		// Adding a photo under our footerText
		JLabel footerPhotoPanel = new JLabel();
		footerPhotoPanel.setLayout(new BorderLayout());
		footerPhotoPanel.setHorizontalAlignment(JLabel.CENTER);
		footerPhotoPanel.setVerticalAlignment(JLabel.CENTER);
		footerPhotoPanel.setBounds(250, 600, 400, 200);
		footerPhotoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		footerPhotoPanel.setVisible(true);

		ImageIcon footerPhoto = new ImageIcon("peepoHappy.jpg");
		footerPhotoPanel.setIcon(footerPhoto);

		// Creating our mainFrame
		this.setSize(900, 900);
		this.setTitle("[Flag Generator]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setVisible(true);

		ImageIcon programIcon = new ImageIcon("GitHub-Mark.png");
		this.setIconImage(programIcon.getImage());

		// Setting mainFrame border layout
		this.setLayout(null);

		// Adding Banner photo to our JFrame
		this.add(bannerPhotoLabel);

		// Adding Title text to our JFrame
		this.add(titleText);

		// Adding Footer text to our JFrame
		this.add(footerText);

		// Adding Footer photo
		this.add(footerPhotoPanel);

		// Creating buttons for each flag choices

		// German Flag
		germanFlagButton = new JButton();
		germanFlagButton.setText("[German Flag]");
		germanFlagButton.setBounds(25, 300, 250, 100);
		germanFlagButton.setFocusable(false);
		germanFlagButton.setHorizontalAlignment(JButton.CENTER);
		germanFlagButton.setVerticalAlignment(JButton.CENTER);
		germanFlagButton.addActionListener(this); // so that the ActionListener can detect button presses

		// French Flag
		frenchFlagButton = new JButton();
		frenchFlagButton.setText("[French Flag]");
		frenchFlagButton.setBounds(325, 300, 250, 100);
		frenchFlagButton.setFocusable(false);
		frenchFlagButton.setHorizontalAlignment(JButton.CENTER);
		frenchFlagButton.setVerticalAlignment(JButton.CENTER);
		frenchFlagButton.addActionListener(this);

		// Italian Flag
		italianFlagButton = new JButton();
		italianFlagButton.setText("[Italian Flag]");
		italianFlagButton.setBounds(625, 300, 250, 100);
		italianFlagButton.setFocusable(false);
		italianFlagButton.setHorizontalAlignment(JButton.CENTER);
		italianFlagButton.setVerticalAlignment(JButton.CENTER);
		italianFlagButton.addActionListener(this);

		// Adding buttons to our mainFrame
		this.add(germanFlagButton);
		this.add(frenchFlagButton);
		this.add(italianFlagButton);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == germanFlagButton) {
			System.out.println("[German Flag Chosen!]");
			new CreateGermanFlag();
		} else if (arg0.getSource() == frenchFlagButton) {
			System.out.println("[French Flag Chosen!]");
			new CreateFrenchFlag();
		} else if (arg0.getSource() == italianFlagButton) {
			System.out.println("[Italian Flag Chosen]");
			new CreateItalianFlag();
		}
	}

}

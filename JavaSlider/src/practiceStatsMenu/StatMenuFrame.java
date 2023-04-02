package practiceStatsMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StatMenuFrame extends JFrame implements ChangeListener, ActionListener {

	JLabel menuText;

	JPanel strengthPanel;
	JPanel agilityPanel;
	JPanel dexterityPanel;
	JPanel intelligencePanel;

	JLabel strengthLabel;
	JLabel agilityLabel;
	JLabel dexterityLabel;
	JLabel intelligenceLabel;

	JSlider strengthSlider;
	JSlider agilitySlider;
	JSlider dexteritySlider;
	JSlider intelligenceSlider;

	JButton submitStatsButton;

	public StatMenuFrame() {
		this.setSize(1280, 720);
		this.setTitle("[Character Stats]");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		menuText = new JLabel();
		menuText.setText("[Adjust Character Attributes]");
		menuText.setOpaque(true);
		menuText.setBackground(Color.WHITE);
		menuText.setForeground(Color.BLACK);
		menuText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		menuText.setHorizontalAlignment(JLabel.CENTER);
		menuText.setBounds(440, 30, 400, 50);

		strengthPanel = new JPanel();
		strengthPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		strengthPanel.setBounds(5, 100, 310, 500);

		agilityPanel = new JPanel();
		agilityPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		agilityPanel.setBounds(325, 100, 310, 500);

		dexterityPanel = new JPanel();
		dexterityPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		dexterityPanel.setBounds(645, 100, 310, 500);

		intelligencePanel = new JPanel();
		intelligencePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		intelligencePanel.setBounds(965, 100, 310, 500);

		// Creating strengthSlider
		strengthSlider = new JSlider(0, 100, 50);

		// Small ticks
		strengthSlider.setPaintTicks(true);
		strengthSlider.setMinorTickSpacing(10);

		// Large ticks
		strengthSlider.setPaintTrack(true);
		strengthSlider.setMajorTickSpacing(25);

		// Labels / numbers
		strengthSlider.setPaintLabels(true);

		strengthSlider.setOrientation(JSlider.VERTICAL);
		strengthSlider.setPreferredSize(new Dimension(300, 300));
		strengthSlider.addChangeListener(this);

		// Creating strengthLabel for our strengthSlider
		strengthLabel = new JLabel();
		strengthLabel.setText("Strength: " + strengthSlider.getValue());
		strengthLabel.setFont(new Font("Arial", Font.BOLD, 18));

		strengthPanel.add(strengthSlider);
		strengthPanel.add(strengthLabel);

		// Creating and adding agilitySlider
		agilitySlider = new JSlider(0, 100, 50);

		agilitySlider.setPaintTicks(true);
		agilitySlider.setMinorTickSpacing(10);

		agilitySlider.setPaintTrack(true);
		agilitySlider.setMajorTickSpacing(25);

		agilitySlider.setPaintLabels(true);

		agilitySlider.setOrientation(JSlider.VERTICAL);
		agilitySlider.setPreferredSize(new Dimension(300, 300));
		agilitySlider.addChangeListener(this);

		agilityLabel = new JLabel();
		agilityLabel.setText("Agility: " + agilitySlider.getValue());
		agilityLabel.setFont(new Font("Arial", Font.BOLD, 18));

		agilityPanel.add(agilitySlider);
		agilityPanel.add(agilityLabel);

		// Creating and adding dexteritySlider
		dexteritySlider = new JSlider(0, 100, 50);

		dexteritySlider.setPaintTicks(true);
		dexteritySlider.setMinorTickSpacing(10);

		dexteritySlider.setPaintTrack(true);
		dexteritySlider.setMajorTickSpacing(25);

		dexteritySlider.setPaintLabels(true);

		dexteritySlider.setOrientation(JSlider.VERTICAL);
		dexteritySlider.setPreferredSize(new Dimension(300, 300));
		dexteritySlider.addChangeListener(this);

		dexterityLabel = new JLabel();
		dexterityLabel.setText("Dexterity: " + dexteritySlider.getValue());
		dexterityLabel.setFont(new Font("Arial", Font.BOLD, 18));

		dexterityPanel.add(dexteritySlider);
		dexterityPanel.add(dexterityLabel);

		intelligenceSlider = new JSlider(0, 100, 50);

		intelligenceSlider.setPaintTicks(true);
		intelligenceSlider.setMinorTickSpacing(10);

		intelligenceSlider.setPaintTrack(true);
		intelligenceSlider.setMajorTickSpacing(25);

		intelligenceSlider.setPaintLabels(true);

		intelligenceSlider.setOrientation(JSlider.VERTICAL);
		intelligenceSlider.setPreferredSize(new Dimension(300, 300));
		intelligenceSlider.addChangeListener(this);

		intelligenceLabel = new JLabel();
		intelligenceLabel.setText("Intelligence: " + intelligenceSlider.getValue());
		intelligenceLabel.setFont(new Font("Arial", Font.BOLD, 18));

		intelligencePanel.add(intelligenceSlider);
		intelligencePanel.add(intelligenceLabel);

		submitStatsButton = new JButton("[Submit]");
		submitStatsButton.setFocusable(false);
		submitStatsButton.setBounds(540, 620, 200, 50);
		submitStatsButton.addActionListener(this);

		this.add(menuText);
		this.add(strengthPanel);
		this.add(agilityPanel);
		this.add(dexterityPanel);
		this.add(intelligencePanel);
		this.add(submitStatsButton);
		this.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		strengthLabel.setText("Strength: " + strengthSlider.getValue());
		agilityLabel.setText("Agility: " + agilitySlider.getValue());
		dexterityLabel.setText("Dexterity: " + dexteritySlider.getValue());
		intelligenceLabel.setText("Intelligence: " + intelligenceSlider.getValue());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == submitStatsButton) {
			// TODO: Create a new JFrame consisting of information
			this.dispose(); // disposes current JFrame
			JFrame characterFrame = new JFrame();
			characterFrame.setTitle("[Character Information]");
			characterFrame.setSize(1280, 720);
			characterFrame.setResizable(false);
			characterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			characterFrame.getContentPane().setBackground(new Color(0, 128, 128));
			characterFrame.setLocationRelativeTo(null);
			characterFrame.setLayout(null);

			JPanel characterSummary = new JPanel();
			characterSummary.setBounds(320, 100, 640, 480);
			characterSummary.setBackground(new Color(128, 128, 0));
			characterSummary.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			characterSummary.setLayout(null);

			JLabel summaryText = new JLabel();
			summaryText.setText("[Summary Of Stats]");
			summaryText.setHorizontalAlignment(JLabel.CENTER);
			summaryText.setFont(new Font("Arial", Font.BOLD, 16));
			summaryText.setForeground(Color.WHITE);
			summaryText.setBounds(160, 20, 320, 100);

			JLabel strengthText = new JLabel();
			strengthText.setText("Strength: " + strengthSlider.getValue());
			strengthText.setHorizontalAlignment(JLabel.CENTER);
			strengthText.setFont(new Font("Arial", Font.BOLD, 16));
			strengthText.setForeground(Color.WHITE);
			strengthText.setBounds(10, 160, 140, 120);

			JLabel agilityText = new JLabel();
			agilityText.setText("Agility: " + agilitySlider.getValue());
			agilityText.setHorizontalAlignment(JLabel.CENTER);
			agilityText.setFont(new Font("Arial", Font.BOLD, 16));
			agilityText.setForeground(Color.WHITE);
			agilityText.setBounds(170, 160, 140, 120);

			JLabel dexterityText = new JLabel();
			dexterityText.setText("Dexterity: " + dexteritySlider.getValue());
			dexterityText.setHorizontalAlignment(JLabel.CENTER);
			dexterityText.setFont(new Font("Arial", Font.BOLD, 16));
			dexterityText.setForeground(Color.WHITE);
			dexterityText.setBounds(330, 160, 140, 120);

			JLabel intelligenceText = new JLabel();
			intelligenceText.setText("Intelligence: " + intelligenceSlider.getValue());
			intelligenceText.setHorizontalAlignment(JLabel.CENTER);
			intelligenceText.setFont(new Font("Arial", Font.BOLD, 16));
			intelligenceText.setForeground(Color.WHITE);
			intelligenceText.setBounds(490, 160, 140, 120);

			characterSummary.add(summaryText);
			characterSummary.add(strengthText);
			characterSummary.add(agilityText);
			characterSummary.add(dexterityText);
			characterSummary.add(intelligenceText);

			characterFrame.add(characterSummary);
			characterFrame.setVisible(true);
		}
	}

}

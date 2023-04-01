package practiceBirthdayComboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BirthdayFrame extends JFrame implements ActionListener {

	JLabel titleText;

	JLabel monthText;
	JLabel dayText;
	JLabel yearText;
	JPanel mainPanel;

	String[] monthChoices = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };

	Integer[] dayChoices = new Integer[31];

	Integer[] yearChoices = new Integer[70];

	JComboBox<String> monthBox;
	JComboBox<Integer> dayBox;
	JComboBox<Integer> yearBox;

	JButton submitButton;

	public BirthdayFrame() {
		this.setTitle("[Birthday]");
		this.setSize(500, 500);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);
		this.setLocationRelativeTo(null); // makes JFrame appear at the center of the screen

		titleText = new JLabel("[Enter Birthday]");
		titleText.setBounds(100, 30, 300, 50);
		titleText.setOpaque(true);
		titleText.setBackground(Color.WHITE);
		titleText.setForeground(Color.BLACK);
		titleText.setFont(new Font("Arial", Font.BOLD, 16));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		titleText.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		monthText = new JLabel("Month");
		monthText.setOpaque(true);
		monthText.setBackground(Color.WHITE);
		monthText.setForeground(Color.BLACK);
		monthText.setHorizontalAlignment(JLabel.CENTER);
		monthText.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		dayText = new JLabel("Day");
		dayText.setOpaque(true);
		dayText.setBackground(Color.WHITE);
		dayText.setForeground(Color.BLACK);
		dayText.setHorizontalAlignment(JLabel.CENTER);
		dayText.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		yearText = new JLabel("Year");
		yearText.setOpaque(true);
		yearText.setBackground(Color.WHITE);
		yearText.setForeground(Color.BLACK);
		yearText.setHorizontalAlignment(JLabel.CENTER);
		yearText.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 128, 128));
		mainPanel.setBounds(25, 100, 450, 100);
		mainPanel.setLayout(new GridLayout(2, 3, 10, 10));

		mainPanel.add(monthText);
		mainPanel.add(dayText);
		mainPanel.add(yearText);

		// Filling up arrays for our ComboBoxes

		for (int i = 0; i < dayChoices.length; i++) {
			dayChoices[i] = i + 1;
		}

		int yearNum = 1970;
		for (int i = 0; i < yearChoices.length; i++) {
			yearChoices[i] = yearNum++;
		}

		monthBox = new JComboBox<String>(monthChoices);

		dayBox = new JComboBox<Integer>(dayChoices);

		yearBox = new JComboBox<Integer>(yearChoices);

		mainPanel.add(monthBox);
		mainPanel.add(dayBox);
		mainPanel.add(yearBox);

		submitButton = new JButton("[Submit]");
		submitButton.setBounds(175, 250, 150, 50);

		submitButton.addActionListener(this);

		this.add(titleText);
		this.add(mainPanel);
		this.add(submitButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == submitButton) {

			String birthMonth = (String) monthBox.getSelectedItem();
			Integer birthDay = (Integer) dayBox.getSelectedItem();
			Integer birthYear = (Integer) yearBox.getSelectedItem();

			JOptionPane.showMessageDialog(null, "Birthday: " + birthMonth + " " + birthDay + ", " + birthYear,
					"[Birthday Information]", JOptionPane.INFORMATION_MESSAGE);

		}
	}
}

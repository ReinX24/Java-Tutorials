package practiceColorChooserTextfieldButtons;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PracticeFrame extends JFrame implements ActionListener {

	JButton changeFontColor;
	JButton changeBackgroundColor;
	JTextField userText;

	public PracticeFrame() {
		this.setTitle("[JColorChooser with TextField and Buttons]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(new FlowLayout());

		changeFontColor = new JButton("Change Font Color");
		changeFontColor.setPreferredSize(new Dimension(240, 80));
		changeFontColor.setFocusable(false);
		changeFontColor.addActionListener(this);

		changeBackgroundColor = new JButton("Change Background Color");
		changeBackgroundColor.setPreferredSize(new Dimension(240, 80));
		changeBackgroundColor.setFocusable(false);
		changeBackgroundColor.addActionListener(this);

		userText = new JTextField();
		userText.setPreferredSize(new Dimension(500, 80));
		userText.setText("Add Text Here!");
		userText.setFont(new Font("Arial", Font.PLAIN, 32));
		userText.setHorizontalAlignment(JTextField.CENTER);

		this.add(changeFontColor);
		this.add(changeBackgroundColor);
		this.add(userText);

		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == changeFontColor) {

			Color newFontColor = JColorChooser.showDialog(null, "Change Font Color", Color.BLACK);

			userText.setForeground(newFontColor);

		} else if (arg0.getSource() == changeBackgroundColor) {

			Color newBackgroundColor = JColorChooser.showDialog(null, "Change Background Color", Color.WHITE);

			userText.setBackground(newBackgroundColor);

		}

	}

}

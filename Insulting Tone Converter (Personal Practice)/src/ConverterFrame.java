import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterFrame extends JFrame implements ActionListener {

	JTextArea userArea;

	JButton convertButton;

	JTextArea convertedArea;

	public ConverterFrame() {

		this.setTitle("[Insulting Tone Converter]");
		this.setSize(500, 930);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setResizable(false);
		this.setLayout(null);

		userArea = new JTextArea(5, 10);
		userArea.setLineWrap(true); // makes sure the buttons do not overflow
		userArea.setBounds(10, 10, 480, 280);
		userArea.setFont(new Font("Arial", Font.BOLD, 16));

		convertButton = new JButton("[CONVERT]");
		convertButton.setFocusable(false);
		convertButton.setFont(new Font("Arial", Font.BOLD, 32));
		convertButton.setBounds(10, 310, 480, 280);
		convertButton.addActionListener(this);

		convertedArea = new JTextArea();
		convertedArea.setLineWrap(true);
		convertedArea.setEditable(false);
		convertedArea.setBounds(10, 610, 480, 280);
		convertedArea.setFont(new Font("Arial", Font.BOLD, 16));

		this.add(userArea);
		this.add(convertButton);
		this.add(convertedArea);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == convertButton) {
			JOptionPane.showMessageDialog(null, "Text Converted!", "[Convert Message]",
					JOptionPane.INFORMATION_MESSAGE);

			String userString = userArea.getText().toLowerCase();
			char[] userCharArr = userString.toCharArray();

			for (int i = 0; i < userCharArr.length; i++) {

				if (userCharArr[i] >= 'a' && userCharArr[i] <= 'z') {
					if (i % 2 != 0) {
						userCharArr[i] = Character.toUpperCase(userCharArr[i]);
					}
				}

			}

			userString = String.valueOf(userCharArr);
			convertedArea.setText(userString);

		}

	}

}

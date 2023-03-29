package practiceJavaTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {

	JTextField mainTextField;
	JButton submitButton;

	public MainFrame() {
		this.setTitle("[Java Text Field Practice]");
		this.setLayout(new FlowLayout());

		mainTextField = new JTextField();
		// Since FlowLayout, we use setPreferredSize & new Dimension
		mainTextField.setPreferredSize(new Dimension(400, 80));
		// Setting different attributes in our mainTextField
		mainTextField.setFont(new Font("Arial", Font.PLAIN, 32));
		mainTextField.setForeground(Color.GREEN);
		mainTextField.setBackground(Color.BLACK);
		mainTextField.setCaretColor(new Color(255, 128, 0));
		mainTextField.setText("[Enter your name]");

		// Adding a button to our mainTextField
		submitButton = new JButton("[Submit]");
		submitButton.setFocusable(false);
		submitButton.setPreferredSize(new Dimension(200, 80));
		submitButton.addActionListener(this);

		this.add(submitButton);
		this.add(mainTextField);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == submitButton) {
			mainTextField.setEditable(false);
			submitButton.setEnabled(false);
			String userName = mainTextField.getText(); // getting user input
			JOptionPane.showMessageDialog(null, "Hello " + userName, "[Username Hello]",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

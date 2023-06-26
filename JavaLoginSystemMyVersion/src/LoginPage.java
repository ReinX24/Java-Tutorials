import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	HashMap<String, String> programIDsAndPasswords;

	JPanel mainPanel = new JPanel();

	JLabel userIDLabel = new JLabel("User ID:");
	JLabel userPasswordLabel = new JLabel("Password:");

	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");

	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();

	JLabel loginStatusLabel = new JLabel("Test");

	public LoginPage(HashMap<String, String> programIDsAndPasswords) {
		this.programIDsAndPasswords = programIDsAndPasswords;

		this.setTitle("Java Login System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		mainPanel.setPreferredSize(new Dimension(640, 480));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 100));

		userIDLabel.setPreferredSize(new Dimension(300, 50));
		userIDLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		userIDField.setPreferredSize(new Dimension(300,50));
		userIDField.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		mainPanel.add(userIDLabel);
		mainPanel.add(userIDField);
		
		userPasswordLabel.setPreferredSize(new Dimension(300, 50));
		userPasswordLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		userPasswordField.setPreferredSize(new Dimension(300,50));
		userPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		mainPanel.add(userPasswordLabel);
		mainPanel.add(userPasswordField);
		
		mainPanel.add(loginStatusLabel);

		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}

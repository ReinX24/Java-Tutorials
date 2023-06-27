import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	HashMap<String, String> programIDsAndPasswords;

	JPanel mainPanel = new JPanel();

	JLabel loginTitleLabel = new JLabel("LOGIN");

	String userIDLabelString = String.format("%20s", "\tUser ID:");
	String userPasswordLabelString = String.format("%20s", "Password:");

	JLabel userIDLabel = new JLabel(userIDLabelString);
	JLabel userPasswordLabel = new JLabel(userPasswordLabelString);

	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");

	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();

	JLabel loginStatusLabel = new JLabel();

	static Dimension mainPanelDimension = new Dimension(640, 480);
	static Color backgroundPanelColor = new Color(224, 224, 224);
	Color loginButtonBackgroundColor = new Color(0, 128, 128);
	Color resetButtonBackgroundColor = new Color(255, 128, 0);

	URL loginPageIcon = getClass().getResource("loginPhoto.png");
	URL loginButtonIcon = getClass().getResource("loginButtonPhoto.png");
	URL resetButtonIcon = getClass().getResource("resetButtonPhoto.png");

	public LoginPage(HashMap<String, String> programIDsAndPasswords) {
		this.programIDsAndPasswords = programIDsAndPasswords;

		this.setTitle("Java Login System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon(loginPageIcon).getImage());

		mainPanel.setPreferredSize(mainPanelDimension);
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
		mainPanel.setBackground(backgroundPanelColor);

		loginTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		loginTitleLabel.setPreferredSize(new Dimension(600, 40));
		loginTitleLabel.setFont(new Font(null, Font.BOLD, 42));

		mainPanel.add(loginTitleLabel);

		userIDLabel.setPreferredSize(new Dimension(250, 50));
		userIDLabel.setFont(new Font(null, Font.PLAIN, 26));

		userIDField.setPreferredSize(new Dimension(350, 50));
		userIDField.setFont(new Font(null, Font.PLAIN, 26));
		userIDField.addKeyListener(this);

		mainPanel.add(userIDLabel);
		mainPanel.add(userIDField);

		userPasswordLabel.setPreferredSize(new Dimension(250, 50));
		userPasswordLabel.setFont(new Font(null, Font.PLAIN, 26));

		userPasswordField.setPreferredSize(new Dimension(350, 50));
		userPasswordField.setFont(new Font(null, Font.PLAIN, 26));
		userPasswordField.addKeyListener(this);

		mainPanel.add(userPasswordLabel);
		mainPanel.add(userPasswordField);

		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		loginButton.setPreferredSize(new Dimension(250, 50));
		loginButton.setFont(new Font(null, Font.PLAIN, 26));
		loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
		loginButton.setIcon(new ImageIcon(loginButtonIcon));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(loginButtonBackgroundColor);

		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		resetButton.setPreferredSize(new Dimension(250, 50));
		resetButton.setFont(new Font(null, Font.PLAIN, 26));
		resetButton.setBorder(BorderFactory.createRaisedBevelBorder());
		resetButton.setIcon(new ImageIcon(resetButtonIcon));
		resetButton.setForeground(Color.WHITE);
		resetButton.setBackground(resetButtonBackgroundColor);

		mainPanel.add(loginButton);
		mainPanel.add(resetButton);

		loginStatusLabel.setPreferredSize(new Dimension(400, 50));
		loginStatusLabel.setFont(new Font(null, Font.ITALIC, 36));
		loginStatusLabel.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(loginStatusLabel);

		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == loginButton) {

			String userIDInput = userIDField.getText();
			String userPasswordInput = String.valueOf(userPasswordField.getPassword());

			if (programIDsAndPasswords.containsKey(userIDInput)) {
				// Getting password of userIDInput key in programIDsAndPasswords hashmap and
				// checking if similar to userPasswordInput
				if (programIDsAndPasswords.get(userIDInput).equals(userPasswordInput)) {
					loginStatusLabel.setForeground(new Color(0, 128, 128));
					loginStatusLabel.setText("Login Verified!");
					JOptionPane.showMessageDialog(this, "Login Successful!", "Login Message",
							JOptionPane.INFORMATION_MESSAGE);
					this.dispose(); // closes current JFrame
					new WelcomePage(userIDInput);

				} else {
					// If the user types in the wrong password but right user ID
					loginStatusLabel.setForeground(Color.RED);
					loginStatusLabel.setText("Wrong Password!");
				}
			} else {
				// User ID does not exit
				loginStatusLabel.setForeground(Color.RED);
				loginStatusLabel.setText("User ID Not Found!");
			}
		}

		if (arg0.getSource() == resetButton) {
			int confirmResetChoice = JOptionPane.showConfirmDialog(this, "Reset Inputs?", "Reset Confirmation",
					JOptionPane.YES_NO_OPTION);

			if (confirmResetChoice == JOptionPane.YES_OPTION) {
				userIDField.setText("");
				userPasswordField.setText("");
				loginStatusLabel.setText("");
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// When the user presses enter, click loginButton
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			loginButton.doClick();
		}
		// If the user pressed delete, click resetButton
		if (arg0.getKeyCode() == KeyEvent.VK_DELETE) {
			resetButton.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}

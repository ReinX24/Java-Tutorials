
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePage extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel mainPanel = new JPanel();
	JLabel welcomeMessageLabel = new JLabel();

	public WelcomePage(String userIDString) {
		this.setTitle("WELCOME");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		mainPanel.setPreferredSize(LoginPage.mainPanelDimension);
		mainPanel.setBackground(LoginPage.backgroundPanelColor);

		welcomeMessageLabel.setText("Welcome " + userIDString);
		welcomeMessageLabel.setFont(new Font(null, Font.BOLD, 42));

		mainPanel.add(welcomeMessageLabel);

		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}

}

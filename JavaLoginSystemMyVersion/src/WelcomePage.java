
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePage extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel mainPanel = new JPanel();
	JLabel welcomeMessageLabel = new JLabel();

	URL welcomeIcon = getClass().getResource("welcomePhoto.png");

	public WelcomePage(String userIDString) {
		this.setTitle("WELCOME");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon(welcomeIcon).getImage());

		mainPanel.setPreferredSize(LoginPage.mainPanelDimension);
		mainPanel.setBackground(LoginPage.backgroundPanelColor);
		mainPanel.setLayout(new GridLayout(1, 1));

		welcomeMessageLabel.setText("Welcome " + userIDString);
		welcomeMessageLabel.setFont(new Font(null, Font.BOLD, 42));
		welcomeMessageLabel.setHorizontalAlignment(JLabel.CENTER);

		mainPanel.add(welcomeMessageLabel);

		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}

}

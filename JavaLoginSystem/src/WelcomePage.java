import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage {

	JFrame welcomeFrame = new JFrame("Welcome Page");
	JLabel welcomeLabel = new JLabel();

	public WelcomePage(String userID) {
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setSize(420, 420);
		welcomeFrame.setLayout(null);

		welcomeLabel.setText("Hello " + userID);
		welcomeLabel.setBounds(0, 0, 200, 35);
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 25));

		welcomeFrame.add(welcomeLabel);

		welcomeFrame.setVisible(true);
	}

}

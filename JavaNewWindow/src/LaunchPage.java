import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchPage implements ActionListener {

	JFrame mainFrame = new JFrame();
	JButton mainButton = new JButton("[New Window]");

	public LaunchPage() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(null);
		mainFrame.setTitle("[Main Frame]");

		mainButton.setBounds(100, 200, 300, 100);
		mainButton.setFocusable(false);
		mainButton.addActionListener(this); // records action

		mainFrame.add(mainButton); // adding button to mainFrame
		mainFrame.setVisible(true); // should be at the last part of constructor
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mainButton) {
			mainFrame.dispose(); // closes mainFrame and opens a new one
			new NewWindow();
		}
	}

}

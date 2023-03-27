import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewWindow {

	JFrame newWindow = new JFrame();
	JLabel labelOne = new JLabel("[Hello, World!]");

	public NewWindow() {
		newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newWindow.setSize(500, 500);
		newWindow.setLayout(null);
		newWindow.setTitle("[New Window]");

		labelOne.setBounds(100, 100, 300, 300);
		labelOne.setFont(new Font("Arial", Font.PLAIN, 16));
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		labelOne.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		newWindow.add(labelOne);
		newWindow.setVisible(true);
	}

}

package practiceNewWindow;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OverWorld extends JFrame {

	JLabel overMessage = new JLabel("Teleported To Over World!");

	public OverWorld() {
		this.setSize(500, 500);
		this.setTitle("[Over World]");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(93, 124, 21));
		this.setLayout(null);

		overMessage.setHorizontalAlignment(JLabel.CENTER);
		overMessage.setFont(new Font("Arial", Font.BOLD, 16));
		overMessage.setBounds(100, 150, 300, 200);
		overMessage.setOpaque(true);
		overMessage.setBackground(new Color(249, 255, 255));
		overMessage.setForeground(Color.BLACK);
		overMessage.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.add(overMessage);
		this.setVisible(true);

	}

}

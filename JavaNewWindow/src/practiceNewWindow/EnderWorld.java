package practiceNewWindow;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EnderWorld extends JFrame {

	JLabel enderMessage = new JLabel("[Teleported To Ender World!]");

	public EnderWorld() {
		this.setSize(500, 500);
		this.setTitle("[Ender World]");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(137, 50, 183));
		this.setLayout(null);

		enderMessage.setHorizontalAlignment(JLabel.CENTER);
		enderMessage.setFont(new Font("Arial", Font.BOLD, 16));
		enderMessage.setBounds(100, 150, 300, 200);
		enderMessage.setOpaque(true);
		enderMessage.setBackground(new Color(198, 79, 189));
		enderMessage.setForeground(new Color(249, 255, 255));
		enderMessage.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.add(enderMessage);
		this.setVisible(true);
	}

}

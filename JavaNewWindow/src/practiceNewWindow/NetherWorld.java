package practiceNewWindow;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NetherWorld extends JFrame {

	JLabel netherMessage = new JLabel("[Teleported To Nether World!]");

	public NetherWorld() {
		this.setSize(500, 500);
		this.setTitle("[Nether World]");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(172, 32, 32));
		this.setLayout(null);

		netherMessage.setHorizontalAlignment(JLabel.CENTER);
		netherMessage.setFont(new Font("Arial", Font.BOLD, 16));
		netherMessage.setBounds(100, 150, 300, 200);
		netherMessage.setOpaque(true);
		netherMessage.setBackground(new Color(17, 155, 132));
		netherMessage.setForeground(new Color(249, 255, 255));
		netherMessage.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.add(netherMessage);
		this.setVisible(true);

	}

}

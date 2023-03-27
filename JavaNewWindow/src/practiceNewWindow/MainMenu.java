package practiceNewWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu extends JFrame implements ActionListener {

	JButton netherButton = new JButton("[Nether World]");
	JButton overWorldBuntton = new JButton("[Over World]");
	JButton enderWorldButton = new JButton("[Ender World]");
	JLabel teleportLabel = new JLabel("[Choose Teleport Location]");

	public MainMenu() {
		this.setTitle("[Main Menu]");
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		teleportLabel.setBounds(300, 150, 400, 100);
		teleportLabel.setHorizontalAlignment(JLabel.CENTER);
		teleportLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		teleportLabel.setOpaque(true);
		teleportLabel.setBackground(Color.WHITE);
		teleportLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		netherButton.setBounds(100, 400, 200, 100);
		netherButton.setFocusable(false);
		netherButton.addActionListener(this);

		overWorldBuntton.setBounds(400, 400, 200, 100);
		overWorldBuntton.setFocusable(false);
		overWorldBuntton.addActionListener(this);

		enderWorldButton.setBounds(700, 400, 200, 100);
		enderWorldButton.setFocusable(false);
		enderWorldButton.addActionListener(this);

		this.add(teleportLabel);
		this.add(netherButton);
		this.add(overWorldBuntton);
		this.add(enderWorldButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose(); // closes current JFrame before opening a new one from below
		if (arg0.getSource() == netherButton) {
			new NetherWorld();
		} else if (arg0.getSource() == overWorldBuntton) {
			new OverWorld();
		} else if (arg0.getSource() == enderWorldButton) {
			new EnderWorld();
		}

	}

}

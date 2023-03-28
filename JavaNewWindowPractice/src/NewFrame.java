import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewFrame extends JFrame {

	public NewFrame() {
		this.setTitle("[New Frame / Window]");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(255, 128, 0));
		this.setLayout(null);

		JLabel newFrameLabel = new JLabel("This is a new window!");
		newFrameLabel.setBounds(100, 150, 300, 100);
		newFrameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		newFrameLabel.setOpaque(true);
		newFrameLabel.setForeground(Color.WHITE);
		newFrameLabel.setBackground(new Color(0, 128, 128));
		newFrameLabel.setHorizontalAlignment(JLabel.CENTER);

		this.add(newFrameLabel);
		this.setVisible(true);

	}

}

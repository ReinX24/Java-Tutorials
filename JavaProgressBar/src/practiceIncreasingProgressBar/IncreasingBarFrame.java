package practiceIncreasingProgressBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class IncreasingBarFrame extends JFrame {

	JProgressBar barMain;

	public IncreasingBarFrame() {
		// TODO: finish rising bar JProgressBar
		this.setTitle("[Rising Bar]");
		this.setSize(500, 500);
			
		barMain = new JProgressBar(0, 100); // min max
		barMain.setStringPainted(true); // shows percentage
		barMain.setPreferredSize(new Dimension(300, 50));
		barMain.setFont(new Font("Arial", Font.BOLD, 18));
		barMain.setForeground(Color.WHITE);
		barMain.setBackground(Color.GRAY);

		this.setVisible(true);
	}

}

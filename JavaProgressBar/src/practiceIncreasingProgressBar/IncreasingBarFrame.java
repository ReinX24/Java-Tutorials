package practiceIncreasingProgressBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class IncreasingBarFrame extends JFrame {

	JProgressBar barMain;

	public IncreasingBarFrame() {
		this.setTitle("[Increasing Bar]");
		this.setSize(500, 500);
		this.setLayout(null);

		barMain = new JProgressBar(0, 100); // min max
		barMain.setStringPainted(true); // shows percentage
		barMain.setBounds(0, 0, 500, 50);
		barMain.setFont(new Font("Arial", Font.BOLD, 18));
		barMain.setForeground(Color.RED);
		barMain.setBackground(Color.WHITE);

		this.add(barMain);
		this.setVisible(true);

		fillBar();
	}

	public void fillBar() {
		int barNum = 0;

		while (barNum <= 100) {
			barMain.setValue(barNum);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			barNum += 1;
		}
		
		barMain.setString("[Full Health!]");

	}

}

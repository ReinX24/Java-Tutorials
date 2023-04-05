package practiceDecreasingProgressBar;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class DecreasingProgressBarFrame extends JFrame {

	JProgressBar mainBar;

	public DecreasingProgressBarFrame() {
		this.setTitle("[Decreasing Progress Bar]");
		this.setSize(500, 500);
		this.getContentPane().setBackground(new Color(0, 128, 128));
		this.setLayout(null);

		mainBar = new JProgressBar(0, 100);
		mainBar.setStringPainted(true);
		mainBar.setBounds(0, 0, 500, 50);
		mainBar.setBackground(Color.WHITE);
		mainBar.setForeground(Color.RED);

		this.add(mainBar);
		this.setVisible(true);

		decreaseBar();
	}

	public void decreaseBar() {
		int barNum = 100;

		while (barNum >= 0) {
			mainBar.setValue(barNum);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			barNum -= 1;
		}
		
		mainBar.setString("[No More Health!]");

	}

}

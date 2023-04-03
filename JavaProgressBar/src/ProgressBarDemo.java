import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarDemo extends JFrame {

	JProgressBar barMain;

	public ProgressBarDemo() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLayout(null);

		barMain = new JProgressBar(0, 100); // min, max
		barMain.setValue(0); // start value of progress bar
		barMain.setBounds(0, 0, 400, 50);
		barMain.setStringPainted(true); // shows percentage
		barMain.setFont(new Font("MV Boli", Font.BOLD, 18));
		barMain.setForeground(Color.RED); // filling bar color
		barMain.setBackground(Color.BLACK); // background bar color

		this.add(barMain);
		this.setVisible(true);

		fillBar();
	}

	public void fillBar() {

		int counterNum = 100;

		while (counterNum > 0) {
			barMain.setValue(counterNum);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			counterNum -= 1;
		}

		barMain.setString("[Done!]"); // prints after while loop
	}

}

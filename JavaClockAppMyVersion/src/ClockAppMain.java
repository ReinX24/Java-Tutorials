import java.awt.Color;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockAppMain extends JFrame {

	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;

	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;

	String currentTime;
	String currentLabel;
	String currentDate;

	public static void main(String[] args) {
		new ClockAppMain();
	}

	public ClockAppMain() {
		this.setTitle("Java Clock App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(640, 480);
		this.setLayout(new FlowLayout());

		timeFormat = new SimpleDateFormat("hh:mm:ss:SSS a"); // hours, minutes, seconds, milliseconds, and am or pm

		timeLabel = new JLabel();
		timeLabel.setForeground(new Color(245, 245, 245));
		timeLabel.setBackground(new Color(21, 34, 81));
		timeLabel.setOpaque(true);
		
		dayFormat = new SimpleDateFormat("E");
		
		dateLabel = new JLabel();
		
		// TODO: add date format and JLabel
		// TODO: fix the formatting of components in JFrame

		this.add(timeLabel);
		this.add(dateLabel);
		this.setVisible(true);

		setTime();
	}

	public void setTime() {
		while (true) {
			currentTime = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(currentTime);
			
			currentDate = dayFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(currentDate);
		}
	}

}

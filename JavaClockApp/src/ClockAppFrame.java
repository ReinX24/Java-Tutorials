import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockAppFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	SimpleDateFormat myTimeFormat;
	SimpleDateFormat myDayFormat;
	SimpleDateFormat myDateFormat;

	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;

	String currentTime;
	String currentDay;
	String currentDate;

	public static void main(String[] args) {
		new ClockAppFrame();
	}

	public ClockAppFrame() {
		this.setTitle("Java Clock App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setSize(350, 200);

		myTimeFormat = new SimpleDateFormat("hh:mm:ss a"); // hours, minutes, seconds, and am or pm

		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
		timeLabel.setForeground(new Color(245, 245, 245));
		timeLabel.setBackground(new Color(21, 34, 81));
		timeLabel.setOpaque(true); // so that our background color would show

		myDayFormat = new SimpleDateFormat("EEEE"); // day of the week

		// E - just 3 letters for day of the week
		// EEEE - full text for day of the week

		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));

		myDateFormat = new SimpleDateFormat("MMMM dd, yyyy"); // month, day, and year

		// MM - just the number for the month
		// MMMMM - the entire word for the month

		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));

		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);

		setTime();
	}

	public void setTime() {
		while (true) {
			currentTime = myTimeFormat.format(Calendar.getInstance().getTime()); // gets the current time
			timeLabel.setText(currentTime);

			currentDay = myDayFormat.format(Calendar.getInstance().getTime()); // gets the current day
			dayLabel.setText(currentDay);

			currentDate = myDateFormat.format(Calendar.getInstance().getTime()); // gets the current date
			dateLabel.setText(currentDate);

			try {
				Thread.sleep(1000); // updates every second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

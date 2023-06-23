import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockAppMain extends JFrame {

	private static final long serialVersionUID = 1L;

	Calendar myCalendar;
	SimpleDateFormat myTimeFormat;
	JLabel timeLabel;
	String currentTime;

	public static void main(String[] args) {
		new ClockAppMain();
	}

	public ClockAppMain() {
		this.setTitle("Java Clock App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setSize(350, 200);
		this.setResizable(false);

		myTimeFormat = new SimpleDateFormat("hh:mm:ss a"); // hours, minutes, seconds, and am or pm

		timeLabel = new JLabel();

		this.add(timeLabel);
		this.setVisible(true);

		setTime();
	}

	public void setTime() {
		while (true) {
			currentTime = myTimeFormat.format(Calendar.getInstance().getTime()); // gets the current time
			timeLabel.setText(currentTime);
		}
	}

}

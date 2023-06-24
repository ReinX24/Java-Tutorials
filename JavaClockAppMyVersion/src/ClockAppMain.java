import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockAppMain extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel mainClockPanel;

	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;

	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;

	String currentTime;
	String currentDay;
	String currentDate;

	URL clockIcon;

	public static void main(String[] args) {
		new ClockAppMain();
	}

	public ClockAppMain() {
		this.setTitle("Java Clock App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		clockIcon = getClass().getResource("clockAppIcon.png");
		this.setIconImage(new ImageIcon(clockIcon).getImage());

		mainClockPanel = new JPanel();
		mainClockPanel.setPreferredSize(new Dimension(640, 480));
		mainClockPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		mainClockPanel.setBackground(Color.GRAY);

		timeFormat = new SimpleDateFormat("hh:mm:ss:SSS a"); // hours, minutes, seconds, milliseconds, and am or pm
		timeLabel = new JLabel();
		timeLabel.setPreferredSize(new Dimension(640, 120));
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setFont(new Font("Arial", Font.BOLD, 32));
		timeLabel.setForeground(new Color(245, 245, 245));
		timeLabel.setBackground(new Color(21, 34, 81));
		timeLabel.setOpaque(true);

		dayFormat = new SimpleDateFormat("EEEEE");
		dayLabel = new JLabel();
		dayLabel.setPreferredSize(new Dimension(640, 120));
		dayLabel.setHorizontalAlignment(JLabel.CENTER);
		dayLabel.setFont(new Font("Verdana", Font.PLAIN, 28));
		dayLabel.setBackground(new Color(245, 245, 245));
		dayLabel.setOpaque(true);

		dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateLabel = new JLabel();
		dateLabel.setPreferredSize(new Dimension(640, 120));
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setFont(new Font("Verdana", Font.PLAIN, 28));
		dateLabel.setBackground(new Color(245, 245, 245));
		dateLabel.setOpaque(true);

		mainClockPanel.add(timeLabel);
		mainClockPanel.add(dayLabel);
		mainClockPanel.add(dateLabel);

		this.add(mainClockPanel);
		this.pack();
		this.setVisible(true);

		setTime();
	}

	public void setTime() {
		while (true) {
			currentTime = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(currentTime);

			currentDay = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(currentDay);

			currentDate = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(currentDate);
		}
	}

}

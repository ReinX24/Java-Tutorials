import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopwatchFrame implements ActionListener {

	// Declaring variables that we will be using
	JFrame mainFrame = new JFrame();
	JButton startButton = new JButton("Start");
//	JButton stopButton = new JButton("Stop");
	JButton resetButton = new JButton("Reset");

	JLabel timeLabel = new JLabel();
	int elapsedTime = 0; // counts time after we start our timer
	int secondsPassed = 0;// seconds passed
	int minutesPassed = 0;
	int hoursPassed = 0;

	boolean hasStarted = false;

	String secondsString = String.format("%02d", secondsPassed); // 2 zeroes will be reserved for secondsString
	String minutesString = String.format("%02d", minutesPassed);
	String hoursString = String.format("%02d", hoursPassed);

	public StopwatchFrame() {

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Java Stopwatch");
		mainFrame.setSize(420, 420);
		mainFrame.setLayout(null);

		timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
		timeLabel.setBounds(100, 100, 220, 220); // x, y, width, height
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 36));
		timeLabel.setBorder(BorderFactory.createBevelBorder(0)); // 0 raised, 1 pressed
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		mainFrame.add(timeLabel);
		
		startButton.setBounds(100, 100, 100, 50);
		startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		
		// TODO: resume Java stopwatch tutorial @12:49

		mainFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	public void startWatch() {

	}

	public void stopWatch() {

	}

	public void resetWatch() {

	}

}

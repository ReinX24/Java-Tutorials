import java.awt.*;
import java.awt.event.*;
import java.security.cert.TrustAnchor;

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

	// how often do we want it to execute (each 1 second), ActionListener
	Timer myTimer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Timer object will execute functions in this block
			elapsedTime += 1000; // increase by 1 second (1000 milliseconds)
			hoursPassed = elapsedTime / 3600000; // 3600000 milliseconds in one hour
			minutesPassed = (elapsedTime / 60000) % 60; // 60000 milliseconds in one minute, modulo 60 to not display
														// anything above 60
			secondsPassed = (elapsedTime / 1000) % 60; // 1000 milliseconds in one second

			secondsString = String.format("%02d", secondsPassed); // 2 zeroes will be reserved for secondsString
			minutesString = String.format("%02d", minutesPassed);
			hoursString = String.format("%02d", hoursPassed);

			timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
		}

	});

	public StopwatchFrame() {

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Java Stopwatch");
		mainFrame.setSize(420, 420);
		mainFrame.setLayout(null);

		timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
		timeLabel.setBounds(100, 100, 200, 100); // x, y, width, height
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 36));
		timeLabel.setBorder(BorderFactory.createBevelBorder(0)); // 0 raised, 1 pressed
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);

		startButton.setBounds(100, 200, 100, 50);
		startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);

		resetButton.setBounds(200, 200, 100, 50);
		resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);

		mainFrame.add(startButton);
		mainFrame.add(resetButton);
		mainFrame.add(timeLabel);

		mainFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == startButton) {
			startWatch();
			if (hasStarted == false) {
				hasStarted = true;
				startButton.setText("Stop");
			} else {
				hasStarted = false;
				startButton.setText("Start");
				stopWatch();
			}

		}

		if (arg0.getSource() == resetButton) {
			hasStarted = false;
			startButton.setText("Start");
			resetWatch();
		}

	}

	public void startWatch() {
		myTimer.start(); // starts our Timer object
	}

	public void stopWatch() {
		myTimer.stop();
	}

	public void resetWatch() {
		myTimer.stop();

		elapsedTime = 0;
		secondsPassed = 0;
		minutesPassed = 0;
		hoursPassed = 0;

		secondsString = String.format("%02d", secondsPassed); // 2 zeroes will be reserved for secondsString
		minutesString = String.format("%02d", minutesPassed);
		hoursString = String.format("%02d", hoursPassed);

		timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
	}

}

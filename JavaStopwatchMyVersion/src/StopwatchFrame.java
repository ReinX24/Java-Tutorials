import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class StopwatchFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JButton startButton = new JButton();
	JButton resetButton = new JButton();

	JPanel mainPanel;

	int millisecondsPassed = 0;
	int secondsPassed = 0;
	int minutesPassed = 0;
	int hoursPassed = 0;

	String secondsString = String.format("%02d", secondsPassed);
	String minutesString = String.format("%02d", minutesPassed);
	String hoursString = String.format("%02d", hoursPassed);

	JLabel timeLabel = new JLabel(hoursString + ":" + minutesString + ":" + secondsString);

	boolean timerHasStarted = false;

	Timer watchTimer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Adding time to our integer variables
			millisecondsPassed += 1000;
			secondsPassed = (millisecondsPassed / 1000) % 60;
			minutesPassed = (millisecondsPassed / 60000) % 60;
			hoursPassed = millisecondsPassed / 3600000;

			// Updating String and text for in timeLabel
			secondsString = String.format("%02d", secondsPassed);
			minutesString = String.format("%02d", minutesPassed);
			hoursString = String.format("%02d", hoursPassed);

			timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
		}
	});

	URL stopWatchIcon = getClass().getResource("stopWatchIcon.png");
	URL startTimerIcon = getClass().getResource("startTimer.png");
	URL pauseTimerIcon = getClass().getResource("pauseTimer.png");
	URL resetTimerIcon = getClass().getResource("resetTimer.png");

	URL tickSoundEffect = getClass().getResource("tickSoundEffect.wav");

	public StopwatchFrame() {

		this.setTitle("Java Stopwatch");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(stopWatchIcon).getImage());

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setPreferredSize(new Dimension(640, 480));
		mainPanel.setLayout(null);

		timeLabel.setBounds(120, 120, 400, 120);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setBackground(Color.WHITE);
		timeLabel.setOpaque(true);
		timeLabel.setBorder(BorderFactory.createRaisedBevelBorder());
		timeLabel.setFont(new Font("Arial", Font.BOLD, 32));

		mainPanel.add(timeLabel);

		startButton.setText("START");
		startButton.setIcon(new ImageIcon(startTimerIcon));
		startButton.addActionListener(this);
		startButton.setFocusable(false);
		startButton.setBounds(120, 250, 190, 90);
		startButton.setFont(new Font("Arial", Font.PLAIN, 24));
		startButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		mainPanel.add(startButton);

		resetButton.setText("RESET");
		resetButton.setIcon(new ImageIcon(resetTimerIcon));
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		resetButton.setBounds(330, 250, 190, 90);
		resetButton.setFont(new Font("Arial", Font.PLAIN, 24));
		resetButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		mainPanel.add(resetButton);

		this.add(mainPanel);
		this.pack();
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == startButton) {
			if (timerHasStarted == false) {
				startTimer();
			} else {
				stopTimer();
			}
		}

		if (arg0.getSource() == resetButton) {
			resetTimer();
		}

	}

	public void startTimer() {
		watchTimer.start();
		timerHasStarted = true;
		startButton.setText("STOP");
		startButton.setIcon(new ImageIcon(pauseTimerIcon));
	}

	public void stopTimer() {
		watchTimer.stop();
		timerHasStarted = false;
		startButton.setText("START");
		startButton.setIcon(new ImageIcon(startTimerIcon));
	}

	public void resetTimer() {
		// TODO: debug resetTimer function
		int confirmReset = JOptionPane.showConfirmDialog(this, "Reset Timer?", "Reset Confirmation",
				JOptionPane.YES_NO_OPTION);

		if (confirmReset == JOptionPane.YES_OPTION) {
			stopTimer();
			millisecondsPassed = 0;
			secondsPassed = 0;
			minutesPassed = 0;
			hoursPassed = 0;

			secondsString = String.format("%02d", secondsPassed);
			minutesString = String.format("%02d", minutesPassed);
			hoursString = String.format("%02d", hoursPassed);

			timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
		}
	}

	public void playTickSound() {

	}

}

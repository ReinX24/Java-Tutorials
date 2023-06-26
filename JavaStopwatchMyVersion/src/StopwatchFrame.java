import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

public class StopwatchFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JButton startButton = new JButton();
	JButton resetButton = new JButton();
	JButton recordButton = new JButton();
	JButton exitButton = new JButton();

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

	AudioInputStream streamAudio;
	Clip audioClip;
	FloatControl adjustAudioVolume;

	URL stopWatchIcon = getClass().getResource("stopWatchIcon.png");
	URL startTimerIcon = getClass().getResource("startTimer.png");
	URL pauseTimerIcon = getClass().getResource("pauseTimer.png");
	URL resetTimerIcon = getClass().getResource("resetTimer.png");
	URL recordTimerIcon = getClass().getResource("recordTimer.png");
	URL exitTimerIcon = getClass().getResource("exitTimer.png");

	URL startTimerSound = getClass().getResource("startTimerSound.wav");
	URL stopTimerSound = getClass().getResource("stopTimerSound.wav");
	URL resetTimerSound = getClass().getResource("resetTimerSound.wav");
	URL saveTimerSound = getClass().getResource("saveTimerSound.wav");
	URL exitTimerSound = getClass().getResource("exitTimerSound.wav");

	URL errorTimerSound = getClass().getResource("errorTimerSound.wav");

	Color mainPanelBackgroundColor = new Color(143, 139, 139);
	Color startButtonColor = new Color(0, 128, 128);
	Color stopButtonColor = new Color(254, 90, 29);
	Color resetButtonColor = new Color(189, 12, 59);
	Color recordButtonColor = new Color(218, 165, 32);
	Color exitButtonColor = new Color(127, 128, 0);

	public StopwatchFrame() {

		this.setTitle("Java Stopwatch");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(stopWatchIcon).getImage());
		this.setResizable(false);

		mainPanel = new JPanel();
		mainPanel.setBackground(mainPanelBackgroundColor);
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
		startButton.setFont(new Font("Arial", Font.BOLD, 24));
		startButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		startButton.setBackground(startButtonColor);
		startButton.setForeground(Color.WHITE);

		mainPanel.add(startButton);

		resetButton.setText("RESET");
		resetButton.setIcon(new ImageIcon(resetTimerIcon));
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		resetButton.setBounds(330, 250, 190, 90);
		resetButton.setFont(new Font("Arial", Font.BOLD, 24));
		resetButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		resetButton.setBackground(resetButtonColor);
		resetButton.setForeground(Color.WHITE);

		mainPanel.add(resetButton);

		recordButton.setText("RECORD");
		recordButton.setIcon(new ImageIcon(recordTimerIcon));
		recordButton.addActionListener(this);
		recordButton.setFocusable(false);
		recordButton.setBounds(120, 350, 190, 90);
		recordButton.setFont(new Font("Arial", Font.BOLD, 24));
		recordButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		recordButton.setBackground(recordButtonColor);
		recordButton.setForeground(Color.WHITE);

		mainPanel.add(recordButton);

		exitButton.setText("EXIT");
		exitButton.setIcon(new ImageIcon(exitTimerIcon));
		exitButton.addActionListener(this);
		exitButton.setFocusable(false);
		exitButton.setBounds(330, 350, 190, 90);
		exitButton.setFont(new Font("Arial", Font.BOLD, 24));
		exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		exitButton.setBackground(exitButtonColor);
		exitButton.setForeground(Color.WHITE);

		mainPanel.add(exitButton);

		this.add(mainPanel);
		this.pack();
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == startButton) {
			if (timerHasStarted == false) {
				startTimerSound();
				startTimer();
			} else {
				stopTimerSound();
				stopTimer();
			}
		}

		if (arg0.getSource() == resetButton) {
			resetTimer();
		}

		if (arg0.getSource() == recordButton) {
			recordTime();
		}

		if (arg0.getSource() == exitButton) {
			exitTimer();
		}

	}

	// User starts the timer
	public void startTimer() {
		watchTimer.start();
		timerHasStarted = true;
		startButton.setText("STOP");
		startButton.setIcon(new ImageIcon(pauseTimerIcon));
		startButton.setBackground(stopButtonColor); // chance button color
	}

	public void stopTimer() {
		watchTimer.stop();
		timerHasStarted = false;
		startButton.setText("START");
		startButton.setIcon(new ImageIcon(startTimerIcon));
		startButton.setBackground(startButtonColor); // change button color back to original color
	}

	public void resetTimer() {
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
			resetTimerSound();
		}
	}

	public void recordTime() {
		int confirmSave = JOptionPane.showConfirmDialog(this, "Time: " + timeLabel.getText() + "\nSave Time?",
				"Recorded Time", JOptionPane.YES_NO_OPTION);

		if (confirmSave == JOptionPane.YES_OPTION) {
			String recordedTimeFileName = JOptionPane.showInputDialog(this, "Enter File Name", "File Name",
					JOptionPane.INFORMATION_MESSAGE);

			// If there is not file name, show error message
			if (recordedTimeFileName.length() == 0) {
				errorTimerSound();
				JOptionPane.showMessageDialog(this, "Invalid File Name!", "File Name Invalid Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JFileChooser saveTimeChooser = new JFileChooser();
				saveTimeChooser.setCurrentDirectory(new File(".")); // current directory
				saveTimeChooser.setSelectedFile(new File(recordedTimeFileName + ".txt"));

				int saveTimeResponse = saveTimeChooser.showSaveDialog(null);

				if (saveTimeResponse == JFileChooser.APPROVE_OPTION) {
					File savedTimeFile = new File(saveTimeChooser.getSelectedFile().getAbsolutePath());
					PrintWriter writeTime = null;

					try {
						writeTime = new PrintWriter(savedTimeFile);
						writeTime.println(timeLabel.getText());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} finally {
						saveTimerSound();
						writeTime.close();
					}
				}
			}

		}

	}

	public void exitTimer() {

		int confirmExit = JOptionPane.showConfirmDialog(this, "Exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

		if (confirmExit == JOptionPane.YES_OPTION) {
			exitTimerSound();
			System.exit(0);
		}

	}

	public void startTimerSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(startTimerSound);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			adjustAudioVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			adjustAudioVolume.setValue(-16.0f); // reduce volume of resetTimerSound
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void stopTimerSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(stopTimerSound);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			adjustAudioVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			adjustAudioVolume.setValue(-16.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void resetTimerSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(resetTimerSound);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			adjustAudioVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			adjustAudioVolume.setValue(-16.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void exitTimerSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(exitTimerSound);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			adjustAudioVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			adjustAudioVolume.setValue(-16.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void saveTimerSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(saveTimerSound);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			adjustAudioVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			adjustAudioVolume.setValue(-16.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void errorTimerSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(errorTimerSound);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			adjustAudioVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			adjustAudioVolume.setValue(-16.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}

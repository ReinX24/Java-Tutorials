import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class GameFrame extends JFrame implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel gamePanel;
	JLabel titleLabel;
	JLabel instructionsLabel;
	JLabel piLabel;
	static JTextArea piTextArea;

	// 101 digits of Pi, including the first number before the decimal point
	static String piValue = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
	static int piStartIndex = 0;
	static int piEndIndex = 1; // starts at 3
	static int piScore = 0;
	static boolean decimalPointAdded = false;
	static JLabel scoreLabel;
	JButton skipButton;
	static JButton resetButton;
	JButton exitButton;

	final Color backgroundColor = new Color(27, 36, 64);
	final Color textAreaAndButtonColor = new Color(17, 20, 38);

	GameAudio gameAudio = new GameAudio(); // Object from another class for our game audio
	GameFunctions optionDialog = new GameFunctions(); // Object from another class for some of our option dialogs
	URL piGameIcon = getClass().getResource("piGameIcon.png");

	static int elapsedTime = 0;
	static int secondsPassed = 0;
	static int minutesPassed = 0;
	static int hoursPassed = 0;

	boolean hasStarted = false;

	static String secondsString = String.format("%02d", secondsPassed);
	static String minutesString = String.format("%02d", minutesPassed);
	static String hoursString = String.format("%02d", hoursPassed);

	static JLabel timerLabel = new JLabel(hoursString + ":" + minutesString + ":" + secondsString);

	static Timer myTimer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Timer object will execute functions in this block
			elapsedTime += 1000; // increase by 1 second (1000 milliseconds)
			hoursPassed = elapsedTime / 3600000; // 3600000 milliseconds in one hour
			minutesPassed = (elapsedTime / 60000) % 60; // 60000 milliseconds in one minute, modulo 60 so that if there
														// is a remainder, it is not included in the minutesPassed
														// String
			secondsPassed = (elapsedTime / 1000) % 60; // 1000 milliseconds in one second

			secondsString = String.format("%02d", secondsPassed); // 2 zeroes will be reserved for secondsString
			minutesString = String.format("%02d", minutesPassed);
			hoursString = String.format("%02d", hoursPassed);
			timerLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
		}
	});

	public GameFrame() {
		gameAudio.playBackgroundMusic();
		this.setTitle("Pi 101");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon(piGameIcon).getImage());

		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(1024, 768));
		gamePanel.setBackground(backgroundColor);
		gamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		this.add(gamePanel);

		titleLabel = new JLabel("Pi 101", JLabel.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font(null, Font.BOLD, 32));
		titleLabel.setPreferredSize(new Dimension(1024, 64));
		gamePanel.add(titleLabel);

		instructionsLabel = new JLabel("Instructions: Type the first 101 digits of Pi!", JLabel.CENTER);
		instructionsLabel.setForeground(Color.WHITE);
		instructionsLabel.setFont(new Font(null, Font.PLAIN, 24));
		instructionsLabel.setPreferredSize(new Dimension(1024, 32));
		gamePanel.add(instructionsLabel);

		piTextArea = new JTextArea(12, 32);
		piTextArea.setBackground(textAreaAndButtonColor);
		piTextArea.setForeground(Color.WHITE);
		piTextArea.setLineWrap(true);
		piTextArea.setFont(new Font(null, Font.PLAIN, 24));
		piTextArea.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		piTextArea.setEditable(false);
		piTextArea.addKeyListener(this);
		gamePanel.add(piTextArea);

		scoreLabel = new JLabel("Score: " + piStartIndex, JLabel.CENTER);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setFont(new Font(null, Font.PLAIN, 24));
		scoreLabel.setPreferredSize(new Dimension(1024, 64));
		gamePanel.add(scoreLabel);

		skipButton = new JButton("Skip");
		skipButton.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		skipButton.setBackground(textAreaAndButtonColor);
		skipButton.setForeground(Color.WHITE);
		skipButton.addActionListener(this);
		skipButton.setFocusable(false);
		skipButton.setPreferredSize(new Dimension(256, 64));
		gamePanel.add(skipButton);

		resetButton = new JButton("Reset");
		resetButton.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		resetButton.setBackground(textAreaAndButtonColor);
		resetButton.setForeground(Color.WHITE);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		resetButton.setPreferredSize(new Dimension(256, 64));
		gamePanel.add(resetButton);

		exitButton = new JButton("Exit");
		exitButton.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		exitButton.setBackground(textAreaAndButtonColor);
		exitButton.setForeground(Color.WHITE);
		exitButton.addActionListener(this);
		exitButton.setFocusable(false);
		exitButton.setPreferredSize(new Dimension(256, 64));
		gamePanel.add(exitButton);

		// DONE: configure text in timerLabel to show the time properly
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		timerLabel.setOpaque(true);
		timerLabel.setBackground(textAreaAndButtonColor);
		timerLabel.setForeground(Color.WHITE);
		timerLabel.setPreferredSize(new Dimension(512, 64));
		gamePanel.add(timerLabel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		String pressedKey = String.valueOf(arg0.getKeyChar());
		// If the user already has typed in the 101 digits of Pi, print a message
		if (piScore == 101) {
			optionDialog.alreadyMaxScoreMessage();
		} else if (pressedKey.equals(piValue.substring(piStartIndex, piEndIndex)) && !pressedKey.equals(".")) {
			optionDialog.addNumberToTextArea(pressedKey);
		} else if (pressedKey.equals(".") && !decimalPointAdded) {
			optionDialog.addDecimalPoint(pressedKey);
		} else {
			optionDialog.wrongInputDialog();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == skipButton) {
			optionDialog.skipValuePrompt();
		}
		if (arg0.getSource() == resetButton) {
			optionDialog.resetValuesPrompt();
		}
		if (arg0.getSource() == exitButton) {
			optionDialog.askExitConfirmation();
		}
	}

}
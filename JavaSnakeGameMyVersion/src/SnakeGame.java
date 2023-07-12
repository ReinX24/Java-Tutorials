import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L; // for removing warnings
	final int SCREEN_WIDTH = 600;
	final int SCREEN_HEIGHT = 600;
	final int UNIT_SIZE = 25; // how much squares our program will have, a larger number will result in larger
								// squares
	final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE; // 144 squares
	final int TIME_DELAY = 75;

	// Snake head and body coordinates, arrays will contain coordinates for our
	// snake
	final int[] x = new int[GAME_UNITS];
	final int[] y = new int[GAME_UNITS];

	int bodyParts = 6; // snake will start with 6 body parts
	int applesEaten = 0;

	// Coordinates for our apple
	int appleX;
	int appleY;

	// Direction and to keep track if the game is over
	char snakeDirection = 'R'; // starts moving to the right
	boolean isRunning = false; // false for now, will reassign later

	Timer gameTimer;
	Random randomObj;

	// Creating objects that will be used for playing audio files
	AudioInputStream streamAudio;
	Clip audioClip;
	FloatControl gainControl;

	URL appleEatenURL = getClass().getResource("appleEatenSound.wav");
	URL gameOverSoundURL = getClass().getResource("gameOverSound.wav");
	URL newHighScoreSoundURL = getClass().getResource("newHighScoreSound.wav");

	JFrame snakeGameFrame = new JFrame();
	URL snakeGameIcon = getClass().getResource("snakeGameIcon.png");

	HighScore gameHighScore = new HighScore();

	JPanel gameOverScreenPanel = new JPanel();
	JLabel currentScoreLabel = new JLabel();
	JLabel gameOverMessageLabel = new JLabel("Game Over");
	JLabel highScoreLabel = new JLabel();

	JButton tryAgainButton = new JButton("Try Again");
	JButton exitGameButton = new JButton("Exit Game");

	public SnakeGame() {
		snakeGameFrame.setTitle("Java Snake Game");
		snakeGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		snakeGameFrame.setResizable(false);
		snakeGameFrame.setIconImage(new ImageIcon(snakeGameIcon).getImage());

		snakeGameFrame.add(this);
		createSnakeGamePanel(); // instantiates JPanel attributes

		snakeGameFrame.pack();
		snakeGameFrame.setVisible(true);
		snakeGameFrame.setLocationRelativeTo(null); // this must be at the end for it to work properly
	}

	public void createSnakeGamePanel() {

		gameHighScore.readHighScore(); // reads last high score
		gameHighScore.saveHighScore();

		randomObj = new Random();

		// Setting our JPanel attributes
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true); // must be true so that our KeyListener could be added
		this.addKeyListener(new MyKeyAdapter()); // key pressed recorded by our inner class

		startGame();
	}

	public void startGame() {
		newApple();
		isRunning = true;
		gameTimer = new Timer(TIME_DELAY, this); // timer updates the panel every 75ms
		gameTimer.start();
	}

	// For calling methods for painting components in our JPanel
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // updates the JPanel
		draw(g); // draws new components, added to next update
	}

	// Method that draws or paints our game components
	public void draw(Graphics g) {
		if (isRunning) {
			// Drawing grid lines for our JPanel (for debugging)
			for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
				// x start, y start, width, height
				g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT); // draws 23 vertical lines
				g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
			}

			// Drawing apple
			g.setColor(Color.RED);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

			// Drawing the head and body of the snake
			for (int i = 0; i < bodyParts; i++) {
				if (i == 0) { // head of the snake
					g.setColor(Color.GREEN);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(new Color(randomObj.nextInt(256), randomObj.nextInt(256), randomObj.nextInt(256)));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}

			// Drawing the score
			g.setColor(Color.RED);
			g.setFont(new Font(null, Font.BOLD, 30));
			FontMetrics fontMetrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + applesEaten,
					((SCREEN_WIDTH - fontMetrics.stringWidth("Score: " + applesEaten)) / 2) - (SCREEN_WIDTH / 4),
					g.getFont().getSize());

			g.drawString("High Score: " + gameHighScore.getHighScore(),
					((SCREEN_WIDTH - fontMetrics.stringWidth("High Score: " + gameHighScore.getHighScore())) / 2)
							+ (SCREEN_WIDTH / 4),
					g.getFont().getSize());

		} else {
//			gameOver(g);
			gameOverScreen();
		}
	}

	// Generates a new apple at a random location within the JPanel
	public void newApple() {
		appleX = ((int) randomObj.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE);
		appleY = ((int) randomObj.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE);
	}

	// For moving the snake
	public void moveSnake() {
		for (int i = bodyParts; i > 0; i--) {
			// the positions of the body parts will change to the one in front of them
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}

		// Moving the head of the snake
		switch (snakeDirection) {

		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;

		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;

		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;

		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
	}

	// Check if the head of the snake has come into contact with an apple
	public void checkApple() {
		if (x[0] == appleX && y[0] == appleY) {

			playAppleEatenSound(); // sound effect for when an apple is eaten

			bodyParts++;
			applesEaten++;
			newApple();

			// DONE: when there is a new high score, save it as an object
			// If the current applesEaten is currently higher than the high score
			if (applesEaten > gameHighScore.getHighScore()) {
				gameHighScore.setHighScore(applesEaten);
				gameHighScore.saveHighScore();
				gameHighScore.readHighScore();
			}
		}
	}

	// Checks if the user has hit any of the borders or its own body
	public void checkCollisions() {
		// Checking if the head of the snake collided with any of its body parts
		for (int i = bodyParts; i > 0; i--) {
			if (x[0] == x[i] && y[0] == y[i]) {
				isRunning = false; // stops the game and shows the Game Over screen
			}
		}

		// Goes past the left border
		if (x[0] < 0) {
			isRunning = false;
		}
		// Goes past the right border
		if (x[0] > SCREEN_WIDTH) {
			isRunning = false;
		}
		// Goes past the top border
		if (y[0] < 0) {
			isRunning = false;
		}
		// Goes past the bottom border
		if (y[0] > SCREEN_HEIGHT) {
			isRunning = false;
		}

		// This runs before going to the game over screen
		if (isRunning == false) {
			playgGameOverSound();
		}
	}

	// DONE: develop a new game over screen that gives the user the option to try
	// again or to exit the game
	public void gameOverScreen() {
		snakeGameFrame.getContentPane().removeAll();
		snakeGameFrame.repaint();
		snakeGameFrame.revalidate();

		gameOverScreenPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		gameOverScreenPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		gameOverScreenPanel.setBackground(Color.BLACK);

		snakeGameFrame.add(gameOverScreenPanel);

		currentScoreLabel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT / 4));
		currentScoreLabel.setText("Score: " + applesEaten);
		if (applesEaten < gameHighScore.getHighScore()) {
			currentScoreLabel.setForeground(Color.RED);
		} else {
			currentScoreLabel.setForeground(Color.GREEN);
		}
		currentScoreLabel.setFont(new Font(null, Font.BOLD, 40));
		currentScoreLabel.setHorizontalAlignment(JLabel.CENTER);

		gameOverScreenPanel.add(currentScoreLabel);

		gameOverMessageLabel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT / 4));
		gameOverMessageLabel.setForeground(Color.GREEN);
		gameOverMessageLabel.setFont(new Font(null, Font.BOLD, 40));
		gameOverMessageLabel.setHorizontalAlignment(JLabel.CENTER);

		gameOverScreenPanel.add(gameOverMessageLabel);

		highScoreLabel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT / 4));
		highScoreLabel.setText("High Score: " + gameHighScore.getHighScore());
		highScoreLabel.setForeground(Color.GREEN);
		highScoreLabel.setFont(new Font(null, Font.BOLD, 40));
		highScoreLabel.setHorizontalAlignment(JLabel.CENTER);

		gameOverScreenPanel.add(highScoreLabel);

		tryAgainButton.addActionListener(this);
		tryAgainButton.setFocusable(false);
		tryAgainButton.setPreferredSize(new Dimension(250, 60));
		tryAgainButton.setBorder(BorderFactory.createRaisedBevelBorder());
		tryAgainButton.setBackground(Color.WHITE);
		tryAgainButton.setForeground(Color.BLACK);
		tryAgainButton.setFont(new Font(null, Font.BOLD, 16));

		gameOverScreenPanel.add(tryAgainButton);

		exitGameButton.addActionListener(this);
		exitGameButton.setFocusable(false);
		exitGameButton.setPreferredSize(new Dimension(250, 60));
		exitGameButton.setBorder(BorderFactory.createRaisedBevelBorder());
		exitGameButton.setBackground(Color.WHITE);
		exitGameButton.setForeground(Color.BLACK);
		exitGameButton.setFont(new Font(null, Font.BOLD, 16));

		gameOverScreenPanel.add(exitGameButton);

		snakeGameFrame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (isRunning) {
			moveSnake();
			checkApple();
			checkCollisions();
		}
		repaint();

		if (arg0.getSource() == tryAgainButton) {
			new SnakeGame();
			snakeGameFrame.dispose();
		}

		if (arg0.getSource() == exitGameButton) {
			System.exit(0);
		}
	}

	// Creating an inner class that will keep track of our keyboard presses
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {

			case KeyEvent.VK_LEFT:
				if (snakeDirection != 'R') {
					snakeDirection = 'L';
				}
				break;

			case KeyEvent.VK_RIGHT:
				if (snakeDirection != 'L') {
					snakeDirection = 'R';
				}
				break;

			case KeyEvent.VK_UP:
				if (snakeDirection != 'D') {
					snakeDirection = 'U';
				}
				break;

			case KeyEvent.VK_DOWN:
				if (snakeDirection != 'U') {
					snakeDirection = 'D';
				}
				break;

			}
		}
	}

	public void playAppleEatenSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(appleEatenURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playgGameOverSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(gameOverSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playNewHighScoreSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(gameOverSoundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);

			gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);

			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}

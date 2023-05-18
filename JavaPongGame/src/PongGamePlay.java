import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class PongGamePlay extends JPanel implements Runnable {

	static final int GAME_WIDTH = 1000; // static : share one variable, final : cannot be changed
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555)); // ratio of real life ping-pong table
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

	static final int BALL_DIAMETER = 20; // 20 pixels

	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;

	static int winnerScore = 3;

	Thread gameThread;
	Image myImage;
	Graphics myGraphics;
	Random myRandom;

	Paddle playerOnePaddle;
	Paddle playerTwoPaddle;

	Ball gameBall;
	Score gameScore;

	JFrame gameFrame; // JFrame that will contain our JPanel
	Color tableColor = new Color(119, 176, 83);

	File audioFile;
	AudioInputStream streamAudio;
	Clip audioClip;
	Clip fightingClip;

	String gameWinner = null;

	public PongGamePlay() {

		// Creating our JFrame
		gameFrame = new JFrame("Pong Game");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setResizable(false);
		gameFrame.setBackground(tableColor);
		gameFrame.setIconImage(PongGameMainMenu.PONG_ICON.getImage());

		playGameFightMusic();
		newPaddles();
		newBall();

		gameScore = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true); // so that our JPanel will respond to keystrokes
		this.addKeyListener(new AL()); // using our own actionListener (AL) class
		this.setPreferredSize(SCREEN_SIZE);

		gameFrame.add(this);

		gameFrame.pack(); // packing all of the components of our JFrame
		gameFrame.setLocationRelativeTo(null); // JFrame appears at the center
		gameFrame.setVisible(true);

		gameThread = new Thread(this);
		gameThread.start();

	}

	public void newBall() {

//		gameBall = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), (GAME_HEIGHT / 2) - (BALL_DIAMETER / 2),
//				BALL_DIAMETER, BALL_DIAMETER);
		// x, y, width, height

		// random position on the y axis
		myRandom = new Random();
		gameBall = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), myRandom.nextInt(GAME_HEIGHT - BALL_DIAMETER),
				BALL_DIAMETER, BALL_DIAMETER);

	}

	public void newPaddles() {

		playerOnePaddle = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		// x, y, width, height, playerID

		playerTwoPaddle = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH,
				PADDLE_HEIGHT, 2);
		// right side of JPanel

	}

	public void paint(Graphics g) {

		myImage = createImage(getWidth(), getHeight()); // gamePanel width and height
		myGraphics = myImage.getGraphics(); // store myImage in myGraphics
		draw(myGraphics); // draw myGraphics on our JPanel
		g.drawImage(myImage, 0, 0, this); // upper left corner of our gamePanel

	}

	public void draw(Graphics g) {

		// TODO : set custom colors for left and right player areas
//		g.setColor(Color.red);
//		g.fillRect(0, 0, GAME_WIDTH / 2, GAME_HEIGHT);

		// drawing our Paddle objects
		playerOnePaddle.draw(g);
		playerTwoPaddle.draw(g);
		gameBall.draw(g);
		gameScore.draw(g);

	}

	public void move() {

		// making our Paddles move smoother, used in run() method
		playerOnePaddle.move();
		playerTwoPaddle.move();
		gameBall.move();

	}

	public void checkCollision() {

		// bounce the ball off the top and bottom window edges
		if (gameBall.y <= 0) {
			gameBall.setYDirection(-gameBall.yVelocity); // goes into the opposite direction
		}
		if (gameBall.y >= GAME_HEIGHT - BALL_DIAMETER) {
			gameBall.setYDirection(-gameBall.yVelocity);
		}

		// stops paddles at window edges
		if (playerOnePaddle.y < 0) {
			playerOnePaddle.y = 0;
		}
		if (playerOnePaddle.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
			playerOnePaddle.y = GAME_HEIGHT - PADDLE_HEIGHT;
		}

		if (playerTwoPaddle.y < 0) {
			playerTwoPaddle.y = 0;
		}
		if (playerTwoPaddle.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
			playerTwoPaddle.y = GAME_HEIGHT - PADDLE_HEIGHT;
		}

		// bounce ball off paddles
		if (gameBall.intersects(playerOnePaddle)) { // intersects method from Rectangle class

			playPaddleHitSound();

			gameBall.xVelocity = Math.abs(gameBall.xVelocity); // makes ball reverse xVelocity
			gameBall.xVelocity++; // makes ball faster for each time it hits a paddle
			if (gameBall.yVelocity > 0) { // ball going downward
				gameBall.yVelocity++; // also makes ball faster each time it hits a paddle
			} else {
				gameBall.yVelocity--; // ball going upward
			}
			gameBall.setXDirection(gameBall.xVelocity);
			gameBall.setYDirection(gameBall.yVelocity);
		}

		if (gameBall.intersects(playerTwoPaddle)) { // intersects method from Rectangle class

			playPaddleHitSound();

			gameBall.xVelocity = Math.abs(gameBall.xVelocity); // makes ball reverse xVelocity
			gameBall.xVelocity++; // makes ball faster for each time it hits a paddle
			if (gameBall.yVelocity > 0) { // ball going downward
				gameBall.yVelocity++; // also makes ball faster each time it hits a paddle
			} else {
				gameBall.yVelocity--; // ball going upward
			}
			gameBall.setXDirection(-gameBall.xVelocity);
			gameBall.setYDirection(gameBall.yVelocity);
		}

		// give a player a point and creates new Paddles and a new Ball
		if (gameBall.x <= 0) { // player two scores point
			gameScore.playerTwoScore++;
			playWallHitSound();
			newPaddles();
			newBall();
		}
		if (gameBall.x >= GAME_WIDTH - BALL_DIAMETER) {
			gameScore.playerOneScore++;
			playWallHitSound();
			newPaddles();
			newBall();
		}

	}

	// gameThread calls the run method because our class implements the runnable
	// interface
	public void run() {

		// game loop so that the program would run in 60fps
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double nanoSec = 1000000000 / amountOfTicks;
		double deltaNum = 0;

		while (!gameThread.isInterrupted()) {
			long nowTime = System.nanoTime(); // current time
			deltaNum += (nowTime - lastTime) / nanoSec;
			lastTime = nowTime;

			if (deltaNum >= 1) {
				move();
				checkCollision();
				repaint();
				deltaNum--;
			}

			if (gameScore.playerOneScore == winnerScore) {
				gameWinner = "Player 1";
				gameWinnerMessage();
				break;

			}

			if (gameScore.playerTwoScore == winnerScore) {
				gameWinner = "Player 2";
				gameWinnerMessage();
				break;
			}

		}

	}

	public void gameWinnerMessage() {
		fightingClip.stop();
		victoryMessage();
	}

	public void victoryMessage() {

		playVictorySound();

		String[] responsesArr = { "Main Menu", "Restart Game", "Exit Game" };

		int userChoice = JOptionPane.showOptionDialog(this, gameWinner + " Wins!", "Winner Message",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responsesArr, null);

		if (userChoice == 0) { // user chooses to return to Main Menu
			audioClip.stop();
			gameFrame.dispose();
			new PongGameMainMenu();
		} else if (userChoice == 1) { // user chooses to restart game
			audioClip.stop();
			gameFrame.dispose();
			new PongGamePlay();
		} else if (userChoice == 2) { // user chooses to exit game
			audioClip.stop();
			gameFrame.dispose();
		}

	}

	// Inner class, actionListener
	public class AL extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				askExitGame();
			} // TODO: add other commands?

			playerOnePaddle.keyPressed(e);
			playerTwoPaddle.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			playerOnePaddle.keyReleased(e);
			playerTwoPaddle.keyReleased(e);
		}

	}

	public void askExitGame() {
		int exitGameChoice = JOptionPane.showConfirmDialog(this, "Exit current game?", "Exit Confirm",
				JOptionPane.YES_NO_OPTION);

		if (exitGameChoice == JOptionPane.YES_OPTION) {
			fightingClip.stop();
			gameThread.interrupt();
			gameFrame.dispose();
			new PongGameMainMenu();
		}
	}

	public void playGameFightMusic() {

		audioFile = new File("FFVII REMAKE： 闘う者達 -なんでも屋の仕事-.wav");
		try {
			streamAudio = AudioSystem.getAudioInputStream(audioFile);
			fightingClip = AudioSystem.getClip();
			fightingClip.open(streamAudio);
			fightingClip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	public void playPaddleHitSound() {

		audioFile = new File("8- Bit Bounce sound effect ｜ sound effects.wav");
		AudioInputStream streamAudio;
		try {
			streamAudio = AudioSystem.getAudioInputStream(audioFile);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	public void playWallHitSound() {

		audioFile = new File("Wall Hit 8 Bit - GAMEBOY STARTUP SOUND.wav");
		try {
			streamAudio = AudioSystem.getAudioInputStream(audioFile);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	public void playVictorySound() {

		audioFile = new File("Final Fantasy VII - Victory Fanfare [HD].wav");
		try {
			streamAudio = AudioSystem.getAudioInputStream(audioFile);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

}

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PongGamePanel extends JPanel implements Runnable {

	static final int GAME_WIDTH = 1000; // static : share one variable, final : cannot be changed
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555)); // ratio of real life ping-pong table
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

	static final int BALL_DIAMETER = 20; // 20 pixels

	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;

	static int winnerScore = 1;

	Thread gameThread;
	Image myImage;
	Graphics myGraphics;
	Random myRandom;

	Paddle playerOnePaddle;
	Paddle playerTwoPaddle;

	Ball gameBall;
	Score gameScore;

	public PongGamePanel() {

		newPaddles();
		newBall();

		gameScore = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true); // so that our JPanel will respond to keystrokes
		this.addKeyListener(new AL()); // using our own actionListener (AL) class
		this.setPreferredSize(SCREEN_SIZE);

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
			newPaddles();
			newBall();
		}
		if (gameBall.x >= GAME_WIDTH - BALL_DIAMETER) {
			gameScore.playerOneScore++;
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

		while (true) {
			long nowTime = System.nanoTime(); // current time
			deltaNum += (nowTime - lastTime) / nanoSec;
			lastTime = nowTime;

			if (deltaNum >= 1) {
				move();
				checkCollision();
				repaint();
				deltaNum--;
			}

			// TODO : test first to 3 points
			if (gameScore.playerOneScore == winnerScore) {
				System.out.println("Player 1 wins");
				break; // TODO: this stops while loop, make show Restart, Main Menu, Exit Game
				
			} else if (gameScore.playerTwoScore == winnerScore) {
				System.out.println("Player 2 wins");
				break;
				
			}

		}
		

	}

	// Inner class, actionListener
	public class AL extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			playerOnePaddle.keyPressed(e);
			playerTwoPaddle.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			playerOnePaddle.keyReleased(e);
			playerTwoPaddle.keyReleased(e);
		}

	}

}

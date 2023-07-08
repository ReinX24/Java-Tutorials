import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class SnakeGamePanel extends JPanel implements ActionListener {

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

	public SnakeGamePanel() {
		randomObj = new Random();

		// Setting our JPanel attributes
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(false);
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

		} else {
			gameOver(g); // pass in our current JLabel graphic components
		}
	}

	// Generates a new apple at a random location within the JPanel
	public void newApple() {

	}

	// For moving the snake
	public void moveSnake() {

	}

	// Check if the head of the snake has come into contact with an apple
	public void checkApple() {

	}

	// Checks if the user has hit any of the borders or its own body
	public void checkCollisions() {

	}

	// Shows a "Game Over" message
	public void gameOver(Graphics g) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	// Creating an inner class that will keep track of our keyboard presses
	public class MyKeyAdapter extends KeyAdapter {
		@Override // overriding existing keyPressed method
		public void keyPressed(KeyEvent e) {

		}
	}
}

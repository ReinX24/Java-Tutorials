import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 75;

	// Snake coordinates
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];

	int bodyParts = 6;
	int applesEaten = 0;

	// Coordinates of apple
	int appleX;
	int appleY;

	char direction = 'R'; // snake starts going right
	boolean running = false;

	Timer timer;
	Random random;

	public GamePanel() {
		random = new Random();

		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter()); // keys will be recorded by our inner class

		startGame();
	}

	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this); // timer that runs in the background
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		// Drawing vertical(first) and horizontal (second) lines in our JPanel
		for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
			g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT); // x start, y start, width, height
			g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
		}
		// Drawing apple
		g.setColor(Color.RED);
		g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

		for (int i = 0; i < bodyParts; i++) {
			if (i == 0) {
				g.setColor(Color.GREEN);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			} else { // body of the snake
				g.setColor(new Color(45, 180, 0));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
		}

	}

	public void newApple() {
		appleX = ((int) random.nextInt(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE; // random x axis coordinate
		appleY = ((int) random.nextInt(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE; // random y axis coordinate
	}

	// For moving the snake
	public void move() {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}

		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE; // going up
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE; // down
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE; // left
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE; // right
		}
	}

	public void checkApple() {
		if ((x[0] == appleX) && y[0] == appleY) {
			bodyParts++;
			applesEaten++;
			newApple(); // generates a new apple
		}
	}

	public void checkCollisions() {
		// This checks if the head of the snake collides with the body
		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) { // if the snake runs into itself
				running = false;
			}
		}

		// Check if the head touches the left border
		if (x[0] < 0) {
			running = false;
		}

		// Check if the head touches the right border
		if (x[0] > SCREEN_WIDTH) {
			running = false;
		}

		// Check if the head touches the top border
		if (y[0] < 0) {
			running = false;
		}

		// Check if the head touches the bottom border
		if (y[0] > SCREEN_HEIGHT) {
			running = false;
		}

		if (!running) { // if the program is not running
			timer.stop();
		}
	}

	public void gameOver(Graphics g) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {

			case KeyEvent.VK_LEFT:
				if (direction != 'R') {
					direction = 'L';
				}
				break;

			case KeyEvent.VK_RIGHT:
				if (direction != 'L') {
					direction = 'R';
				}
				break;

			case KeyEvent.VK_UP:
				if (direction != 'D') {
					direction = 'U';
				}
				break;

			case KeyEvent.VK_DOWN:
				if (direction != 'U') {
					direction = 'D';
				}
				break;

			}
		}
	}

}

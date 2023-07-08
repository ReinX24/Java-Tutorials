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
	}

	public void newApple() {
		appleX = ((int) random.nextInt(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE; // random x axis coordinate
//		appleY = (int())
	}

	public void move() {

	}

	public void checkApple() {

	}

	public void checkCollisions() {

	}

	public void gameOver(Graphics g) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {

		}
	}

}

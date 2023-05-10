import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {

	int playerID; // for player ids

	int yVelocity; // vertical movement speed

	final int paddleSpeed = 10;

	public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int playerID) {
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT); // calling super constructor of Rectangle class
		this.playerID = playerID;
	}

	public void keyPressed(KeyEvent e) {

		switch (playerID) {

		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W) { // W key
				setYDirection(-paddleSpeed); // move up
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_S) { // S key
				setYDirection(paddleSpeed); // move down
				move();
			}
			break;

		case 2:
			if (e.getKeyCode() == KeyEvent.VK_I) { // I key
				setYDirection(-paddleSpeed); // move up
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_K) { // K key
				setYDirection(paddleSpeed); // move down
				move();
			}
			break;
		}

	}

	public void keyReleased(KeyEvent e) {

		switch (playerID) {

		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W) { // W key
				setYDirection(0); // move up
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_S) { // S key
				setYDirection(0); // move down
				move();
			}
			break;

		case 2:
			if (e.getKeyCode() == KeyEvent.VK_I) { // I key
				setYDirection(0); // move up
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_K) { // K key
				setYDirection(0); // move down
				move();
			}
			break;
		}

	}

	public void setYDirection(int yDirection) {
		yVelocity = yDirection; // reassigns yVelocity and decides to move up or down
	}

	public void move() {
		y = y + yVelocity; // y of our rectangle
	}

	public void draw(Graphics g) {

		if (playerID == 1) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.RED);
		}
		g.fillRect(x, y, width, height);

	}

}

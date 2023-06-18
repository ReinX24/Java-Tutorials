import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {

	private static final long serialVersionUID = 1L;

	int playerID; // for player ids

	int yVelocity; // vertical movement speed

	final int paddleSpeed = 10;

	static Color redPaddle = new Color(172, 58, 62);
	static Color bluePaddle = new Color(69, 91, 132);

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
			if (e.getKeyCode() == KeyEvent.VK_UP) { // Up arrow key
				setYDirection(-paddleSpeed); // move up
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) { // Down arrow key
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
			if (e.getKeyCode() == KeyEvent.VK_UP) { // Up arrow key
				setYDirection(0); // move up
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) { // Down key
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
			g.setColor(bluePaddle);
		} else {
			g.setColor(redPaddle);
		}
		g.fillRect(x, y, width, height);

	}

}

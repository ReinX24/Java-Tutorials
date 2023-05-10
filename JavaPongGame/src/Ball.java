import java.awt.*;
import java.util.*;

public class Ball extends Rectangle {

	Random myRandom;

	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;

	// TODO : resume Bro Code Pong Game @ 51m 24s mark

	public Ball(int x, int y, int ballWidth, int ballHeight) {
		super(x, y, ballWidth, ballHeight);
		myRandom = new Random();
		int randomXDirection = myRandom.nextInt(2); // generates a number >= 0 && < 2
		if (randomXDirection == 0) {
			randomXDirection--;
		}
		setXDirection(randomXDirection * initialSpeed);

		int randomYDirection = myRandom.nextInt(2); // generates a number >= 0 && < 2
		if (randomYDirection == 0) {
			randomYDirection--;
		}
		setYDirection(randomYDirection * initialSpeed);

	}

	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}

	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}

	public void move() {
		x += xVelocity;
		y += yVelocity;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, height, width);
	}

}

import java.awt.*;

public class Score extends Rectangle {

	private static final long serialVersionUID = 1L;

	static int GAME_WIDTH;
	static int GAME_HEIGHT;

	int playerOneScore;
	int playerTwoScore;

	public Score(int GAME_WIDTH, int GAME_HEIGHT) {
		Score.GAME_WIDTH = GAME_WIDTH;
		Score.GAME_HEIGHT = GAME_HEIGHT;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Consolas", Font.PLAIN, 60));

		g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);
		// start x line, start y line, ending x line position, ending y line position

		// adding our scores at the top of our window
		// will show as 00, 01, 02...
		g.drawString(String.valueOf(playerOneScore / 10) + String.valueOf(playerOneScore % 10), GAME_WIDTH / 2 - 85,
				50); // String, x position, y. position

		g.drawString(String.valueOf(playerTwoScore / 10) + String.valueOf(playerTwoScore % 10), GAME_WIDTH / 2 + 20,
				50);
	}

}

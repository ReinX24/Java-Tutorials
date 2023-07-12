
import java.io.*;

public class HighScore {

	int snakeGameHighScore = 0;

	public int getHighScore() {
		return snakeGameHighScore;
	}

	public void setHighScore(int newHighScore) {
		this.snakeGameHighScore = newHighScore;
	}

	public void saveHighScore() {
		try {
			File highScoreFile = new File("HighScoreFile");
			FileOutputStream fileOutput = new FileOutputStream(highScoreFile);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

			objectOutput.writeObject(snakeGameHighScore);
			objectOutput.flush();

			objectOutput.close();
			fileOutput.close();
		} catch (Exception e) {
			// Do nothing
		}
	}

	public void readHighScore() {
		try {
			File highScoreFile = new File("HighScoreFile");
			FileInputStream fileInput = new FileInputStream(highScoreFile);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);

			int savedGameHighScore = (int) objectInput.readObject();

			objectInput.close();
			fileInput.close();

			snakeGameHighScore = savedGameHighScore;
		} catch (Exception e) {
			// Do nothing
		}
	}

}

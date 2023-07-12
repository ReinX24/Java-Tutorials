
import javax.swing.JOptionPane;

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
			File highScoreFile = new File("SnakeGameHighScore/HighScoreFile");
			FileOutputStream fileOutput = new FileOutputStream(highScoreFile);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

			objectOutput.writeObject(snakeGameHighScore);
			objectOutput.flush();

			objectOutput.close();
			fileOutput.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Occurred, Terminating Program", "Error Message",
					JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}

	public void readHighScore() {
		try {
			File highScoreFile = new File("SnakeGameHighScore/HighScoreFile");
			FileInputStream fileInput = new FileInputStream(highScoreFile);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);

			int savedGameHighScore = (int) objectInput.readObject();

			objectInput.close();
			fileInput.close();

			snakeGameHighScore = savedGameHighScore;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Occurred, Terminating Program", "Error Message",
					JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}

}

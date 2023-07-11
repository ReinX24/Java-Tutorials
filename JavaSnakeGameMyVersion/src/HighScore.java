import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
import java.net.URL;

public class HighScore {

	static int snakeGameHighScore = 0;

	public void newHighScore(int newHighScore) {
		snakeGameHighScore = newHighScore;
	}

	public static void saveHighScore() {
		try {
			File highScoreFile = new File("SnakeGameHighScore/SnakeGameHighScore");
			FileOutputStream fileOutput = new FileOutputStream(highScoreFile);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

			objectOutput.writeObject(snakeGameHighScore);
			objectOutput.flush();

			objectOutput.close();
			fileOutput.close();
		} catch (Exception e) {
			// TODO: finish this function
			JOptionPane.showMessageDialog(null, "Error Occurred");
		}
	}

}

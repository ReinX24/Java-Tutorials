import javax.swing.JOptionPane;

public class OptionPaneDialog {

	GameAudio gameAudio = new GameAudio();

	// DONE: place congratulations message here
	public void congratulationsMessage() {
		gameAudio.playCongratsSound();
		GameFrame.myTimer.stop();
		// DONE: after saying congratulations, ask the user if they want to restart the
		// game or not
		String[] congratulationsOptions = { "Restart", "Cancel" };
		int congratulationsChoice = JOptionPane.showOptionDialog(null,
				"Congratulations! You have correctly entered the first 101 digits of Pi!\nRestart the game?",
				"Congratulations Message", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				congratulationsOptions, congratulationsOptions[0]);
		// If the user wishes to restart the game
		if (congratulationsChoice == 0) {
			GameFrame.resetButton.doClick();
		}
	}

	public void alreadyMaxScoreMessage() {
		// DONE: change message dialog into option dialog that asks if they want to
		// restart the game or not
		gameAudio.playMaxScoreSound();
		String[] maxScoreOptions = { "Restart", "Cancel" };
		int maxScoreChoice = JOptionPane.showOptionDialog(null, "101 digits of Pi already entered!",
				"Max Score Message", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, maxScoreOptions,
				maxScoreOptions[0]);
		// If the user chooses to restart the game
		if (maxScoreChoice == 0) {
			GameFrame.resetButton.doClick();
		}
	}

	// DONE: finish this function, similar to congratulations message but pokes fun
	// at the player for skipping immediately to the 101th place
	public void specialCongratulationsMessage() {
		gameAudio.playCongratsSound();
		String[] skipToEndOptions = { "Reset", "Cancel" };
		int skipToEndChoice = JOptionPane.showOptionDialog(null,
				"Congratulations for skipping to the last digit!\nRestart the game?", "Skip To End Message",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, skipToEndOptions,
				skipToEndOptions[0]);
		if (skipToEndChoice == 0) {
			GameFrame.resetButton.doClick();
		}
	}

	public void askExitConfirmation() {
		gameAudio.playExitSound();
		int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation",
				JOptionPane.YES_NO_OPTION);
		if (confirmExit == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}

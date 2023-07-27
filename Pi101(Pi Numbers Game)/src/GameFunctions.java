import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class GameFunctions {

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

	public void skipValuePrompt() {
		// DONE: Add functionality where it skips to a certain decimal place
		SpinnerNumberModel piSpinnerValues = new SpinnerNumberModel(1, 1, 101, 1);
		JSpinner piValueSpinner = new JSpinner(piSpinnerValues);
		// Making our JSpinner not editable by the user
		((JSpinner.DefaultEditor) piValueSpinner.getEditor()).getTextField().setEditable(false);

		String[] skipValueOptions = { "Confirm", "Cancel" };
		int skipValueChoice = JOptionPane.showOptionDialog(null, piValueSpinner, "Enter Placement Skip Value",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, skipValueOptions, skipValueOptions[0]);

		// If the user chooses to skip the to a certain placement value
		if (skipValueChoice == 0) {
			// The current score will equal to the index of the skipped starting value
			GameFrame.piScore = (int) piValueSpinner.getValue();
			// Current expected character will now be the next value of the current index
			// Example: If the user chooses to start at index value 2, then it will start at
			// 3.1 and will expect 4 as the next value
			GameFrame.piStartIndex = GameFrame.piScore + 1;
			GameFrame.piEndIndex = GameFrame.piScore + 2;
			GameFrame.scoreLabel.setText("Score: " + GameFrame.piScore);
			GameFrame.piTextArea.setText(GameFrame.piValue.substring(0, GameFrame.piStartIndex));
			// If the score is greater than 1 but less than 101, play the normal skip sound
			if (GameFrame.piScore >= 1 && GameFrame.piScore < 101) {
				gameAudio.playSkipSound();
			} else if (GameFrame.piScore == 101) {
				// If the score is equal to 101, play congratulations sound instead and show
				// "special" congratulations message
				// DONE: add "special" congratulations message here
				specialCongratulationsMessage();
			} else if (GameFrame.piScore > 1) {
				// If the current skipped value is greater than 3., then set decimalPointAdded
				// to true since it will add the decimal to the JTextField when we skip
				GameFrame.decimalPointAdded = true;
			}
		}
	}

	public void resetValuesPrompt() {
		int confirmReset = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset your progress?",
				"Reset Confirmation", JOptionPane.YES_NO_OPTION);
		if (confirmReset == JOptionPane.YES_OPTION) {
			gameAudio.playResetSound();
			// Resetting text area, indexes, etc.
			GameFrame.piTextArea.setText("");
			GameFrame.piStartIndex = 0;
			GameFrame.piEndIndex = 1;
			GameFrame.piScore = 0;
			GameFrame.decimalPointAdded = false;
			GameFrame.scoreLabel.setText("Score: " + GameFrame.piScore);
			// Resetting timer values
			GameFrame.elapsedTime = 0;
			GameFrame.secondsPassed = 0;
			GameFrame.minutesPassed = 0;
			GameFrame.hoursPassed = 0;

			GameFrame.secondsString = String.format("%02d", GameFrame.secondsPassed);
			GameFrame.minutesString = String.format("%02d", GameFrame.minutesPassed);
			GameFrame.hoursString = String.format("%02d", GameFrame.hoursPassed);

			GameFrame.timerLabel
					.setText(GameFrame.hoursString + ":" + GameFrame.minutesString + ":" + GameFrame.secondsString);
			GameFrame.myTimer.stop();
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

	public void addNumberToTextArea(String pressedKey) {
		// If the user enters the first number of Pi, play a special sound effect
		if (GameFrame.piTextArea.getText().length() == 0) {
			gameAudio.playFirstNumberSound();
		}
		// Checks if the current entered key is the correct one for the current
		// position, also check if the entered key is not a decimal point
		GameFrame.piTextArea.append(pressedKey);
		GameFrame.piStartIndex++;
		GameFrame.piEndIndex++;
		GameFrame.piScore++;
		GameFrame.scoreLabel.setText("Score: " + GameFrame.piScore);
		GameFrame.myTimer.start(); // starts our timer
		// If the user finally reaches the 101th digit of Pi, print congratulations
		// message
		if (GameFrame.piScore == 101) {
			congratulationsMessage();
		}
	}

	public void addDecimalPoint(String pressedKey) {
		// If the entered key is a decimal point and it has not been added yet
		GameFrame.piTextArea.append(pressedKey); // just add a period, not counted in score, not a digit
		GameFrame.decimalPointAdded = true;
		GameFrame.piStartIndex++;
		GameFrame.piEndIndex++;
	}

	public void wrongInputDialog() {
		// If the user does not type a number
		GameFrame.myTimer.start(); // starts our timer even if it is the wrong input
		gameAudio.playWrongInputSound();
		JOptionPane.showMessageDialog(null, "Wrong input!", "Wrong Input Message", JOptionPane.WARNING_MESSAGE);
	}

}

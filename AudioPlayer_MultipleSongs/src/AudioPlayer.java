import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		Scanner userInput = new Scanner(System.in);

		boolean validSong = false;
		int songNum;
		String userSong = "";

		do {

			System.out.println("\n[Audio Player]");
			System.out.println("\n[1] : Smash Mouth - All Star");
			System.out.println("[2] : Never Gonna Give You Up - Rick Astley");
			System.out.println("[3] : Fresh - Friday Night Funkin'");
			System.out.print("\nEnter song number: ");

			/* Loops if the user does not enter a number */
			while (!userInput.hasNextInt()) {
				System.out.println("\n[Invalid Input!]");
				System.out.println("\n[Audio Player]");
				System.out.println("\n[1] : Smash Mouth - All Star");
				System.out.println("[2] : Never Gonna Give You Up - Rick Astley");
				System.out.println("[3] : Fresh - Friday Night Funkin'");
				System.out.print("\nEnter song number: ");
				userInput.nextLine(); // just nextLine
			}

			songNum = userInput.nextInt();
			userInput.nextLine();

			switch (songNum) {

			case 1:
				validSong = true;
				userSong = "Smash Mouth All Star (HQ).wav";
				System.out.println("\n[" + userSong + " chosen]");
				break;

			case 2:
				validSong = true;
				userSong = "Rick Astley - Never Gonna Give You Up.wav";
				System.out.println("\n[" + userSong + " chosen]");
				break;

			case 3:
				validSong = true;
				userSong = "Fresh - Friday Night Funkin' OST.wav";
				System.out.println("\n[" + userSong + " chosen]");
				break;

			default:
				System.out.println("\n[Song Not Found!]");
				break;

			}

		} while (validSong == false);

		/* ------------------------------------------------------------------- */
		/* Processing audio file */
		File audioFile = new File(userSong);
		AudioInputStream addAudio = AudioSystem.getAudioInputStream(audioFile);
		Clip audioClip = AudioSystem.getClip();
		audioClip.open(addAudio);
		/* ------------------------------------------------------------------- */

		String userCommand = "";

		do {
			System.out.println("\n[Audio Player Commands]");
			System.out.println("\n[P] : PLAY");
			System.out.println("[S] : STOP");
			System.out.println("[R] : RESET");
			System.out.println("[Q] : QUIT");
			System.out.print("\nEnter command number: ");
			userCommand = userInput.nextLine();
			userCommand = userCommand.toUpperCase();

			switch (userCommand) {

			case "P":
				System.out.println("\n[Playing : " + audioFile.getName() + "]");
				audioClip.start();
				break;

			case "S":
				System.out.println("\n[Stopping : " + audioFile.getName() + "]");
				audioClip.stop();
				break;

			case "R":
				System.out.println("\n[Resetting : " + audioFile.getName() + "]");
				audioClip.setMicrosecondPosition(0);
				break;

			case "Q":
				System.out.println("\n[Exited Audio Player!]");
				audioClip.close();
				userInput.close();
				break;

			default:
				System.out.println("\n[Invalid Command!]");
				break;

			}

		} while (!userCommand.equals("Q"));

	}

}

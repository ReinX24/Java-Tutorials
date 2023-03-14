import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class JavaAudioPractice {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		Scanner userInput = new Scanner(System.in);

		File audioFile = new File("Smash Mouth All Star (HQ).wav");

		AudioInputStream audioAdd = AudioSystem.getAudioInputStream(audioFile);

		Clip audioClip = AudioSystem.getClip();

		audioClip.open(audioAdd);

		String userChoice = "";

		while (!userChoice.equals("Q")) {
			System.out.printf("\n[%s]\n\n", "Music Player Program");
			System.out.printf("[%-10s]\n", "P - Play");
			System.out.printf("[%-10s]\n", "S - Stop");
			System.out.printf("[%-10s]\n", "R - Reset");
			System.out.printf("[%-10s]\n", "Q - Quit");
			System.out.print("\nEnter your choice: ");
			userChoice = userInput.nextLine();
			userChoice = userChoice.toUpperCase();

			switch (userChoice) {
			case "P":
				System.out.println("[\nPlaying: " + audioFile.getName() + "]");
				audioClip.start();
				break;

			case "S":
				System.out.println("\n[Stopped: " + audioFile.getName() + "]");
				audioClip.stop();
				break;

			case "R":
				System.out.println("\n[Restarted: " + audioFile.getName() + "]");
				audioClip.setMicrosecondPosition(0); // resets to start of audio file
				break;

			case "Q":
				System.out.println("\n[Exited Music Player!]");
				audioClip.close();
				userInput.close();
				break;

			default:
				System.out.println("\n[Invalid Input]");
				break;
			}
		}

	}

}

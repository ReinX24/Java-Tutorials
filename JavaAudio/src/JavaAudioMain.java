import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class JavaAudioMain {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// Scanner to accept user input
		Scanner userInput = new Scanner(System.in);

		// File object to store wav file, can only play wav files
		File audioFile = new File("Smash Mouth All Star (HQ).wav");

		// Gets the audio file
		AudioInputStream streamAudio = AudioSystem.getAudioInputStream(audioFile);

		// Clip object to get audio file & use methods on file
		Clip audioClip = AudioSystem.getClip();

		// Opens the clip, now we could use methods on audioClip
		audioClip.open(streamAudio);

		// Storing userResonse
		String userResponse = "";

		// While loop that runs infinitely until the 
		while (!userResponse.equals("Q")) {
			System.out.println("[P - Play]");
			System.out.println("[S - Stop]");
			System.out.println("[R - Reset]");
			System.out.println("[Q - Quit]");

			System.out.print("Enter your choice: ");
			userResponse = userInput.next();
			userResponse = userResponse.toUpperCase();

			switch (userResponse) {
			case "P":
				audioClip.start();
				break;

			case "S":
				audioClip.stop();
				break;

			case "R":
				audioClip.setMicrosecondPosition(0); // restarts song
				break;

			case "Q":
				audioClip.close();
				System.out.println("[Exited Player!]");
				break;

			default:
				System.out.println("[Invalid Response]");
				break;
			}
		}

		userInput.close();
	}

}

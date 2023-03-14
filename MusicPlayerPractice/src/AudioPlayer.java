import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {

	Scanner userInput = new Scanner(System.in);
	File audioFile;
	AudioInputStream addAudio;
	Clip audioClip;
	String userChoice = "";

	void startPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		askFileName();
		processAudio();
		playerMenu();
	}

	void askFileName() {
		System.out.print("Enter file name: ");
		String audioFileName = userInput.nextLine();
		audioFile = new File(audioFileName);
	}

	void processAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		addAudio = AudioSystem.getAudioInputStream(audioFile);
		audioClip = AudioSystem.getClip();
		audioClip.open(addAudio);
	}

	void playerMenu() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
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
				playAudio();
				break;

			case "S":
				pauseAudio();
				break;

			case "R":
				restartAudio();
				break;

			case "Q":
				exitPlayer();
				break;

			default:
				System.out.println("\n[Invalid Input]");
				break;
			}
		}
	}

	void playAudio() {
		System.out.println("[\nPlaying: " + audioFile.getName() + "]");
		audioClip.start();
	}

	void pauseAudio() {
		System.out.println("\n[Stopped: " + audioFile.getName() + "]");
		audioClip.stop();
	}

	void restartAudio() {
		System.out.println("\n[Restarted: " + audioFile.getName() + "]");
		audioClip.setMicrosecondPosition(0); // resets to start of audio file
	}

	void exitPlayer() {
		System.out.println("\n[Exited Music Player!]");
		audioClip.close();
		userInput.close();
	}

}

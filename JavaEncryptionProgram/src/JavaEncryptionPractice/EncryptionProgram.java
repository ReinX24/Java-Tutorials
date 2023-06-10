package JavaEncryptionPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class EncryptionProgram {

	// Variables that we will be using in our program
	private Scanner userInput;
	private ArrayList<Character> charList;
	private ArrayList<Character> shuffledList;
	private char myChar;
	private char[] myCharArr;

	public EncryptionProgram() {

		// Finish instantiating our variables
		userInput = new Scanner(System.in);
		charList = new ArrayList<Character>();
		shuffledList = new ArrayList<Character>();

		newKey();
		encryptionMenu();

	}

	public void encryptionMenu() {

		while (true) {

			System.out.println("[Encryption Program]");
			System.out.println("[N] - New Key");
			System.out.println("[G] - Get Key");
			System.out.println("[E] - Encrypt Message");
			System.out.println("[D] - Decrypt Message");
			System.out.println("[X] - Exit Message");
			System.out.print("> ");
			char userResponse = Character.toUpperCase(userInput.next().charAt(0));

			switch (userResponse) {

			case 'N':
				newKey();
				break;

			case 'G':
				getKey();
				break;

			case 'E':
				encryptMessage();
				break;

			case 'D':
				decryptMessage();
				break;

			case 'X':
				exitEncryptionProgram();
				break;

			}
		}

	}

	public void newKey() {
		myChar = ' '; // where we will hold each char
		charList.clear();
		shuffledList.clear();

		for (int i = 32; i < 127; i++) {
			charList.add(myChar++);
		}

		shuffledList = new ArrayList<Character>(charList); // copying charList to shuffledList
		Collections.shuffle(shuffledList);
		System.out.println("[A new key has been generated!]");

	}

	public void getKey() {

		System.out.println("Key: ");

		for (int i = 0; i < charList.size(); i++) {
			System.out.print(charList.get(i));
		}
		System.out.println();
		for (int i = 0; i < shuffledList.size(); i++) {
			System.out.print(shuffledList.get(i));
		}
		System.out.println();

	}

	// TODO: finish encrypt message method
	public void encryptMessage() {

	}

	// TODO: finish decrypt message method
	public void decryptMessage() {

	}

	public void exitEncryptionProgram() {
		System.out.println("[Encryption Program Exited!]");
		System.exit(0);
	}

}

import java.util.*;

public class EncryptionProgram {

	private Scanner userInput;
	private ArrayList<Character> charList;
	private ArrayList<Character> shuffledList;
	private char myChar;
	private char[] myLetters;

	EncryptionProgram() {

		// Finish instantiating some variables that we will be using for our program
		userInput = new Scanner(System.in);
		charList = new ArrayList<Character>();
		shuffledList = new ArrayList<Character>();
		myChar = ' ';

		newKey();
		askQuestion();
	}

	private void askQuestion() {
		while (true) {
			System.out.println("****************************************************");
			System.out.println("What do you want to do?");
			System.out.println("(N)ewKey | (G)etKey | (E)ncrypt | (D)ecrypt | (Q)uit");
			System.out.print(">");
			char userResponse = Character.toUpperCase(userInput.next().charAt(0));

			switch (userResponse) {

			case 'N':
				newKey();
				break;

			case 'G':
				getKey();
				break;

			case 'E':
				encryptText();
				break;

			case 'D':
				decryptText();
				break;

			case 'Q':
				quitProgram();
				break;

			default:
				System.out.println("Not a valid answer!");
				break;

			}

		}
	}

	private void newKey() {

		myChar = ' ';
		charList.clear();
		shuffledList.clear();

		// adding symbols between ASCII of space and tilde (~) to charList
		for (int i = 32; i < 127; i++) {
			charList.add(Character.valueOf(myChar)); // add myChar to charList
			myChar++; // add myChar value, next ASCII value
		}

		shuffledList = new ArrayList<Character>(charList); // copying charList to shuffledList
		Collections.shuffle(shuffledList); // shuffles our shuffledList
		System.out.println("*A new key has been generated*");

	}

	private void getKey() {
		// Printing the contents of our shuffledList
		System.out.println("Key: ");
		// Non shuffled charList
		for (Character eachCharacter : charList) {
			System.out.print(eachCharacter);
		}
		System.out.println();
		// shuffledList of charList
		for (Character eachCharacter : shuffledList) {
			System.out.print(eachCharacter);
		}
		System.out.println();
	}

	private void encryptText() {
		userInput.nextLine(); // to fix formatting before typing in text
		System.out.println("Enter a message to be encrypted: ");
		String userMessage = userInput.nextLine();

		myLetters = userMessage.toCharArray(); // converts userMessage into a char array

		for (int i = 0; i < myLetters.length; i++) {
			for (int j = 0; j < charList.size(); j++) {
				// check if the element in myLetters is similar to one in charList
				if (myLetters[i] == charList.get(j)) {
					// replace the char in myLetters with the one in shuffledList
					myLetters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		// Printing encrypted message
		System.out.println("Encrypted message: ");
		for (char eachChar : myLetters) {
			System.out.print(eachChar);
		}
		System.out.println();
	}

	private void decryptText() {
		userInput.nextLine(); // to fix formatting before typing in text
		System.out.println("Enter a message to be decrypted: ");
		String userMessage = userInput.nextLine();

		myLetters = userMessage.toCharArray(); // converts userMessage into a char array

		for (int i = 0; i < myLetters.length; i++) {
			for (int j = 0; j < shuffledList.size(); j++) {
				// check if the element in myLetters is similar to one in shuffledList
				if (myLetters[i] == shuffledList.get(j)) {
					// replace the char in myLetters with the one in charList (non shuffled key)
					myLetters[i] = charList.get(j);
					break;
				}
			}
		}
		// Printing encrypted message
		System.out.println("Decrypted message: ");
		for (char eachChar : myLetters) {
			System.out.print(eachChar);
		}
		System.out.println();
	}

	private void quitProgram() {
		System.out.println("Thank you, have a nice day bro!");
		System.exit(0);
	}

}

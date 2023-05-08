import java.util.*;

public class EncryptionProgram {

	private Scanner userInput;
	private Random myRand;
	private ArrayList<Character> charList;
	private ArrayList<Character> shuffledList;
	private char myChar;
	private String myLine;
	private char[] myLetters;
	private char[] mySecretLetters;

	EncryptionProgram() {

		// Finish instantiating some variables that we will be using for our program
		userInput = new Scanner(System.in);
		myRand = new Random();
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
		
		// adding symbols between ASCII of space and tilde (~)
		for (int i = 32; i < 127; i++) {
			charList.add(Character.valueOf(myChar));
			myChar++;
		}
		
		shuffledList = new ArrayList<Character>(charList); // copying charList to shuffledList
		Collections.shuffle(shuffledList); // shuffles our shuffledList
		System.out.println("*A new key has been generated*");
		
	}

	private void getKey() {

	}

	private void encryptText() {

	}

	private void decryptText() {

	}

	private void quitProgram() {
		System.exit(0);
	}

}

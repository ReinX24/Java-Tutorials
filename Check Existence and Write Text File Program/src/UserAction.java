import java.util.Scanner;

public class UserAction {
	/* Variables that we will be needing for our program */
	static Scanner userInput = new Scanner(System.in);
	static int userAction;
	static String fileName;

	public static void main(String[] args) {
		/* Continually loops until the program until user terminates it */
		do {
			askAction(); // asks the user for an action
			evaluateAction(); // checks the user's action
		} while (userAction != 3);
	}

	/* Method that shows a menu of available actions & asks for user input */
	static void askAction() {
		System.out.println("\n[Check File & Write File Program]\n");
		System.out.println("[1] Check File Exists");
		System.out.println("[2] Write File");
		System.out.println("[3] Terminate Program");
		System.out.print("\nEnter number: ");
		userAction = userInput.nextInt();
		userInput.nextLine(); // nextLine before entering a String after entering a number
	}

	/* Method that validates & evaluates the user's entered action */
	static void evaluateAction() {
		switch (userAction) {
		case 1:
			checkFile();
			break;
		case 2:
			writeFile();
			break;
		case 3:
			endProgram();
			break;
		default:
			System.out.println("[Invalid Input!]");
			break;
		}
	}

	/* Method that asks for fileName */
	static void askFileName() {
		System.out.println("\n[File name must end with (.txt)]");
		System.out.print("Enter file name: ");
		fileName = userInput.nextLine();
	}

	/* Method that checks if the file exists */
	static void checkFile() {
		// Ask for file name
		askFileName();
		// Create a CheckFileExists Object
		CheckFileExists checkFile = new CheckFileExists();
		// Check if file exists
		checkFile.scanForFile(fileName);
	}

	/* Method that prompts the user to write text for a file */
	static void writeFile() {
		// Ask for file name
		askFileName();
		// Create a WriteFile Object
		WriteFile writeFile = new WriteFile();
		// Start writing text in writeFile object
		writeFile.startWrite(fileName);
	}

	static void endProgram() {
		// Message that says the program is terminated & asks the user to refresh
		// project folder
		System.out.println("[Program Terminated!]");
		System.out.println("[Please Refresh Folder For Changes To Appear]");
	}

}

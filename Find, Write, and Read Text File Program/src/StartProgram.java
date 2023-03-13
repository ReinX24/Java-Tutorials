import java.util.Scanner;

public class StartProgram {

	// Variables that we will be using for our program
	Scanner userInput = new Scanner(System.in);
	int userChoice;
	String fileName;
	boolean validFileExtension;

	// Method that starts the program
	void initiateProgram() {
		// Loops until the user chooses to terminate program
		do {
			askUserChoice();
			evaluateUserChoice();
		} while (userChoice != 4);
	}

	// Asks the user for a number to execute an action
	void askUserChoice() {
		System.out.println("\n[Text File Finder, Writer, and Reader]\n");
		System.out.println("[1] : Find Text File");
		System.out.println("[2] : Write Text File");
		System.out.println("[3] : Read Text File");
		System.out.println("[4] : Terminate Program");
		System.out.print("\nEnter a number: ");
		while (!userInput.hasNextInt()) {
			userInput.nextLine();
			System.out.println("\n[Invalid Input! Please Enter A Number]");
			System.out.println("\n[Text File Finder, Writer, and Reader]\n");
			System.out.println("[1] : Find Text File");
			System.out.println("[2] : Write Text File");
			System.out.println("[3] : Read Text File");
			System.out.println("[4] : Terminate Program");
			System.out.print("\nEnter a number: ");
		}
		this.userChoice = userInput.nextInt();
		userInput.nextLine();
	}

	// Asks the user for a file name
	void askFileName() {
		System.out.print("\nEnter file name: ");
		this.fileName = userInput.nextLine();
	}

	// Check file extension, file names should end with .txt
	void checkFileExtenstion() {
		if (this.fileName.length() > 4) {
			String fileExtenstion = this.fileName.substring(this.fileName.length() - 4);
			if (fileExtenstion.equals(".txt")) {
				System.out.println("\n[File Extension Verified]");
				validFileExtension = true;
			} else {
				System.out.println("\n[File Name should end with \".txt\"]");
				validFileExtension = false;
			}
		} else {
			System.out.println("\n[File Name should end with \".txt\"]");
		}
	}

	// Evaluates the entered number of the user
	void evaluateUserChoice() {
		switch (userChoice) {

		case 1:
			askFileName();
			checkFileExtenstion();
			if (validFileExtension) {
				findFile();
			}
			break;

		case 2:
			askFileName();
			checkFileExtenstion();
			if (validFileExtension) {
				writeFile();
			}
			break;

		case 3:
			askFileName();
			checkFileExtenstion();
			if (validFileExtension) {
				readFile();
			}
			break;

		case 4:
			terminateProgram();
			break;

		default:
			System.out.println("\n[Invalid Input! Enter A Valid Number]");
			break;
		}
	}

	// Creates a FindFile object, finds a txt file
	void findFile() {
		FindFile findUserFile = new FindFile(this.fileName);
		findUserFile.showResult();
	}

	// Creates a WriteFile object, writes a txt file
	void writeFile() {
		WriteFile writeUserFile = new WriteFile(this.fileName);
		writeUserFile.showResult();
	}

	// Creates a ReadFile object, prints file contents on console
	void readFile() {
		ReadFile readUserFile = new ReadFile(this.fileName);
		readUserFile.showResult();
	}

	// Prints a message that tells the user that the program is terminated
	void terminateProgram() {
		System.out.println("\n[Program Terminated]");
	}

}

import java.util.Scanner;

public class StartProgram {

	Scanner userInput = new Scanner(System.in);
	int userChoice;
	String fileName;

	void initiateProgram() {
		do {
			askUserChoice();
			evaluateUserChoice();
		} while (userChoice != 4);
	}

	void askUserChoice() {
		System.out.println("\n[Text File Finder, Writer, and Reader]\n");
		System.out.println("[1] : Find Text File");
		System.out.println("[2] : Write Text File");
		System.out.println("[3] : Read Text File");
		System.out.println("[4] : Terminate Program");
		System.out.print("\nEnter a number: ");
		this.userChoice = userInput.nextInt();
		userInput.nextLine();
	}

	void askFileName() {
		System.out.print("\nEnter file name: ");
		fileName = userInput.nextLine();
	}

	void evaluateUserChoice() {
		switch (userChoice) {

		case 1:
			askFileName();
			findFile();
			break;

		case 2:
			askFileName();
			writeFile();
			break;

		case 3:
			askFileName();
			readFile();
			break;

		case 4:
			terminateProgram();
			break;

		default:
			System.out.println("\n[Invalid Input!]");
			break;
		}
	}

	void findFile() {
		FindFile findUserFile = new FindFile(this.fileName);
		findUserFile.showResult();
	}

	void writeFile() {
		WriteFile writeUserFile = new WriteFile(this.fileName);
		writeUserFile.showResult();
	}

	void readFile() {
		ReadFile readUserFile = new ReadFile(this.fileName);
		readUserFile.showResult();
	}

	void terminateProgram() {
		System.out.println("\n[Program Terminated]");
	}

}

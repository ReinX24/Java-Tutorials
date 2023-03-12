import java.util.Scanner;

public class StartProgram {

	Scanner userInput = new Scanner(System.in);
	int userChoice;
	String fileName;

	void initiateProgram() {
		askUserChoice();
		askFileName();
		evaluateUserChoice();
	}

	void askUserChoice() {
		System.out.println("\n[Text File Finder, Writer, and Reader]\n");
		System.out.println("[1] : Find Text File");
		System.out.println("[2] : Write Text File");
		System.out.println("[3] : Read Text File");
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
			findFile();
			break;
		case 2:
			writeFile();
			break;

		case 3:
			readFile();
			break;

		default:
			System.out.println("[Invalid Input!]");
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
//		ReadFile readUserFile = new ReadFile(this.fileName);
//		readUserFile.showResult();
	}

}

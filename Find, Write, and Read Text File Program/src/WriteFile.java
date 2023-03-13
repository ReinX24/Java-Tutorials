import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {

	FileWriter writeFile;
	Scanner userInput = new Scanner(System.in);
	int lineAmount;

	// Instantiates our FileWriter class
	WriteFile(String fileName) {
		try {
			writeFile = new FileWriter(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Calls all the methods in the class
	void showResult() {
		askLineAmount();
		writeLines();
		askRefresh();
	}

	// Asks the user how much lines would you like to write
	void askLineAmount() {
		System.out.print("\nHow many lines would you like to enter: ");
		lineAmount = userInput.nextInt();
		userInput.nextLine();
	}

	// Asks the user to insert the contents of their lines
	void writeLines() {
		while (lineAmount > 0) {
			System.out.println("\nLines remaining: " + this.lineAmount);
			System.out.print("Enter text: ");
			String addText = userInput.nextLine();
			if (lineAmount > 1) {
				try {
					writeFile.append(addText + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					writeFile.append(addText);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			lineAmount--;
		}
		try {
			writeFile.close(); // remember to always close fileWriter at the end
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Asks the user to refresh the program
	void askRefresh() {
		System.out.println("\n[Writing Process Complete!]");
		System.out.println("[Terminate Program and refresh Project Folder to see changes]");
	}

}

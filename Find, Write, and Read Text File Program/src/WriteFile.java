import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {

	FileWriter writeFile;
	Scanner userInput = new Scanner(System.in);
	int lineAmount;

	WriteFile(String fileName) {
		try {
			writeFile = new FileWriter(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void showResult() {
		askLineAmount();
		writeLines();
	}

	void askLineAmount() {
		System.out.print("How many lines would you like to enter: ");
		lineAmount = userInput.nextInt();
		userInput.nextLine();
	}

	void writeLines() {
		while (lineAmount > 0) {
			System.out.println("Lines remaining: " + this.lineAmount);
			System.out.println("Enter text: ");
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

	void askRefresh() {
		System.out.println("[Writing Process Complete!]");
		System.out.println("[Please Refresh Project Folder]");
	}

}

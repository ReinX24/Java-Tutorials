package practiceFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteReadMain {

	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("[File Writer & Reader Program]");
		System.out.println("[1] - Write File");
		System.out.println("[2] - Read File");
		System.out.print("\nEnter number: ");
		int userChoice = userInput.nextInt();
		userInput.nextLine();
		// ^ remember to put this when asking for a String after asking for an int

		System.out.print("Enter file name: ");
		String fileName = userInput.nextLine();

		switch (userChoice) {
		case 1:
			writeFile(fileName);
			break;
		case 2:
			readFile(fileName);
			break;
		default:
			System.out.println("[Invalid Input]");
			break;
		}
	}

	public static void writeFile(String fileName) {
		try {
			FileWriter writeFile = new FileWriter(fileName);
			int lineAmount = 5;
			while (lineAmount > 0) {
				System.out.println("Remaining lines: " + lineAmount);
				System.out.print("Enter text to add: ");
				String addLine = userInput.nextLine();
				writeFile.append(addLine);
				if (lineAmount > 1) {
					writeFile.append("\n");
				}
				lineAmount--;
			}
			writeFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readFile(String fileName) {

		try {
			FileReader readFile = new FileReader(fileName);
			int byteCode = readFile.read();
			while (byteCode != -1) {
				System.out.print((char) byteCode);
				byteCode = readFile.read();
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	FileReader readFile;

	// Instantiate our FileReader object
	ReadFile(String fileName) {
		try {
			readFile = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.out.println(); // space before printing error message in readFileLoop
		}
	}

	// Shows the result of the readFileLoop method
	void showResult() {
		readFileLoop();
	}

	// Reads each line within the text file
	void readFileLoop() {
		if (readFile != null) { // checks if the readFile is not null
			try {
				// Assigns first character's byte value to a variable
				int byteValue = readFile.read();
				System.out.println("--------------------");
				// Reads each character in the text file
				while (byteValue != -1) {
					System.out.print((char) byteValue); // reads per character
					byteValue = readFile.read(); // goes to the next character
				}
				System.out.println("\n--------------------"); // for console formatting purposes
				readFile.close(); // closing our FileReader
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("[File Not Found!]"); // if the file does not exist
		}

	}

}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	FileReader readFile;

	ReadFile(String fileName) {
		try {
			readFile = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	void showResult() {
		readFileLoop();
	}

	void readFileLoop() {
		try {
			int byteValue = readFile.read();
			while (byteValue != -1) {
				System.out.print((char) byteValue); // reads per character
				byteValue = readFile.read();
			}
			readFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

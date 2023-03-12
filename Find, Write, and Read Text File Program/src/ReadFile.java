import java.io.FileNotFoundException;
import java.io.FileReader;

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
		
	}

}

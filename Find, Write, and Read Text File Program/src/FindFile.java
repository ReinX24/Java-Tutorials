import java.io.File;

public class FindFile {

	File checkFile;

	// Instantiating our File object
	FindFile(String fileName) {
		this.checkFile = new File(fileName);
	}

	// Method that returns the result
	void showResult() {
		checkExists();
	}

	// Checks if the text file exists,
	void checkExists() {
		if (checkFile.exists()) {
			showFileInfo();
		} else {
			System.out.println("\n[File Not Found!]");
		}
	}

	// Prints text file information such as file name & file path in the computer
	void showFileInfo() {
		System.out.println("\n[File Found!]");
		System.out.println("Name: " + checkFile.getName());
		System.out.println("Location: " + checkFile.getAbsolutePath());
	}

}

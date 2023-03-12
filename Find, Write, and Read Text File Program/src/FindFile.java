import java.io.File;

public class FindFile {

	File checkFile;

	FindFile(String fileName) {
		this.checkFile = new File(fileName);
	}

	void showResult() {
		checkExists();
	}

	void checkExists() {
		if (checkFile.exists()) {
			showFileInfo();
		} else {
			System.out.println("\n[File Not Found!]");
		}
	}

	void showFileInfo() {
		System.out.println("\n[File Found!]");
		System.out.println("Name: " + checkFile.getName());
		System.out.println("Location: " + checkFile.getAbsolutePath());
	}

}

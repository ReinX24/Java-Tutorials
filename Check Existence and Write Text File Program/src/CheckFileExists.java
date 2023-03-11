import java.io.File;

public class CheckFileExists {

	public void scanForFile(String fileName) {
		File checkFile = new File(fileName);
		if (checkFile.exists()) {
			System.out.println("\n" + checkFile.getName() + " exists!");
			System.out.println("Located at: " + checkFile.getAbsolutePath());
		} else {
			System.out.println("\nFile not found!");
		}
	}

}

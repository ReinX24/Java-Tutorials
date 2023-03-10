package practiceJavaFileClass;

import java.io.File;

public class FileClassPractice {

	public static void main(String[] args) {

		/* Creating a File object */
		File fileClass = new File("text_file.txt");

		/* Checking if the file in the File object exists */
		if (fileClass.exists()) {
			System.out.println("File exists!");
			System.out.println(fileClass.getPath());
			System.out.println(fileClass.getAbsolutePath());
			System.out.println(fileClass.isFile());
			fileClass.delete(); // deletes the text_file.txt
		} else { // if the file does not exist
			System.out.println("File not found!");
		}

		/* Finding a File outside of the project folder */
		File otherFile = new File("/home/rein/Downloads/text_file.txt"); // we need to put full file path & file name

		if (otherFile.exists()) {
			System.out.println("[File" + otherFile.getName() + " found!");
			System.out.println("File Path: " + otherFile.getPath());
			System.out.println("Absolute Path: " + otherFile.getAbsolutePath());
			System.out.println("Is a File: " + otherFile.isFile());
		} else {
			System.out.println("[File " + otherFile.getName() + " not found!]");
		}

	}

}

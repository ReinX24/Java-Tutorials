import java.io.File;

public class FileClassMain {

	public static void main(String[] args) {

		/* File : an abstract representation of file and directory pathnames */

		// Creating an instance of the File class
		File checkFile = new File("text_file.txt"); // put file name in parenthesis, include file extension

		// Checking if the current project folder has a certain file
		if (checkFile.exists()) { // if the file is found, execute code block below
			System.out.println("That file exists! :D");
			System.out.println(checkFile.getPath()); // shows file path
			System.out.println(checkFile.getAbsolutePath()); // shows full file path in computer
			System.out.println(checkFile.isFile()); // checks if the file is a file and not a folder
			checkFile.delete(); // deletes text file
		} else {
			System.out.println("That file does not exist! :(");
		}

		// What if the file is placed somewhere else? We list the fill file path
		File checkPdfExist = new File("/home/rein/Downloads/thinkjava.pdf"); // we need the full file path
		if (checkPdfExist.exists()) {
			System.out.println("[PDF exists!]");
			System.out.println(checkPdfExist.getPath());
			System.out.println(checkPdfExist.getAbsolutePath());
		} else {
			System.out.println("[PDF does not exist!]");
		}
	}

}

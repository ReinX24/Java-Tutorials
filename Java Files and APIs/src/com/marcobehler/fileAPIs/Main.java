package com.marcobehler.fileAPIs;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

	public static void main(String[] args) {

		// Using the Paths API to refer to files
		Path filePath = Path
				.of("/home/rein/repos/Java-Tutorials/Java Files and APIs/src/com/marcobehler/fileAPIs/textFile.txt");
//		System.out.println(filePath);

//		System.out.println(Files.exists(filePath));

		filePath = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
				"marcobehler", "fileAPIs").resolve("textFile.txt");
		System.out.println(filePath);
		// These do not confirm if a file exists or not, to check if a file exists, we
		// will be using methods from the java.nio.file.Files class

		// Checking if the file exists, returns either true or false
		System.out.println("exists = " + Files.exists(filePath));

		// Getting the last modified date of a file
		try {
			System.out.println("lastModifiedTime = " + Files.getLastModifiedTime(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Path mismatchTextFile = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
				"marcobehler", "fileAPIs").resolve("mismatch.txt");
		try {
			long mismatchIndex = Files.mismatch(filePath, mismatchTextFile);
			System.out.println("mismatch = " + mismatchIndex); // prints 20
			// This means that the files match until the 20th index (starting from 0 at the
			// first character until the index where the mismatch happens)
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("owner = " + Files.getOwner(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

package com.marcobehler.creatingFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		try {

			Path filePath = Path.of(
					"/home/rein/repos/Java-Tutorials/Java Files and APIs/src/com/marcobehler/fileAPIs/textFile.txt");
			Path newDirectory = Files.createDirectories(filePath.getParent().resolve("testFolder"));
			System.out.println("newDirectory = " + newDirectory); // path to newDirectory

			// .resolve references the directory and creates a file with the file name in
			// its parameters
			Path newFile = Files.createFile(newDirectory.resolve("emptyFile.txt"));
			System.out.println("newFile = " + newFile); // path to newFile

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

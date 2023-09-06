package com.marcobehler.tempFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		try {
			Path filePath = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
					"marcobehler", "fileAPIs").resolve("textFile.txt");

			// Creating a temp file at a default temporary-file directory
			// https://stackoverflow.com/questions/1924136/environment-variable-to-control-java-io-tmpdir
			Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".jpg");
			System.out.println("tempFile1 = " + tempFile1);

			// Creating a temp file at a specified folder
			Path tempFile2 = Files.createTempFile(filePath.getParent(), "somePrefixOrNull", ".jpg");
			System.out.println("tempFile2 = " + tempFile2);

			// Creating a custom temp directory
			Path tmpDirectory = Files.createTempDirectory("prefix");
			System.out.println("tmpDirectory = " + tmpDirectory);

			/*
			 * Note: Temp files, contrary to popular belief, do not delete themselves. You
			 * have to make sure to explicitly delete them, when creating them in unit tests
			 * or when running in production.
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

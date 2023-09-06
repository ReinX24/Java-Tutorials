package com.marcobehler.posixPermissions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Path filePath = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
				"marcobehler", "fileAPIs").resolve("textFile.txt");
		try {
			Set<PosixFilePermission> filePermissions = Files.getPosixFilePermissions(filePath);
			System.out.println("permissions = " + filePermissions);
			// Prints the file permissions of this file in a unix system (linux or macOS)
		} catch (UnsupportedOperationException e) {
			System.err.println("Looks like you're not running on a posix file system");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

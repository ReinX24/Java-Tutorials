package com.javapoint.files;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CanonicalFile {

	public static void main(String[] args) {
		String filePath = "";
		boolean fileExists = false;

		Path packagePath = Paths.get("src", "com", "javapoint", "files");
		String fileOneDir = packagePath.toAbsolutePath().resolve("fileOne.txt").toString();

		try {

			File fileOne = new File(fileOneDir);
			fileOne.createNewFile();
			System.out.println(fileOneDir);

			File fileTwo = fileOne.getCanonicalFile();
			System.out.println(fileTwo);

			fileExists = fileTwo.exists();

			filePath = fileTwo.getAbsolutePath();

			if (fileExists) {
				System.out.println(filePath + " exists? " + fileExists);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

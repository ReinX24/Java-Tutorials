package com.geeksforgeeks.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class CheckIfFileExists {

	public static void main(String[] args) {

		Path thisFolderPath = Paths.get("testFolder", "textFile.txt");
		Path absoluteFolderPath = thisFolderPath.toAbsolutePath();

		File myFile = new File(absoluteFolderPath.toString());

		// Using File methods on our File object
		System.out.println("File name: " + myFile.getName());
		System.out.println("Path: " + myFile.getPath());
		System.out.println("Absolute path: " + myFile.getAbsolutePath());
		System.out.println("Parent: " + myFile.getParent());
		System.out.println("Exists: " + myFile.exists());

		if (myFile.exists()) {
			System.out.println("Is writable: " + myFile.canWrite());
			System.out.println("Is readable: " + myFile.canRead());
			System.out.println("Is a directory: " + myFile.isDirectory());
			System.out.println("File size in bytes: " + myFile.length());
		}

	}

}

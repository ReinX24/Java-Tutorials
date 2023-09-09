package com.geeksforgeeks.file;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;

public class ListFiles {

	public static void main(String[] args) {

		Path folderPathParent = Paths.get("src", "com", "geeksforgeeks");
		Path folderPathChild = Paths.get("file");

		Path absParent = folderPathParent.toAbsolutePath();
		
		File myFile = new File(absParent.toString(), folderPathChild.toString());

		System.out.println(myFile);
		System.out.println(myFile.isDirectory());
		System.out.println(myFile.isFile());
		
		if (myFile.exists()) {
			String[] dirContents = myFile.list();
			
			for (int i = 0; i < dirContents.length; i++) {
				File currentFile = new File(dirContents[i]);
				System.out.println(currentFile);
			}
			
			System.out.println("No of entries in this directory: " + dirContents.length);
			
		} else {
			System.out.println("Directory not found");
		}

	}

}

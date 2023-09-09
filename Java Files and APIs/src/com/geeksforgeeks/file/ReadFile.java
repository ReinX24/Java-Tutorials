package com.geeksforgeeks.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {

		Path filePath = Paths.get("src", "com", "geeksforgeeks", "file").resolve("output.txt");

		File myFile = new File(filePath.toAbsolutePath().toString());

		FileReader fileReader = null;
		int eachByte;

		// This reads our file through each character and each character breaks into a
		// new line
		try {
			fileReader = new FileReader(myFile);
			while ((eachByte = fileReader.read()) != -1) {
				System.out.println((char) eachByte);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

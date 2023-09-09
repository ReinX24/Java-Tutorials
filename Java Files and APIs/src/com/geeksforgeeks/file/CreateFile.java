package com.geeksforgeeks.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) {

		Path filePath = Paths.get("src", "com", "geeksforgeeks", "file").resolve("output.txt");

		File myFile = new File(filePath.toAbsolutePath().toString());

		try {
			FileWriter fileWriter = new FileWriter(myFile);
			fileWriter.append("I am writing to this file!\n");
			fileWriter.append("Thanks geeksforgeeks.com!");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

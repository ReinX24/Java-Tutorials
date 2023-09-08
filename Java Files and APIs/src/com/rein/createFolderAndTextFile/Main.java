package com.rein.createFolderAndTextFile;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		// Where we will be storing our folder
		Path projectFolderPath = Paths.get("");
		String absolutePath = projectFolderPath.toAbsolutePath().toString();

		File testFolder = new File(absolutePath + "/testFolder");
//		testFolder.mkdir();
		// Creating a file in our test folder
		File myFile = new File(testFolder.getAbsolutePath() + "/textFile.txt");
//		try {
//			myFile.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// Writing to our textFile
		try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {

			// Checking if the text file has text already
			if (br.readLine() != null) {
				System.out.println("File has text already!");
			} else {
				FileWriter myWriter = new FileWriter(myFile);
				if (myFile.length() != 0) {
					System.out.println("File has text already!");
				} else {
					System.out.println("Writing to file!");
					myWriter.write("I am writing to this text file!\n");
					myWriter.write("- Rein");
					myWriter.flush(); // makes sure everything is transferred to the file
					myWriter.close(); // closes file writer
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

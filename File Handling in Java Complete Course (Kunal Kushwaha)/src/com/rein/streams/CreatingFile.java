package com.rein.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingFile {

	public static void main(String[] args) {

		Path filePath = Paths.get("src", "com", "rein", "streams").resolve("createdFile.txt").toAbsolutePath();
		File programFile = new File(filePath.toString());

		// Creating a file
		try {
			programFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Writing to our file
		try {
			FileWriter fileWriter = new FileWriter(programFile);
			fileWriter.write("I am writing to this file!\n");
			fileWriter.write("Hooray!");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reading from file
		try {

			BufferedReader bufferedReader = new BufferedReader(new FileReader(programFile));
			while (bufferedReader.ready()) {
				System.out.println(bufferedReader.readLine());
			}
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Deleting our file
		if (programFile.delete()) {
			System.out.println(programFile.getName() + " is deleted!");
		}
		

	}

}

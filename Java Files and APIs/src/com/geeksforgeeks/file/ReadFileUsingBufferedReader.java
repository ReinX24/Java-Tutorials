package com.geeksforgeeks.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileUsingBufferedReader {

	public static void main(String[] args) {

		Path filePath = Paths.get("src", "com", "geeksforgeeks", "file").resolve("output.txt");

		File myFile = new File(filePath.toAbsolutePath().toString());

		BufferedReader bufferedReader = null;
		String eachLine;

		try {
			bufferedReader = new BufferedReader(new FileReader(myFile));
			while ((eachLine = bufferedReader.readLine()) != null) {
				System.out.println(eachLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

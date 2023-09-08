package com.marcobehler.readingWritingListingMovingDeletingFiles;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		// Creating a file inside this folder
		Path folderPath = Paths.get("src", "com", "marcobehler", "readingWritingListingMovingDeletingFiles");
		String folderPathStr = folderPath.toAbsolutePath().toString();

		File textFile = new File(folderPathStr + "/textFile.txt");
		System.out.println("\nCreating a text file");
		try {
			textFile.createNewFile();
			System.out.println("File created!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Writing to our text file
		System.out.println("\nReading a text file");
		try {
			FileWriter myWriter = new FileWriter(textFile);
			myWriter.append("I am writing text to this text file!\n");
			myWriter.append("Now I will be reading the text inside!");
			myWriter.flush();
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reading our text file
		try {
			BufferedReader myReader = new BufferedReader(new FileReader(textFile));
			String eachLine;
			while ((eachLine = myReader.readLine()) != null) {
				System.out.println(eachLine);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\nFiles in this directory");
		// Listing files in a directory
		try (var files = Files.walk(folderPath)) {
			files.forEach(System.out::println);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Listing only text files in a directory
		System.out.println("\nText files in this directory");
		try (var files = Files.newDirectoryStream(folderPath, "*.txt")) {
			files.forEach(System.out::println);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Moving files from one folder to another
		System.out.println("\nMoving text files from one directory to another");
		Path textFilePath = textFile.toPath();
		Path newFolderPath = folderPath.resolve("moveFilesHere");
		try {
			// We will be needing the path of our text file and the new path of the file
			// with the file name at the end
			Files.move(textFilePath, newFolderPath.resolve(textFilePath.getFileName().toString()));
		} catch (IOException e) {
			System.out.println(e.toString());
		}

		// Deleting files from a directory
		System.out.println("\nCreating a temp file, moving it to this folder, and deleting it");
		try {
			Path tempFile = Files.createTempFile("temp", "txt");
			System.out.println(tempFile.getFileName() + " created!");
			Files.move(tempFile, folderPath.resolve(tempFile.getFileName().toString()));
			Files.delete(folderPath.resolve(tempFile.getFileName().toString()));
			System.out.println(tempFile.getFileName() + " deleted!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

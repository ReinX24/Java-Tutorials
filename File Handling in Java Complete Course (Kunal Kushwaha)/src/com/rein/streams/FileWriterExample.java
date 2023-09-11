package com.rein.streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterExample {

	public static void main(String[] args) {

		Path filePath = Paths.get("src", "com", "rein", "streams").resolve("testFile.txt").toAbsolutePath();
		File programFile = new File(filePath.toString());

		try (FileWriter fileWriter = new FileWriter(programFile, true)) {
			// adding true appends the file instead of replacing contents

//			fileWriter.write("I like programming in Java specifically.\n");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

package com.marcobehler.writingAndReadingFiles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

	public static void main(String[] args) {

		try {

			Path filePath = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
					"marcobehler", "writingAndReadingFiles");

			Path utfFile = Files.createTempFile(filePath, "utf", ".txt"); // UTF8
			Files.writeString(utfFile, "This is my String");
			System.out.println("utfFile = " + utfFile);

//			Path isoFile = Files.createTempFile(filePath, "iso", ".txt");
//			// Making that we will be writing a utf8 file
//			Files.writeString(isoFile, "This is my String", StandardCharsets.ISO_8859_1); // otherwise == utf8
//			System.out.println("isoFile = " + isoFile);
//
//			Path byteFile = Files.createTempFile(filePath, "byte", ".txt");
//			Files.write(byteFile, "This is my String".getBytes(StandardCharsets.ISO_8859_1));
//			System.out.println("byteFile = " + byteFile);

			// Overriding existing temp files
			Path anotherUtf8File = Files.createTempFile(filePath, "utf", ".txt");
			Files.writeString(anotherUtf8File, "Short String!", StandardCharsets.UTF_8,
					StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
			System.out.println("anotherUtf8File = " + anotherUtf8File);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

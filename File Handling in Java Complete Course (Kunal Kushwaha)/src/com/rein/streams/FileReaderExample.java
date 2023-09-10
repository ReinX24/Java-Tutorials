package com.rein.streams;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReaderExample {
	
	public static void main(String[] args) {
		
		Path projectPath = Paths.get("src", "com", "rein", "streams").resolve("textFile.txt").toAbsolutePath();
		File textFile = new File(projectPath.toString());
		
		try (FileReader fileReader = new FileReader(textFile)) {
			
			int fileLetters = fileReader.read();
			
			while (fileReader.ready()) {
				System.out.println((char) fileLetters);
				fileLetters = fileReader.read();
			}
			
			
		} catch (IOException e) {
			e.getMessage();
		}
		
	}

}

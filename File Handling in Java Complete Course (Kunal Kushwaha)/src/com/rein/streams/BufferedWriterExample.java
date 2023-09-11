package com.rein.streams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedWriterExample {
	
	public static void main(String[] args) {
		
		Path filePath = Paths.get("src", "com", "rein", "streams").resolve("testFile.txt").toAbsolutePath();
		File programFile = new File(filePath.toString());
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(programFile))) {

			bufferedWriter.write("Writing in this file with a BufferedWriter object.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

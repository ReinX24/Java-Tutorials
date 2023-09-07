package com.marcobehler.writersAndOutputStreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		try {

			// Creating a text file with the utf-8 encoding
			Path filePath = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
					"marcobehler", "writersAndOutputStreams");

			Path utfFile = Files.createTempFile(filePath, "temp", ".txt");
			Files.writeString(utfFile, "This is a String!");
			System.out.println("utfFile = " + utfFile);
			
//			try (BufferedWriter bufferedWriter = Files.newBufferedWriter(utfFile)) {
//				// handle reader
//			}
//			
//			try (OutputStream outStream = Files.newOutputStream(utfFile)){
//			    // handle output stream
//			}
			
			String myStr = Files.readString(utfFile);
			System.out.println("myStr = " + myStr);
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

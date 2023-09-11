package com.rein.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderExample {

	public static void main(String[] args) {

		Path filePath = Paths.get("src", "com", "rein", "streams").resolve("textFile.txt").toAbsolutePath();
		File textFile = new File(filePath.toString());

		// Reading an entire line instead of each char
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile))) {
			
			while (bufferedReader.ready()) {
				System.out.println(bufferedReader.readLine());
			}
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Reading user input using BufferedReader
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			
			System.out.print("Enter text: ");
			System.out.println(bufferedReader.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

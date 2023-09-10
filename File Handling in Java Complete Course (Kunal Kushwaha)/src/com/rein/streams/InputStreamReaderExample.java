package com.rein.streams;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderExample {

	public static void main(String[] args) {

		try (InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
			// This takes letters from the user and then prints each character
			System.out.print("Enter some letters: ");
			int letters = inputStreamReader.read();
			while (inputStreamReader.ready()) {
				System.out.println((char) letters);
				letters = inputStreamReader.read();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}

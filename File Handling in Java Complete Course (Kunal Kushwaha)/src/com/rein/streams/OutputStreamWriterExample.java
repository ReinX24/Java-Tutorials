package com.rein.streams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterExample {

	public static void main(String[] args) {

		try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out)) {
			outputStreamWriter.write("Hello, World!");
			outputStreamWriter.write(97); // this prints into 'a'
			outputStreamWriter.write(10); // new line
			outputStreamWriter.write('A');
			outputStreamWriter.write("\n");
			char[] charArr  = "This is a String about to be converted into a char array".toCharArray();
			outputStreamWriter.write(charArr);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

package com.oceandigital.absoluteCanonicalRelativePath;

import java.io.File;
import java.io.IOException;



public class Main {
	
	public static void main(String[] args) {
		File fileOne = new File("textFile.txt");
		printPaths(fileOne);
		
		File fileTwo = new File("testFolder/textFile.txt");
		printPaths(fileTwo);
		
	}

	private static void printPaths(File paraFile) {
		System.out.println("Absolute Path: " + paraFile.getAbsolutePath());
		try {
			System.out.println("Canonical Path: " + paraFile.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Relative Path: " + paraFile.getPath());
	}

}

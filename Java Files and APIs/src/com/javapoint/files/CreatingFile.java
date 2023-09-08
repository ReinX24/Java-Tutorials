package com.javapoint.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingFile {
	
	public static void main(String[] args) {
		
		try {
			Path packagePath = Paths.get("src", "com", "javapoint", "files");
			String absPath = packagePath.toAbsolutePath().resolve("textfile.txt").toString();
			System.out.println(absPath);
			File myFile = new File(absPath);
			if (myFile.createNewFile()) {
				System.out.println(myFile.getName() + " is created!");
			} else {
				System.out.println(myFile.getName() + " already exists!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

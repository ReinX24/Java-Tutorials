package com.javapoint.files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class ListFiles {
	
	public static void main(String[] args) {
		
		Path packagePath = Paths.get("src", "com", "javapoint", "files");
		Path absPath = packagePath.toAbsolutePath();
		
		File javapointFiles = new File(absPath.toString());
		String[] fileNames = javapointFiles.list();
		for (String eachFile : fileNames) {
			System.out.println(eachFile);
		}
	}

}

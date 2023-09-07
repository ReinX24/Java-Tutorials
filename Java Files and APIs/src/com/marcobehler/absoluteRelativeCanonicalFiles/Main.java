package com.marcobehler.absoluteRelativeCanonicalFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {

		Path srcFolder = Paths.get("./src/com/marcobehler");

		// .normalize() - removes dots
		// .toAbsolutePath() - absolute file of folder in system
		Path absPath = srcFolder.normalize().toAbsolutePath();
		System.out.println(absPath);
		System.out.println("srcFolder.isAbsolute() = " + srcFolder.isAbsolute());
		System.out.println("absPath.siAbsolute() = " + absPath.isAbsolute());
		// ^ needs to start from src for this to point to the src folder of the project
		// folder this is inside of
		
		Path relativizedPath = Paths.get(srcFolder.toString()).relativize(absPath);
		System.out.println(relativizedPath);

		// Checking if the srcFolder does exits
//		try (var fileDir = Files.list(absPath)) {
//			fileDir.forEach(System.out::println);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

}

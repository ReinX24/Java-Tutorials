package com.marcobehler.movingDeletingListingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		try {
			Path filePath = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
					"marcobehler", "movingDeletingListingFiles");
			Path utfFile = Files.createTempFile("some", "txt");

			// Moving from one folder to another
			Files.move(utfFile, filePath.resolve(utfFile.getFileName().toString()));

			// Writing to our temp file
			Files.writeString(filePath.resolve(utfFile.getFileName().toString()),
					"This is a temp file that will be deleted!");

			// Reading temp file contents
			String myStr = Files.readString(filePath.resolve(utfFile.getFileName().toString()));
//			System.out.println("myStr = " + myStr);

			// Deleting temp file
			Files.delete(filePath.resolve(utfFile.getFileName().toString()));

			// Deleting an empty directory
//			Path emptyDir = Path.of("/home", "rein", "test");
//			Files.delete(emptyDir);

			// Deleting a directory that has contents
//			Path contentDir = Path.of("/home", "rein", "testContent");

			// walk will store the directory using the Files.walk method
//			try (Stream<Path> walk = Files.walk(contentDir)) {
//				// Deleting files starting from the end of the folder until it is empty
//			    walk.sorted(Comparator.reverseOrder()).forEach(path -> {
//			        try {
//			            Files.delete(path);
//			        } catch (IOException e) {
//			            // something could not be deleted..
//			            e.printStackTrace();
//			        }
//			    });
//			}

			// Listing files in a directory
//			Path dirPath = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
//					"marcobehler");
//
//			try (var fileDir = Files.list(dirPath)) {
//				fileDir.forEach(System.out::println);
//			}

			// Listing text files in a directory
//			Path textPath = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
//					"marcobehler", "writingAndReadingFiles");
//
//			try (var fileDir = Files.newDirectoryStream(textPath, "*.txt")) {
//				fileDir.forEach(System.out::println);
//			}
			
			// Another way of listing files in a directory
			Path dirPath = Path.of("/home", "rein", "repos", "Java-Tutorials", "Java Files and APIs", "src", "com",
			"marcobehler", "fileAPIs");
			try (var fileDir = Files.walk(dirPath)) {
				fileDir.forEach(System.out::println);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

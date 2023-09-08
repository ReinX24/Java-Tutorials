package com.javapoint.files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class CanWriteToFiles {

	public static void main(String[] args) {

		Path packagePath = Paths.get("src", "com", "javapoint", "files");
		File dirFile = new File(packagePath.toString());
		File[] filesArr = dirFile.listFiles();
		for (File eachFile : filesArr) {
			System.out.println(eachFile.getName() + " Can Write: " + eachFile.canWrite() + " Is Hidden: "
					+ eachFile.isHidden() + " Length: " + eachFile.length() + "bytes");
		}

	}

}

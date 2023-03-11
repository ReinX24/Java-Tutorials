import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

	public static void main(String[] args) {
		/*
		 * FileReader: read the contents of a file as a stream of characters.
		 * 
		 * Reads contents one by one.
		 * 
		 * read() returns an int value which contains the byte value
		 * 
		 * when read() returns -1, it means that there is no more data to be read.
		 */

		/*
		 * Need to surround with try catch block because it is considered to be
		 * dangerous code
		 */
		try {
			FileReader readFile = new FileReader("art.txt"); // FileReader object to read files
			int byteData = readFile.read(); // gets byte value of each char
			// Keep reading until byteData is not -1
			while (byteData != -1) {
				System.out.print((char) byteData); // converts byte code to a char
				byteData = readFile.read(); // goes to next char
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

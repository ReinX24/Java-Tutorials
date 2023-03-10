import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {

	public static void main(String[] args) {
		try {
			/* Writing a File using a FileWriter object */
			FileWriter fileWriter = new FileWriter("poem.txt");
			fileWriter.write("Roses are red\n");
			fileWriter.write("Violets are blue\n");
			fileWriter.write("Part rock is in the house tonight\n");
			fileWriter.write("Everybody just have a good time!\n");
			fileWriter.append("- Rein, 2023\n"); // another way of adding lines
			fileWriter.append(":D\n");
			fileWriter.close(); // remember to close the FileWriter object
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

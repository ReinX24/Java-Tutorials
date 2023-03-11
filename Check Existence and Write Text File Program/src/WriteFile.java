import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {

	Scanner userInput = new Scanner(System.in);

	public void startWrite(String fileName) {

		try {
			FileWriter textWriter = new FileWriter(fileName);
			int lineAmount = 5;
			String addText = "";
			while (lineAmount > 0) {
				System.out.println("\nLines remaining: " + lineAmount);
				System.out.print("Enter text: ");
				addText = userInput.nextLine();
				addText += "\n"; // breaks into a new line at the end
				textWriter.append(addText);
				lineAmount--;
			}
			textWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

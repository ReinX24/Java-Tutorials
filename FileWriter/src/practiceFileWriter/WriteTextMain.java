package practiceFileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteTextMain {

	public static void main(String[] args) {
		try {
			FileWriter writeText = new FileWriter("userInfo.txt");
			writeText.append("Name: Bob\n");
			writeText.append("Occupation: Builder\n");
			writeText.append("Age: 21\n");
			writeText.append("Sex: Male\n");
			writeText.append("Marital Status: Never Married\n");
			writeText.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

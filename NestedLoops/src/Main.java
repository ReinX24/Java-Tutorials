import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// nested loops = a loop inside of a loop
		Scanner userInput = new Scanner(System.in);
		int rowsNum;
		int columnsNum;
		String mySymbol = "";
		System.out.print("Enter # of rows: ");
		rowsNum = userInput.nextInt();
		System.out.print("Enter # of columns: ");
		columnsNum = userInput.nextInt();
		System.out.print("Enter symbol: ");
		mySymbol = userInput.next(); // no console formatting errors

		// Loops rows
		for (int i = 0; i < rowsNum; i++) {
			System.out.println(); // breaks into new line
			// Loops columns
			for (int j = 0; j < columnsNum; j++) {
				System.out.print(mySymbol);
			}
		}
		userInput.close();
	}

}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// while loop = executes a block of code as long as a it's condition remains
		// true
		Scanner userInput = new Scanner(System.in);
		String userName = "";
		// loops while userName is blank
//		while (userName.isBlank()) {
//			System.out.print("Enter your name: ");
//			userName = userInput.nextLine();
//		}
		// do while loop, runs once regardless if the condition in while loop is true or
		// false
		do {
			System.out.print("Enter your name: ");
			userName = userInput.nextLine();
		} while (userName.isBlank());
		System.out.println("Hello " + userName);
		userInput.close();
	}

}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Scanner object to accept user input
		Scanner userInput = new Scanner(System.in);

		// Ask for a name
		System.out.println("What is your name? ");
		String userName = userInput.nextLine();

		// Ask for a number
		System.out.println("How old are you? ");
		int userAge = userInput.nextInt();
		userInput.nextLine();

		// Ask for favorite food
		/*
		 * A formatting error in the console happens here, this is because after asking
		 * for an int, it causes a formatting error in the console when we ask for a
		 * String after an integer. To fix this, we add nextLine after nextInt.
		 */
		System.out.println("What is your favorite food? ");
		String userFood = userInput.nextLine();

		System.out.println("Hello " + userName);
		System.out.println("You are " + userAge + " years old");
		System.out.println("You like " + userFood);
		
		// Closing our Scanner object
		userInput.close();

	}

}

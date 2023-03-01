import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// logical operators = used to connect two or more expressions
		// && = (AND) both conditions must be true
		// || = (OR) either condition must be true
		// ! = (NOT) reverses boolean value of condition

		// Example #1
		int tempNum = 15;
		if (tempNum > 30) {
			System.out.println("It is hot outside");
		} else if (tempNum >= 20 && tempNum <= 30) {
			System.out.println("It is warm outside");
		} else {
			System.out.println("It is cold outside");
		}

		// Example #2
		Scanner userInput = new Scanner(System.in);
		System.out.print("You are playing a game! Press q or Q to quit: ");
		String userResponse = userInput.nextLine();

//		if (userResponse.equals("q") || userResponse.equals("Q")) {
//			System.out.println("You quit the game!");
//		} else {
//			System.out.println("You are still playing the game! *pew* *pew*");
//		}

		// Example #3
		// ! means NOT (reverses boolean value)
		if (!userResponse.equals("q") && !userResponse.equals("Q")) {
			System.out.println("You are still playing the game! *pew* *pew*");
		} else {
			System.out.println("You quit the game!");
		}

		userInput.close();

	}

}

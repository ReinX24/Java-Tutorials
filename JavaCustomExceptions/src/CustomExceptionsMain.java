import java.util.Scanner;

public class CustomExceptionsMain {

	public static void main(String[] args) {

		/*
		 * Exception - an event, after execution, that disrupts the normal flow of the
		 * program
		 * 
		 * ex. Arithmetic Exceptions, ArrayIndexOutOfBoundsException,
		 * FileNotFoundException
		 */

		/*
		 * User defined exceptions - custom exceptions
		 * 
		 * ex. DuplicateEmail, InvalidCreditException, AgeException
		 */

		Scanner userInput = new Scanner(System.in);

		// ask the user for an age
		System.out.print("Enter your age: ");
		int userAge = userInput.nextInt();

		// check the user's age through a method, surround in a try catch block
		try {
			checkAge(userAge);
		} catch (Exception e) { // if an exception occurs, message is thrown
			System.out.println("A problem occurred: " + e);
		}

		userInput.close();
	}

	public static void checkAge(int userAge) throws AgeException {
		// method throws an exception, for try catch block above

		if (userAge < 18) {
			throw new AgeException("\nYou must be 18 or older to sign up!");
			// calls the AgeException constructor and prints exception message
		} else {
			System.out.println("You are now signed up!");
		}

	}

}

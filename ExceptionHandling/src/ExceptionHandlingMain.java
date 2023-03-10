import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingMain {

	public static void main(String[] args) {
		/*
		 * An event that occurs during the execution of a program that disrupts the
		 * normal flow of instructions.
		 */

		Scanner userInput = new Scanner(System.in);

		try {
			System.out.print("Enter a whole number to divide: ");
			int numOne = userInput.nextInt();

			// cannot divide a number by 0, throws an exception
			System.out.print("Enter a whole number to divide by: ");
			int numTwo = userInput.nextInt();

			int quotientResult = numOne / numTwo;

			System.out.println("Result: " + quotientResult);

			// can create multiple catch blocks
		} catch (ArithmeticException e) { // executes if the user enters a 0
			System.out.println("You cannot divide by 0!");
		} catch (InputMismatchException e) { // executes of the user enters a String instead of a number
			System.out.println("Please enter a number!");
		} catch (Exception e) { // not recommended, for handling all exceptions
			System.out.println("Something went wrong!");
		} finally { // prints after the try catch block, regardless if there is an exception or not
			System.out.println("This will always print!");
			userInput.close(); // closing Scanner object in finally block recommended
		}
	}

}

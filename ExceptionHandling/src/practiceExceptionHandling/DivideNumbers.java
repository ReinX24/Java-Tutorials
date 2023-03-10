package practiceExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideNumbers {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		try {
			System.out.print("Enter a whole number to divide: ");
			int numOne = userInput.nextInt();

			System.out.print("Enter a number to divide by: ");
			int numTwo = userInput.nextInt();

			int quotientResult = numOne / numTwo;

			System.out.println("Result: " + quotientResult);
		} catch (ArithmeticException e) {
			System.out.println("[Cannot divide by 0!]");
		} catch (InputMismatchException e) {
			System.out.println("[Please enter a number!]");
		} catch (Exception e) {
			System.out.println("[An exception occurred!]");
		} finally {
			System.out.println("[Program Over!]");
			userInput.close();
		}

	}

}

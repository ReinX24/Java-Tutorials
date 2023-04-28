package practiceCustomException;

import java.util.Scanner;

public class PracticeCustomExceptionMain {

	public static void main(String[] args) {

		// Ask the user for their grade
		Scanner userInput = new Scanner(System.in);

		System.out.print("Enter your grade: ");
		int userGrade = userInput.nextInt();

		try {
			checkGrade(userGrade);
		} catch (Exception e) {
			System.out.println("Exception Occurred: " + e);
			// prints this first before calling the GradeException below
		}

		userInput.close();
	}

	public static void checkGrade(int userGrade) throws GradeException {

		if (userGrade < 75) {
			throw new GradeException("\nGrade is lower than 75! You failed!");
			// add a \n so that it appears in a new line, exception message no new line
		} else {
			System.out.println("Grade is higher than 75! You passed!");
		}

	}

}

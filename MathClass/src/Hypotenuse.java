import java.util.Scanner;

public class Hypotenuse {

	public static void main(String[] args) {

		/* The hypotenuse of a triangle is its longest side */
		double x;
		double y;
		double z; // where we will store hypotenuse

		// Scanner object to accept user input
		Scanner userInput = new Scanner(System.in);

		// Asking for x
		System.out.print("Enter side x: ");
		x = userInput.nextDouble();

		// Asking for y
		System.out.print("Enter side y: ");
		y = userInput.nextDouble();

		/* The formula for finding the hypotenuse is the square root of x^2 + y^2 */
		z = Math.sqrt((x * x) + (y * y));
		System.out.println("The hypotenuse is: " + z);

		userInput.close();
	}

}

import java.util.Scanner;

public class DynamicPolymorphismMain {

	public static void main(String[] args) {
		/*
		 * Polymorphism : many shapes / forms
		 * 
		 * Dynamic : after compilation (during runtime)
		 * 
		 * Example: A Corvette is a: Corvette, and a Car, a Vehicle, and an Object
		 */

		Scanner userInput = new Scanner(System.in);
		Animal animalOne; // not fully instantiated Animal class

		/* Asking the user if they want a Dog or a Cat */
		System.out.println("What animal do you want?");
		System.out.println("[1 - Dog] [2 - Cat]");
		System.out.print("Enter number: ");
		int userChoice = userInput.nextInt();

		/* Finish instantiating Animal object */
		if (userChoice == 1) {
			animalOne = new Dog();
			animalOne.animalSpeak();
		} else if (userChoice == 2) {
			animalOne = new Cat();
			animalOne.animalSpeak();
		} else {
			System.out.println("Invalid Choice!");
			animalOne = new Animal();
			animalOne.animalSpeak();
		}

		userInput.close();
	}

}

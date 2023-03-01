import java.util.Random;

public class Main {

	public static void main(String[] args) {

		// Random object that is going to be used to create random numbers
		Random randGen = new Random();

		// Creating a random integer
		int randomIntOne = randGen.nextInt(6) + 1; // generates a random number between 1 & 6
		System.out.println(randomIntOne);

		// Creating a random double
		double randomDoubleOne = randGen.nextDouble(); // random value >= 0 && < 1
		System.out.println(randomDoubleOne);

		// Creating a random boolean
		boolean randomBoolOne = randGen.nextBoolean();
		System.out.println(randomBoolOne);
	}

}

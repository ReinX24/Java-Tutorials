
public class JavaObjectsMain {

	public static void main(String[] args) {
		// Object = an instance of a class that may contain attributes and methods
		// Example: (phone, desk, computer, coffee cup)

		// Creating car objects
		Car carOne = new Car();
		Car carTwo = new Car();
		// Accessing attributes
		System.out.println(carOne.carModel);
		System.out.println(carOne.carMake);
		System.out.println();
		System.out.println(carTwo.carModel);
		System.out.println(carTwo.carMake);
		// Using Car methods
		System.out.println();
		carOne.carDrive();
		carOne.carBrake();
		System.out.println();
		carTwo.carDrive();
		carTwo.carBrake();
		System.out.println();
	}

}

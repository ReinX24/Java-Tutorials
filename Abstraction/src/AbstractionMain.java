
public class AbstractionMain {

	public static void main(String[] args) {
		/*
		 * Abstract: Abstract classes and methods cannot be instantiated, but they can
		 * have a subclass. Abstract methods are declared without an implementation.
		 */

//		Vehicle vehicleOne = new Vehicle(); // cannot create abstract objects
		Car carOne = new Car();
		carOne.startEngine();

	}

}

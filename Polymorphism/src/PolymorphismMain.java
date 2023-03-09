
public class PolymorphismMain {

	public static void main(String[] args) {

		/*
		 * Polymorphism : Greek word for poly - "many", morph - "form". The ability of
		 * an object to identify as more than one type.
		 */

		Car carOne = new Car();
		Bicycle bikeOne = new Bicycle();
		Boat boatOne = new Boat();

		// Creating an array of Vehicle child objects
		Vehicle[] racersArr = { carOne, bikeOne, boatOne }; // are all child classes of Vehicle class

		// Using methods from each of the objects
//		carOne.go();
//		bikeOne.go();
//		boatOne.go();

		// Using methods from objects using a loop
		for (Vehicle eachRacer : racersArr) {
			eachRacer.go();
		}

	}

}

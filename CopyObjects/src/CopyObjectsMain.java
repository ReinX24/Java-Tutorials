
public class CopyObjectsMain {

	public static void main(String[] args) {

		Car carOne = new Car("Chevrolet", "Camaro", 2021);
		Car carTwo = new Car("Ford", "Mustang", 2023);
		
		Car carThree = new Car(carTwo);
		
//		carTwo = carOne; // Do not do, does not copy attributes, only references carOne

		carTwo.copyCar(carOne); // copies all attributes of carOne, still different addresses in memory

		/*
		 * When copying objects, they should have different addresses in memory instead
		 * of having the same address.
		 */

		// Printing addresses of each Car object in memory
		System.out.println(carOne); // different addresses
		System.out.println(carTwo);
		System.out.println(carThree);
		System.out.println();
		System.out.println(carOne.getCarMake());
		System.out.println(carOne.getCarModel());
		System.out.println(carOne.getCarYear());
		System.out.println();
		System.out.println(carTwo.getCarMake());
		System.out.println(carTwo.getCarModel());
		System.out.println(carTwo.getCarYear());
		System.out.println();
		System.out.println(carThree.getCarMake());
		System.out.println(carThree.getCarModel());
		System.out.println(carThree.getCarYear());

	}

}


public class EncapsulationMain {

	public static void main(String[] args) {
		// Encapsulation = attributes of a class will be hidden or private,
		// Can be accessed only through methods (getters & setters)
		// You should make attributes private if you don't have a reason to make them
		// public/protected

		Car carOne = new Car("Chevrolet", "Camaro", 2023);
//		System.out.println(carOne.carMake); // cannot be accessed since it is a private variable

		// To fix this, we make getters to get private variables
		System.out.println(carOne.getCarMake());
		System.out.println(carOne.getCarModel());
		System.out.println(carOne.getCarYear());

		// Using setters to change object attributes
		carOne.setCarMake("Toyota");
		carOne.setCarModel("Corolla");
		carOne.setCarYear(2024);

		// Printing new object attributes
		System.out.println(carOne.getCarMake());
		System.out.println(carOne.getCarModel());
		System.out.println(carOne.getCarYear());

	}

}

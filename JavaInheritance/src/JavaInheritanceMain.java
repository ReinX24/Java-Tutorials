
public class JavaInheritanceMain {

	public static void main(String[] args) {
		/*
		 * Inheritance: The process where one class acquires the attributes and methods
		 * of another.
		 */

		Car carOne = new Car();
		System.out.println(carOne.vehicleSpeed);
		carOne.goVehicle(); // Car class receives all Vehicle methods
		carOne.stopVehicle();

		Bicycle bikeOne = new Bicycle();
		System.out.println(carOne.vehicleSpeed);
		bikeOne.goVehicle();
		bikeOne.stopVehicle();

		System.out.println(carOne.carDoors);
		System.out.println(carOne.carWheels);
		System.out.println(bikeOne.bikeWheels);
		System.out.println(bikeOne.bikePedals);
	}

}

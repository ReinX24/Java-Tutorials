
public class ObjectPassingMain {

	public static void main(String[] args) {
		Garage garageOne = new Garage();
		Car carOne = new Car("Toyota");
		Car carTwo = new Car("BMW");
		Car carThree = new Car("Ford");

		garageOne.carPark(carOne);
		garageOne.carPark(carTwo);
		garageOne.carPark(carThree);
	}

}

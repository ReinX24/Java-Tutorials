
public class Car extends Vehicle {

	// Method from Vehicle class, required for child classes
	@Override
	void startEngine() {
		System.out.println("Car engine has started!");
	}

}

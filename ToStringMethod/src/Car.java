
public class Car {

	// Attributes for car objects
	String carMake = "Ford";
	String carModel = "Mustang";
	String carColor = "Red";
	int carYear = 2023;

	// Overriding built in toString() method
	public String toString() { // public because we will use it in ToStringMain
		String carInfo = "";
		carInfo += "[Make: " + this.carMake + "]\n";
		carInfo += "[Model: " + this.carModel + "]\n";
		carInfo += "[Color: " + this.carColor + "]\n";
		carInfo += "[Year: " + this.carYear + "]\n";
		return carInfo;
	}

}

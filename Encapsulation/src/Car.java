
public class Car {

	private String carMake;
	private String carModel;
	private int carYear;

	Car(String carMake, String carModel, int carYear) {
//		this.carMake = carMake;
//		this.carModel = carModel;
//		this.carYear = carYear;
		// Using setters
		this.setCarMake(carMake);
		this.setCarModel(carModel);
		this.setCarYear(carYear);
	}

	// Getters for private variables
	public String getCarMake() {
		return carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public int getCarYear() {
		return carYear;
	}

	// Setters for private variables
	public void setCarMake(String newCarMake) {
		this.carMake = newCarMake;
	}

	public void setCarModel(String newCarModel) {
		this.carModel = newCarModel;
	}

	public void setCarYear(int newCarYear) {
		this.carYear = newCarYear;
	}

}

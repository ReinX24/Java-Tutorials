
public class Car {

	private String carMake;
	private String carModel;
	private int carYear;

	Car(String carMake, String carModel, int carYear) {
		this.setCarMake(carMake);
		this.setCarModel(carModel);
		this.setCarYear(carYear);
	}

	// Constructor for copying Car objects while instantiating them
	Car(Car toCopyCar) {
		this.copyCar(toCopyCar);
	}

	public String getCarMake() {
		return carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarMake(String newCarMake) {
		this.carMake = newCarMake;
	}

	public void setCarModel(String newCarModel) {
		this.carModel = newCarModel;
	}

	public void setCarYear(int newCarYear) {
		this.carYear = newCarYear;
	}

	// Copies all attributes of Car object in parameter to another Car object
	public void copyCar(Car toCopyCar) {
		this.setCarMake(toCopyCar.getCarMake());
		this.setCarModel(toCopyCar.getCarModel());
		this.setCarYear(toCopyCar.getCarYear());
	}

}

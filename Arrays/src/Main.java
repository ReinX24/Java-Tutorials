
public class Main {

	public static void main(String[] args) {
		// array = used to store multiple values within a single variable
		String[] carArr = { "Toyota", "Camaro", "Corvette", "Tesla" }; // array must all have the same data type

		carArr[0] = "Mustang";
		System.out.println(carArr[0]);
		System.out.println(carArr[1]);
		System.out.println(carArr[2]);
		System.out.println(carArr[3]);

		String[] carArrAgain = new String[3];
		carArrAgain[0] = "Camaro";
		carArrAgain[1] = "Corvette";
		carArrAgain[2] = "Tesla";

		// Printing Array elements using a for loop
		for (int i = 0; i < carArrAgain.length; i++) {
			System.out.println(carArrAgain[i]);
		}
	}

}

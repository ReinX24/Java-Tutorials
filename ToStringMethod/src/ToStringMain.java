
public class ToStringMain {

	public static void main(String[] args) {
		/*
		 * toString(): A special method that all objects inherit that returns a String
		 * that "textually" represents an object. This can be used both implicitly and
		 * explicitly.
		 */

		Car carOne = new Car();
		// Using the toString() method to print Car object values
		System.out.println(carOne); // without toString(), implicit
		System.out.println(carOne.toString()); // explicitly
	}

}

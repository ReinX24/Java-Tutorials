
public class Main {

	public static void main(String[] args) {

		/*
		 * if statement = performs a block of code if it's condition evaluates to be
		 * true
		 */

		int ageNum = 14;

		if (ageNum >= 75) {
			System.out.println("Ok Boomer!");
		} else if (ageNum >= 18) {
			System.out.println("You are an adult!");
		} else if (ageNum >= 13) {
			System.out.println("You are a teenager!");
		} else { // if the condition above is false
			System.out.println("You are NOT and adult!");
		}

	}

}

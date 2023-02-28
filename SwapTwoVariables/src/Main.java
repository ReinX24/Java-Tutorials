
public class Main {

	public static void main(String[] args) {

		String x = "water";
		String y = "Kool-Aid";
		String tempStr; // variable that temporarily holds tempStr

		/* Swapping the two values of the two variables */
		tempStr = x; // store x in tempStr
		x = y; // replace x with y
		y = tempStr; // replace y with tempStr

		System.out.println("x: " + x);
		System.out.println("y: " + y);

	}

}


public class Main {

	public static void main(String[] args) {

		double x = 3.14;
		double y = -10;

		// Using the Math.max method to find the max num between the two
		double maxNum = Math.max(x, y);
		System.out.println(maxNum); // prints x, 3.14

		// Math.min
		double minNum = Math.min(x, y);
		System.out.println(minNum); // -10

		// Math.abs
		double absNum = Math.abs(y); // absolute value of y
		System.out.println(absNum); // 10

		// Math.sqrt
		double sqrtNum = Math.sqrt(absNum); // finds the square root of 10 (absNum)
		System.out.println(sqrtNum);

		// Math.round
		double roundNum = Math.round(x); // rounds off x
		System.out.println(roundNum); // 3

		// Math.ceil
		double ceilNum = Math.ceil(x); // rounds up
		System.out.println(ceilNum); // 4

		// Math.floor
		double floorNum = Math.floor(x); // rounds down
		System.out.println(floorNum); // 3

	}

}

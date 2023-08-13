
public class RecursionPractice {

	public static void main(String[] args) {
		// Create the recursive elements of the following tasks:
		// - Count down
		// - Factorial
		// - Power of a number
		
//		countDown(5); // DONE
//		System.out.println(calcFactorial(7)); // DONE
		System.out.println(calcPower(2, 8)); // 256
		System.out.println(calcPower(2, 5)); // 32
	}
	
	public static void countDown(int startNum) {
		if (startNum < 1) {
			return;
		}
		System.out.println(startNum);
		countDown(startNum - 1);
	}
	
	public static int calcFactorial(int factorialNum) {
		if (factorialNum == 1) {
			return 1;
		}
		return factorialNum * calcFactorial(factorialNum - 1);
	}
	
	public static int calcPower(int baseNum, int powerNum) {
		if (powerNum == 1) {
			return baseNum;
		}
		return baseNum * calcPower(baseNum, powerNum - 1);
	}

}

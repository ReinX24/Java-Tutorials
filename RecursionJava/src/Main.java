
public class Main {

	public static void main(String[] args) {
		// Recursion is when something calls itself
		// A recursive method is when a method calls itself

		// Advantages:
		// Easier to read/write
		// Easier to debug

		// Disadvantages:
		// Sometimes slower
		// Uses more memory

		// Iterative vs Recursive
//		walkIterative(5);
//		walkRecursive(1000000);

		// Calculating the factorial of a number using a recursive method

//		System.out.println(factorial(7));

//		int factorialResult = calcFactorial(7);
//		System.out.println(factorialResult);

		// Raising a number (base) to a power (exponent), 2 ^ 8
		System.out.println(power(2, 8));

		// Using my personal count down recursive method
//		countDown(5);
	}

	private static void walkIterative(int stepsNum) {
		for (int i = 0; i < stepsNum; i++) {
			System.out.println("You take a step!");
		}
	}

	private static void walkRecursive(int stepsNum) {
		if (stepsNum < 1) {
			return; // breaks the recursive method, base case, what we put when we want to stop
		} else {
			System.out.println("You take a step!");
			walkRecursive(stepsNum - 1);
		}

	}

	private static int factorial(int factorialNum) {
		if (factorialNum < 1) {
			return 1;
		}
		return factorialNum *= factorial(factorialNum - 1);
	}

	// Finding the factorial of a number using a recursive function, personal method
	public static int calcFactorial(int factorialNum) {
		if (factorialNum == 1) {
			return 1;
		}
		return factorialNum * calcFactorial(factorialNum - 1);

	}

	private static int power(int baseNum, int exponentNum) {
		if (exponentNum < 1) {
			return 1;
		}
		return baseNum * power(baseNum, exponentNum - 1);
	}

	// Counting down from a number using recursion, personal method
	public static void countDown(int startNum) {
		if (startNum == 0) {
			System.out.println(startNum + ", Blast Off!");
		} else {
			System.out.println(startNum);
			countDown(startNum - 1);
		}
	}

}

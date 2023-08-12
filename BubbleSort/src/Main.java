
public class Main {

	public static void main(String[] args) {

		// Bubble sort = pairs of adjacent elements are compared, and the elements
		// swapped if they are not in order.

		// Quadratic time O(n^2)
		// small data set = okay
		// large data set= bad

		// Bubble sort is pretty slow, it runs at O(n^2) complexity, which is the
		// slowest in the Big 0 notation tiers

		int[] numArray = { 2, 4, 1, 7, 6, 4, 8, 9, 3 };

		bubbleSort(numArray);
		
		for (int i : numArray) {
			System.out.print(i);
		}
		
	}
	
	public static void bubbleSort(int[] numArray) {
		for (int i = 0; i < numArray.length - 1; i++) {
			for (int j = 0; j < numArray.length - i - 1; j++) {
				if (numArray[j] > numArray[j + 1]) { // ascending order
					int tempNum = numArray[j];
					numArray[j] = numArray[j + 1];
					numArray[j + 1] = tempNum;
				}
			}
		}
	}

}


public class Main {

	public static void main(String[] args) {

		// Less steps than bubble sort
		// Best case is O(n) compared to Selection Sort O(n^2)
		// More preferable than bubble sort and selection sort

		int[] numArray = { 9, 1, 8, 2, 7, 3, 6, 5, 4 };

		insertionSort(numArray);

		for (int i : numArray) {
			System.out.print(i + " ");
		}

	}

	private static void insertionSort(int[] numArray) {
		for (int i = 1; i < numArray.length; i++) {
			int tempNum = numArray[i];
			int j = i - 1; // index that starts at the left of i
			while (j >= 0 && numArray[j] > tempNum) { // keeps running while the current iterated element to the left is
														// greater than tempNum
				numArray[j + 1] = numArray[j]; // shifts element to the right, keeps shifting until while loop is broken
				j--; // go to the next element to the left
			}
			numArray[j + 1] = tempNum;
		}
	}

}

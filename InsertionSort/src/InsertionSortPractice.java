
public class InsertionSortPractice {

	public static void main(String[] args) {
		int[] numArray = { 9, 1, 8, 2, 7, 3, 6, 5, 4 };
		for (int i : numArray) {
			System.out.print(i + " ");
		}
		System.out.println("\n*****************");
		numArray = insertionSort(numArray);
		for (int i : numArray) {
			System.out.print(i + " ");
		}
	}

	private static int[] insertionSort(int[] numArray) {
		// First, we will start iterating through numArray from its second element
		for (int i = 1; i < numArray.length; i++) {
			// We will not get the element at the index of i
			int tempNum = numArray[i];
			// After getting our element, get the index to the left of i
			int j = i - 1;
			// Shift the elements at the left of i to the right using a while loop until it
			// finds a value lower than the index i value in numArray or it reaches the
			// start of the array
			while (j >= 0 && numArray[j] > tempNum) {
				numArray[j + 1] = numArray[j];
				j--;
			}
			numArray[j + 1] = tempNum;
		}

		return numArray;
	}

}

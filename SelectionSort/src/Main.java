
public class Main {

	public static void main(String[] args) {
		// Selection sort is where you find the smallest value first and then sorting
		// the array by swapping the values' indexes until the array is fully sorted
		// Runs in O(n^2), quadratic time, which is the slowest tier in Big O notation
		// Better than bubble sort, but it is still bad for larger data sets

		int[] numArray = { 8, 7, 9, 2, 3, 1, 5, 4, 6 };

		selectionSort(numArray);

		for (int i : numArray) {
			System.out.print(i);
		}

	}

	public static void selectionSort(int[] numArray) {
		for (int i = 0; i < numArray.length - 1; i++) { // loops until before the last element
			int minIndex = i;
			for (int j = i + 1; j < numArray.length; j++) { // loops until the last element
				if (numArray[minIndex] > numArray[j]) { // ascending order
					minIndex = j; // replaces with the new index of the smallest number
				}
			}
			int tempNum = numArray[i];
			numArray[i] = numArray[minIndex]; // replace current iterated element with the lowest found value
			numArray[minIndex] = tempNum; // place the iterated element to the index of the lowest value before swapping
		}
	}

}


public class SelectionSortPractice {

	public static void main(String[] args) {
		int[] numArray = { 8, 7, 9, 2, 3, 1, 5, 4, 6 };
		numArray = selectionSort(numArray);
		for (int i : numArray) {
			System.out.print(i);
		}
	}

	public static int[] selectionSort(int[] numArray) {
		for (int i = 0; i < numArray.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < numArray.length; j++) {
				if (numArray[minIndex] > numArray[j]) {
					minIndex = j; // finding the index of the smallest value first before swapping
				}
			}
			// After finding the smallest value, then we swap indexes
			int tempNum = numArray[i];
			numArray[i] = numArray[minIndex];
			numArray[minIndex] = tempNum;
		}
		return numArray;
	}

}

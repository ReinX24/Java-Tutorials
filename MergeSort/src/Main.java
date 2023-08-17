
public class Main {

	public static void main(String[] args) {
		// O(n) linear space, faster than insertion sort, selection sort, and bubble
		// sort
		int[] numArray = { 8, 2, 5, 3, 4, 7, 6, 1 };
		mergeSort(numArray);
		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i] + " ");
		}
	}

	private static void mergeSort(int[] numArray) {
		int arrLength = numArray.length;
		if (arrLength <= 1) { // base case
			return;
		}
		int middleIndex = arrLength / 2;
		int[] leftArray = new int[middleIndex];
		int[] rightArray = new int[arrLength - middleIndex];

		int i = 0; // left array
		int j = 0; // right array

		for (; i < arrLength; i++) {
			if (i < middleIndex) {
				leftArray[i] = numArray[i];
			} else {
				rightArray[j] = numArray[i];
				j++;
			}
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, numArray);
	}

	private static void merge(int[] leftArray, int[] rightArray, int[] numArray) {
		int leftSize = numArray.length / 2;
		int rightSize = numArray.length - leftArray.length;
		int i = 0, l = 0, r = 0; // indices
		// Checking the conditions for merging
		while (l < leftSize && r < rightSize) {
			if (leftArray[l] < rightArray[r]) {
				numArray[i] = leftArray[l];
				i++;
				l++;
			} else {
				numArray[i] = rightArray[r];
				i++;
				r++;
			}
		}
		// Adding last elements if there are any remaining
		while (l < leftSize) {
			numArray[i] = leftArray[l];
			i++;
			l++;
		}
		while (r < rightSize) {
			numArray[i] = rightArray[r];
			i++;
			r++;
		}
	}

}

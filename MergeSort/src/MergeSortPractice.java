
public class MergeSortPractice {

	public static void main(String[] args) {
		int[] numArray = { 8, 2, 5, 3, 4, 7, 6, 1 };

		int binaryResult = binarySearch(numArray, 7);
		System.out.println(binaryResult);

		mergeSort(numArray);
		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i] + " ");
		}

		/*
		 * Steps for creating merge sort algorithm
		 * 
		 * 1. Divide the array into 2 arrays
		 * 
		 * 2. Add elements to the left and right sides of the arrays
		 * 
		 * 3. Continually divide the array into 2 arrays until it reaches only a length
		 * of less than 0 or 1
		 * 
		 * 4. Sort the left and right sides of the sub arrays
		 * 
		 * 5. Add any remaining elements to the end of the main array
		 */

	}

	private static void mergeSort(int[] numArray) {
		int arrLength = numArray.length;
		if (arrLength <= 1) {
			return; // breaks the recursive loop
		}
		int leftSize = arrLength / 2;
		int rightSize = arrLength - leftSize;
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];
		int i = 0;
		int j = 0;
		while (i < arrLength) {
			if (i < leftSize) {
				leftArray[i] = numArray[i];
				i++;
			} else {
				rightArray[j] = numArray[i];
				i++;
				j++;
			}
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, numArray);
	}

	private static int[] merge(int[] leftArray, int[] rightArray, int[] numArray) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		int i = 0, l = 0, r = 0;
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
		return numArray;
	}

	private static int binarySearch(int[] numArray, int targetNum) {
		int arrLength = numArray.length;
		int lowIndex = 0;
		int highIndex = arrLength - 1;
		while (lowIndex <= highIndex) {
			int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
			if (numArray[middleIndex] < targetNum) {
				lowIndex = middleIndex + 1;
			} else if (numArray[middleIndex] > targetNum) {
				highIndex = middleIndex - 1;
			} else {
				return middleIndex; // the index of our targetNum inside the numArray
			}
		}
		return -1;
	}

}

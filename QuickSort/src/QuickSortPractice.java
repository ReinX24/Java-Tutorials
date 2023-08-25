
public class QuickSortPractice {

	public static void main(String[] args) {
		// Sorting an array using quick sort
		int startTime = (int) System.nanoTime();
		int[] numArr = { 8, 2, 4, 7, 1, 3, 9, 6, 5 };
		quickSort(numArr, 0, numArr.length - 1);
		// Printing the sorted array
		for (int eachNum : numArr) {
			System.out.print(eachNum + " ");
		}
		int endTime = (int) System.nanoTime();
		System.out.println("\nRuntime: " + (endTime - startTime) + "ns");
	}

	public static void quickSort(int[] numArr, int startIndex, int endIndex) {
		// Base case, if the endIndex is less than or equal to startIndex
		if (endIndex <= startIndex) {
			return;
		}
		// Finding the index of the pivot in numArr, the pivot will be the index of the
		// element that is at the end of numArr
		int pivotNum = partitionArr(numArr, startIndex, endIndex);
		// After finding the pivot, call the quick sort method again but this time it is
		// now separated from the left and right sides
		quickSort(numArr, startIndex, pivotNum - 1);
		quickSort(numArr, pivotNum + 1, endIndex);
	}

	public static int partitionArr(int[] numArr, int startIndex, int endIndex) {
		// Finding the index of our pivot
		int pivotNum = numArr[endIndex]; // our pivot will be the last element in numArr
		int i = startIndex - 1; // where we will store the pivot of our index, start at -1 of startIndex
		// Looping through our numArr
		for (int j = startIndex; j <= endIndex; j++) {
			// If the current value at index j is less than pivotNum, increment i and swap
			// out the values of index i and index j
			if (numArr[j] < pivotNum) {
				i++;
				int temp = numArr[i];
				numArr[i] = numArr[j];
				numArr[j] = temp;
			}
		}
		// Once index j is at the index of our last element in numArr, increment i and
		// then swap the values of index j and index i, return i after
		i++;
		int temp = numArr[i];
		numArr[i] = numArr[endIndex];
		numArr[endIndex] = temp;
		return i;
	}

}

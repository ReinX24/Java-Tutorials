package com.rein.sortingAlgorithms.quickSort;

public class QuickSort {

	public static void quickSort(int[] intArr, int startIndex, int endIndex) {
		// For breaking the recursive loop in the method
		while (endIndex <= startIndex) {
			return;
		}
		// Finding the index of the pivot number
		int pivotIndex = partitionArray(intArr, startIndex, endIndex);
		quickSort(intArr, startIndex, pivotIndex - 1);
		quickSort(intArr, pivotIndex + 1, endIndex);
	}

	public static int partitionArray(int[] intArr, int startIndex, int endIndex) {

		// Using the last element of the array as our pivot
		int pivotNum = intArr[endIndex];
		int i = startIndex - 1;

		// For sorting the numbers that are less than pivotNum
		for (int j = startIndex; j <= endIndex; j++) {
			if (intArr[j] < pivotNum) {
				i++;
				int tempInt = intArr[i];
				intArr[i] = intArr[j];
				intArr[j] = tempInt;
			}
		}

		// Placing the pivot index within its proper place in the array
		i++;
		int tempInt = intArr[i];
		intArr[i] = intArr[endIndex];
		intArr[endIndex] = tempInt;

		// Returning the index of the pivotNum
		return i;
	}

}

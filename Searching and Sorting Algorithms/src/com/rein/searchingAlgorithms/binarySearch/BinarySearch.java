package com.rein.searchingAlgorithms.binarySearch;

public class BinarySearch {
	
	public static int binarySearch(int[] intArray, int targetInt) {
		int lowIndex = 0;
		int highIndex = intArray.length - 1;
		while (lowIndex <= highIndex) {
			int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
			int middleValue = intArray[middleIndex];
			if (targetInt > middleValue) {
				lowIndex = middleIndex + 1;
			} else if (targetInt < middleValue) {
				highIndex = middleIndex - 1;
			} else {
				return middleIndex;
			}
		}
		return -1; // if the index of targetInt is not found
	}

}

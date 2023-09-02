package com.rein.searchingAlgorithms.linearSearch;

public class LinearSearch {
	
	public static int linearSearch(int[] intArray, int targetInt) {
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] == targetInt) {
				return i;
			}
		}
		return -1;
	}

}

package com.rein.searchingAlgorithms.binarySearch;

public class Main {

	public static void main(String[] args) {

		/*
		 * Binary Search: A sorting algorithm that is better than linear search when it
		 * comes to finding an element within a sorted array. This can only be used if
		 * the array is sorted beforehand.
		 */

		int[] numArrOne = { 1, 2, 3, 4, 5, 6 };
		System.out.println(BinarySearch.binarySearch(numArrOne, 3));
		System.out.println(BinarySearch.binarySearch(numArrOne, 5));
		System.out.println(BinarySearch.binarySearch(numArrOne, 7));
		System.out.println(BinarySearch.binarySearch(numArrOne, 8));

	}

}

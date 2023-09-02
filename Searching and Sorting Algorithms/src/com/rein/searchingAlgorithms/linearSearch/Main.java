package com.rein.searchingAlgorithms.linearSearch;

public class Main {

	public static void main(String[] args) {

		/*
		 * Linear Search: A sorting algorithm that searches through an array for an
		 * element by iterating through each element in the array. This is can be used
		 * for small data sets and it does not matter whether the set is sorted or not.
		 */

		int[] numArrOne = { 1, 6, 3, 4, 9, 2, 7 };
		System.out.println(LinearSearch.linearSearch(numArrOne, 6));
		System.out.println(LinearSearch.linearSearch(numArrOne, 2));
		System.out.println(LinearSearch.linearSearch(numArrOne, 8));
		System.out.println(LinearSearch.linearSearch(numArrOne, 10));

	}

}

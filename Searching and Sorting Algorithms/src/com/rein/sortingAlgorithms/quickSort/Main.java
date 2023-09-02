package com.rein.sortingAlgorithms.quickSort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		/*
		 * Quick Sort: A sorting algorithm that assigns a number as its pivot and then
		 * sorts the data set that are less than that pivot.
		 */

		int[] intArrOne = { 1, 6, 4, 6, 2, 8, 5, 3 };
		QuickSort.quickSort(intArrOne, 0, intArrOne.length - 1);
		System.out.println(Arrays.toString(intArrOne));

	}

}

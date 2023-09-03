package com.rein.customArrayList;

import java.util.Arrays;

public class CustomArrayList<T> {

	// Instead of just being able to use one data type, we will be using generics to
	// create array lists with any type of objects
	private int[] dataArr;
	private static int DEFAULT_SIZE = 10;
	// Tracking amount of added elements and will be used as an index value
	private int dataSize = 0;

	public CustomArrayList() {
		dataArr = new int[DEFAULT_SIZE];
	}

	public void add(int newNum) {
		// Checking if the array list is full and resized it if necessary
		if (this.isFull()) {
			resize();
		}
		// Add element to arrSize index and increment arrSize for the next element
		dataArr[dataSize++] = newNum;
	}

	private boolean isFull() {
		return dataSize == dataArr.length;
	};

	private void resize() {
		// New array that will have double the size of the original array
		int[] tempArr = new int[dataArr.length * 2];
		// Copying current array items to new array
		for (int i = 0; i < dataArr.length; i++) {
			tempArr[i] = dataArr[i];
		}
		dataArr = tempArr; // replaces current data array with tempArr
	}

	// Method that removes the last element in an array
	public int remove() {
		// This does not actually remove the last item in the array, rather it just
		// hides it until we add another item that will eventually override that array
		// element
		int removedInt = dataArr[--dataSize];
		return removedInt;
	}

	public int get(int numIndex) {
		return dataArr[numIndex];
	}

	public int size() {
		return dataSize;
	}

	public void set(int indexNum, int valueNum) {
		dataArr[indexNum] = valueNum;
	}

	@Override
	public String toString() {
		return "CustomArrayList{dataArr=" + Arrays.toString(dataArr) + ", dataSize=" + dataSize + "}";
	}

	public static void main(String[] args) {

		CustomArrayList customListOne = new CustomArrayList();
		customListOne.add(3);
		customListOne.add(5);
		customListOne.add(9);

		System.out.println(customListOne.toString());

		for (int i = 0; i < 14; i++) {
			customListOne.add(2 * i);
		}

		// Prints an array with double the original size
		System.out.println(customListOne.toString());

	}

}

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		// Binary search: search algorithm that finds the position of a target value
		// within a sorted array. Half of the array is eliminated during each "step"

		// Binary search is useful for large data sets but not for small data sets
		// O(log n), which means that the larger the data set, the more constant its
		// efficient will be

		int numArray[] = new int[1000000];
		int targetNum = 777777;

		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = i;
		}

		// Using the built in binary search method in Java
//		int numIndex = Arrays.binarySearch(numArray, targetNum); // our array, our target number

		// Using our own method
		int numIndex = binarySearch(numArray, targetNum);

		if (numIndex == -1) {
			System.out.println(targetNum + " not found");
		} else {
			System.out.println("Element found at: " + numIndex);
		}

	}

	public static int binarySearch(int[] numArray, int targetNum) {
		int lowIndex = 0;
		int highIndex = numArray.length - 1;

		// Creating a while loop that iterates through the entire array
		while (lowIndex <= highIndex) {
			// Formula for finding the middle index
			int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
			int middleValue = numArray[middleIndex];

			System.out.println("Middle: " + middleValue);

			// If the middleValue is lower than our targetNum, cut the left side
			if (middleValue < targetNum) {
				lowIndex = middleIndex + 1;
			} else if (middleValue > targetNum) {
				highIndex =  middleIndex - 1;
			} else {
				return middleIndex; // returns the index of the number we are searching for
			}
		}
		return -1;
	}

}

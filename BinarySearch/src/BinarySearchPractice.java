
public class BinarySearchPractice {

	public static void main(String[] args) {

		/*
		 * Input: nums[] = [2, 3, 5, 7, 9] target = 7 Output: Element found at index 3
		 * Input: nums[] = [1, 4, 5, 8, 9] target = 2 Output: Element not found
		 */

		int[] numArrayOne = { 2, 3, 5, 7, 9 };
		int targetNumOne = 7;

		int[] numArrayTwo = { 1, 4, 5, 8, 9 };
		int targetNumTwo = 2;

		int resultOne = binarySearch(numArrayOne, targetNumOne);
		int resultTwo = binarySearch(numArrayTwo, targetNumTwo);
		
		printResults(resultOne);
		printResults(resultTwo);

	}

	public static int binarySearch(int[] numArray, int targetNum) {
		int lowIndex = 0;
		int highIndex = numArray.length - 1;
		while (lowIndex <= highIndex) {
			int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
			int middleValue = numArray[middleIndex];
			if (targetNum > middleValue) { // cut off the left side
				lowIndex = middleIndex + 1;
			} else if (targetNum < middleValue) { // cut off the right side
				highIndex = middleIndex - 1;
			} else {
				return middleIndex;
			}
		}
		return -1;
	}
	
	public static void printResults(int targetIndex) {
		if (targetIndex == -1) {
			System.out.println("Element not found!");
		} else {
			System.out.println("Element found at index " + targetIndex);
		}
	}

}

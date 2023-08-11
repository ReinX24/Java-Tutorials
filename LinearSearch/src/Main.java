
public class Main {
	
	public static void main(String[] args) {
		
		// Linear search = Iterate through a collection one element at a time
		
		// Runtime complexity: O(n) (the more data, the more time it takes to process)
		
		// Disadvantages:
		// Slow for large data sets
		
		// Advantages:
		// Fast and searches for small to medium data sets
		// Does not need to sorted
		// Useful for data structures that do not have random access (Linked list)
		
		int[] numArray = {9, 2, 4, 2, 3, 5, 1, 6, 7, 8};
		
		int indexNum = linearSearch(numArray, 10);
		
		if (indexNum != -1) {
			System.out.println("Element found at index: " + indexNum);
		} else {
			System.out.println("Element not found");
		}
		
	}

	private static int linearSearch(int[] numArray, int numValue) {
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] == numValue) {
				return i;
			}
		}
		return -1;
	}

}

public class Main {

	public static void main(String[] args) {
		int[] numArr = { 8, 2, 4, 7, 1, 3, 9, 6, 5 };
		int startTime = (int) System.nanoTime();
		quickSort(numArr, 0, numArr.length - 1);
		for (int eachNum : numArr) {
			System.out.print(eachNum + " ");
		}
		int endTime = (int) System.nanoTime();
		System.out.println("\nRuntime: " + (endTime - startTime) + "ns");
	}

	private static void quickSort(int[] numArr, int startIndex, int endIndex) {
		if (endIndex <= startIndex) {
			return; // base case
		}
		int pivotNum = partitionArr(numArr, startIndex, endIndex); // finding the pivot and sorting the left and right sides
		quickSort(numArr, startIndex, pivotNum - 1);
		quickSort(numArr, pivotNum + 1, endIndex);
	}

	private static int partitionArr(int[] numArr, int startIndex, int endIndex) {
		int pivotNum = numArr[endIndex];
		int i = startIndex - 1;
		for (int j = startIndex; j <= endIndex - 1; j++) {
			if (numArr[j] < pivotNum) { // all elements less than our pivot should be on the left hand side
				i++;
				int temp = numArr[i];
				numArr[i] = numArr[j];
				numArr[j] = temp;
			}
		}
		i++;
		int temp = numArr[i];
		numArr[i] = numArr[endIndex];
		numArr[endIndex] = temp;
		return i; // returns the location of our pivot

	}

}

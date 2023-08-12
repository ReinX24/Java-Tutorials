
public class BubbleSortPractice {

	public static void main(String[] args) {
		int[] numArray = { 2, 4, 1, 7, 6, 4, 8, 9, 3 };
		bubbleSort(numArray);
		for (int i : numArray) {
			System.out.print(i);
		}
	}

	public static void bubbleSort(int[] numArray) {
		for (int i = 0; i < numArray.length - 1; i++) { // goes until before the last element
			for (int j = i + 1; j < numArray.length; j++) { // goes until the last element
				if (numArray[i] > numArray[j]) {
					int tempNum = numArray[i];
					numArray[i] = numArray[j];
					numArray[j] = tempNum;
				}
			}
		}
	}
}

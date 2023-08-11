
public class InterpolationSearchPractice {

	public static void main(String[] args) {

		int[] testArrayOne = { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47 };
		int targetNumOne = 18;
		int resultOne = interpolationSearch(testArrayOne, targetNumOne);

		if (resultOne != -1) {
			System.out.println("Element found at index: " + resultOne);
		} else {
			System.out.println("Element not found");
		}

	}

	public static int interpolationSearch(int[] numArray, int targetNum) {
		int lowIndex = 0;
		int highIndex = numArray.length - 1;
		while (targetNum >= numArray[lowIndex] && targetNum <= numArray[highIndex] && lowIndex <= highIndex) {
			int probeIndex = lowIndex + (highIndex - lowIndex) * (targetNum - numArray[lowIndex])
					/ (numArray[highIndex] - numArray[lowIndex]);
			if (numArray[probeIndex] < targetNum) {
				lowIndex = probeIndex + 1;
			} else if (numArray[probeIndex] > targetNum) {
				highIndex = probeIndex - 1;
			} else {
				return probeIndex;
			}
		}

		return -1;
	}

}


public class Main {

	public static void main(String[] args) {
		// interpolation search = improvement over binary search best used for
		// "uniformly" distributed data "guesses" where a value might be based on
		// calculated probe results
		// if probe is incorrect, search area is narrowed, and a new probe is calculated
		// average case: O(log(log(n)))
		// worst case: O(n) [values increase exponentially]

		// This is somewhat similar to binary search
		// Best case scenario, uniformly distributed data because it consistently
		// increases by one
		int[] numArray = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };
		int indexNum = interpolationSearch(numArray, 256);

		if (indexNum != -1) {
			System.out.println("Element found at index: " + indexNum);
		} else {
			System.out.println("Element not found");
		}
	}

	private static int interpolationSearch(int[] numArray, int targetNum) {

		int upperBound = numArray.length - 1;
		int lowerBound = 0;

		while (targetNum >= numArray[lowerBound] && targetNum <= numArray[upperBound] && lowerBound <= upperBound) {
			int probeIndex = lowerBound + (upperBound - lowerBound) * (targetNum - numArray[lowerBound])
					/ (numArray[upperBound] - numArray[lowerBound]);
			System.out.println("Probe: " + probeIndex);
			if (numArray[probeIndex] == targetNum) {
				return probeIndex;
			} else if (numArray[probeIndex] < targetNum) {
				lowerBound = probeIndex + 1;
			} else {
				upperBound = probeIndex = 1;
			}
		}

		return -1;
	}

}

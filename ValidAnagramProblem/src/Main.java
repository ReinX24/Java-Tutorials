
public class Main {

	public static void main(String[] args) {

		// Check if two words are anagrams of each other
		System.out.println(checkAnangramFirstSolution("aBbc", "abc")); // false
		System.out.println(checkAnangramFirstSolution("nameless", "salesmen")); // true
		System.out.println(checkAnangramFirstSolution("SaLeSmEn", "nAmElEsS")); // true with different capitalizations

		System.out.println(checkAnagramShort("aBbc", "abc"));
		System.out.println(checkAnagramShort("nameless", "salesmen"));
		System.out.println(checkAnagramShort("SaLeSmEn", "nAmElEsS"));

		// Checking runtime of our first solution to our fastest solution
		// Faster
		System.out.println("[First Solution]");
		long startTime = System.nanoTime();
		System.out.println(checkAnangramFirstSolution("PneumonoultramicRoscopicsilicovolcanoconiosiS",
				"PeumonvoultramicRoscopicsilicoonlcanoconiosiS"));
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);

		// Slower
		System.out.println("[Second Solution]");
		startTime = System.nanoTime();
		System.out.println(checkAnagramShort("PneumonoultramicRoscopicsilicovolcanoconiosiS",
				"PeumonvoultramicRoscopicsilicoonlcanoconiosiS"));
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);

	}

	public static boolean checkAnangramFirstSolution(String stringOne, String stringTwo) {
		int[] alphabetArrayOne = new int[26];
		int[] alphabetArrayTwo = new int[26];
		if (stringOne.length() != stringTwo.length()) {
			return false;
		} else {
			stringOne = stringOne.toLowerCase();
			stringTwo = stringTwo.toLowerCase();
			for (int i = 0; i < stringOne.length(); i++) {
				alphabetArrayOne[Integer.valueOf(stringOne.charAt(i)) - 97]++;
				alphabetArrayTwo[Integer.valueOf(stringTwo.charAt(i)) - 97]++;
			}
			for (int i = 0; i < alphabetArrayOne.length; i++) {
				if (alphabetArrayOne[i] != alphabetArrayTwo[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkAnagramShort(String stringOne, String stringTwo) {
		if (stringOne.length() != stringTwo.length()) {
			return false;
		}
		return sortString(stringOne.toLowerCase()).equals(sortString(stringTwo.toLowerCase()));
	}

	public static String sortString(String paraString) {
		char[] charArray = paraString.toCharArray();
		// Using insertion sort
		for (int i = 1; i < charArray.length; i++) {
			char tempChar = charArray[i];
			int j = i - 1;
			while (j >= 0 && charArray[j] > tempChar) {
				charArray[j + 1] = charArray[j];
				j--;
			}
			charArray[j + 1] = tempChar;
		}
		return String.valueOf(charArray);
	}

}

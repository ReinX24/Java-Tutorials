
public class Main {
	
	public static void main(String[] args) {
		
		// Check if two words are anagrams of each other
		checkAnangramFirstSolution("abbc", "abc"); // not an anagram
		checkAnangramFirstSolution("nameless", "salesmen");
	}
	
	public static void checkAnangramFirstSolution(String stringOne, String stringTwo) {
		int[] alphabetArray = new int[26];
		if (stringOne.length() != stringTwo.length()) {
			System.out.println("Not an anagram");
		} else {
			stringOne = stringOne.toLowerCase();
			stringTwo = stringTwo.toLowerCase();
			for (int i = 0; i < stringOne.length(); i++) {
				alphabetArray[Integer.valueOf(stringOne.charAt(i)) - 97]++;
				alphabetArray[Integer.valueOf(stringTwo.charAt(i)) - 97]--;
			}
//			for ()
			
		}
		
	}

}

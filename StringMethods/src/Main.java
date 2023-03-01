
public class Main {

	public static void main(String[] args) {
		// String = a reference data type that can store one or more characters
		// reference data types have access to useful methods

		String myName = "Rein              ";
		boolean resultBool = myName.equalsIgnoreCase("rein");
		System.out.println(resultBool);

		int resultNum = myName.length();
		System.out.println(resultNum); // 4

		char resultChar = myName.charAt(0); // R
		System.out.println(resultChar);

		int resultIndex = myName.indexOf("e"); // 1
		System.out.println(resultIndex);

		boolean resultEmpty = myName.isEmpty(); // false
		System.out.println(resultEmpty);

		String nameUpperCase = myName.toUpperCase();
		System.out.println(nameUpperCase);

		String nameLowerCase = myName.toLowerCase();
		System.out.println(nameLowerCase);

		String resultTrim = myName.trim(); // removes whitespace
		System.out.println(resultTrim);

		String resultReplace = myName.replace('e', 'a'); // replaces a single char in myName
		System.out.println(resultReplace);
	}

}


public class GenericsMain {

	public static void main(String[] args) {

		/*
		 * Generics : enables types (classes and interfaces) to be parameters when
		 * defining: classes, interfaces, and methods
		 * 
		 * A benefit is to eliminate the need to create multiple versions of methods or
		 * classes for various data types. Use 1 version for all reference data types.
		 */

		// Arrays that have reference data types
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 5.5, 4.4, 3.3, 2.2, 1.1 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		String[] stringArray = { "B", "Y", "E" };

		System.out.println("[Printing Elements without Generics]");
		printIntArray(intArray);
		printDoubleArray(doubleArray);
		printCharArray(charArray);
		printStringArray(stringArray);

		// Printing the array elements with only 1 methods, regardless of data type
		System.out.println("[Printing Elements using Generics]");
		printRefArray(intArray);
		printRefArray(doubleArray);
		printRefArray(charArray);
		printRefArray(stringArray);

		System.out.println("[Returning First Element with Generics]");
		System.out.println(getFirstElement(intArray));
		System.out.println(getFirstElement(doubleArray));
		System.out.println(getFirstElement(charArray));
		System.out.println(getFirstElement(stringArray));

	}

	// method that uses generics to print the different elements in our arrays
	public static <Thing> void printRefArray(Thing[] referenceArray) { // accepts any reference array

		for (Thing i : referenceArray) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	// method that returns the first element in an array regardless of data type
	public static <Thing> Thing getFirstElement(Thing[] referenceArray) {

		return referenceArray[0]; // returns the first element in our array

	}

	// method that prints the elements of an Integer array
	public static void printIntArray(Integer[] intArray) {

		for (Integer i : intArray) { // using a for each loop to print array elements
			System.out.print(i + " ");
		}
		System.out.println();

	}

	// method that prints the elements of a Double array
	public static void printDoubleArray(Double[] doubleArray) {

		for (Double i : doubleArray) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	// method that prints the elements of a Character array
	public static void printCharArray(Character[] charArray) {

		for (Character i : charArray) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	// method that prints the elements of a String array
	public static void printStringArray(String[] stringArray) {

		for (String i : stringArray) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}

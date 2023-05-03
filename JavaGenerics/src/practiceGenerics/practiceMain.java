package practiceGenerics;

public class practiceMain {

	public static void main(String[] args) {

		Integer[] intArr = { 1, 3, 5, 7, 9 };
		Double[] doubleArr = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Character[] charArr = { 'R', 'E', 'I', 'N', 'E' };
		String[] stringArr = { "Alpha", "Beta", "Charlie", "Delta", "Echo" };

		System.out.println("[Printing Reference Arrays with Generics]");
		printReferenceArrray(intArr);
		printReferenceArrray(doubleArr);
		printReferenceArrray(charArr);
		printReferenceArrray(stringArr);

		System.out.println(printFirstElement(intArr));
		System.out.println(printFirstElement(doubleArr));
		System.out.println(printFirstElement(charArr));
		System.out.println(printFirstElement(stringArr));

		GenericClass<Integer> myInt = new GenericClass<Integer>(1);
		GenericClass<Double> myDouble = new GenericClass<Double>(3.14);
		GenericClass<Character> myChar = new GenericClass<Character>('R');
		GenericClass<String> myString = new GenericClass<String>("Rein");

		System.out.println("\n[Calling Object Methods with Generic Classes]");
		myInt.printValue();
		myDouble.printValue();
		myChar.printValue();
		myString.printValue();

		GenericClassDouble<Integer, Integer> myIntDouble = new GenericClassDouble<Integer, Integer>(1, 3);
		GenericClassDouble<Double, Double> myDoubleDouble = new GenericClassDouble<Double, Double>(1.1, 2.2);
		GenericClassDouble<Character, String> myCharStringDouble = new GenericClassDouble<Character, String>('$',
				"Rein>");
		GenericClassDouble<String, Integer> myStringIntegerDouble = new GenericClassDouble<String, Integer>("Hello",
				523);

		System.out.println("\n[Calling Object Methods with Generic Classes with 2 Variables]");

		myIntDouble.printFirstVal();
		myIntDouble.printSecondVal();

		myDoubleDouble.printFirstVal();
		myDoubleDouble.printSecondVal();

		myCharStringDouble.printFirstVal();
		myCharStringDouble.printSecondVal();

		myStringIntegerDouble.printFirstVal();
		myStringIntegerDouble.printSecondVal();

	}

	// printing all of our reference arrays with one method
	public static <T> void printReferenceArrray(T[] paraArr) {

		for (T i : paraArr) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	public static <T> T printFirstElement(T[] paraArr) {

		return paraArr[0];

	}

}

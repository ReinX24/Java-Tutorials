package exampleBroCode;

public class ExampleMain {

	public static void main(String[] args) {

		/*
		 * Bounded types : you can create the objects of a generic class to have data of
		 * specified derived types ex. Number
		 */

		MyIntegerClass myInt = new MyIntegerClass(1);
		MyDoubleClass myDouble = new MyDoubleClass(3.14);
		MyCharacterClass myChar = new MyCharacterClass('@');
		MyStringClass myString = new MyStringClass("Hello");

		System.out.println("[Using Specific Classes]");
		System.out.println(myInt.getValue());
		System.out.println(myDouble.getValue());
		System.out.println(myChar.getValue());
		System.out.println(myString.getValue());

		MyGenericClass<Integer, Integer> genInt = new MyGenericClass<>(2, 4);
		MyGenericClass<Double, Double> genDouble = new MyGenericClass<>(2.68, 1.34);
		MyGenericClass<Character, Character> genChar = new MyGenericClass<>('$', '@');
		MyGenericClass<String, Character> genString = new MyGenericClass<>("World", '!');

		System.out.println("[Using Generic Classes]");
		System.out.println(genInt.getValue());
		System.out.println(genDouble.getValue());
		System.out.println(genChar.getValue());
		System.out.println(genString.getValue());

		System.out.println("[Using Generic Classes with 2 Parameters]");
		System.out.println(genInt.getValue2());
		System.out.println(genDouble.getValue2());
		System.out.println(genChar.getValue2());
		System.out.println(genString.getValue2());

		// First parameter in our NumberGenericClass should be under the Number class
		NumberGenericClass<Number, String> genNumOne = new NumberGenericClass<Number, String>(5, "Hello");
		NumberGenericClass<Number, Character> genNumTwo = new NumberGenericClass<Number, Character>(12, '&');

		System.out.println("[Using Generic Classes with Specified Generic Parameters]");
		System.out.println(genNumOne.getValue() + " : " + genNumOne.getValue2());
		System.out.println(genNumTwo.getValue() + " : " + genNumTwo.getValue2());

	}

}

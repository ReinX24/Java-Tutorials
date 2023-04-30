
public class LambdaMain {

	public static void main(String[] args) {

		/*
		 * lambda expression = feature for Java 8 and above also known as an anonymous
		 * method a shorter way to write anonymous classes with only one method
		 *
		 * need to use a functional interface or use a pre-defined functional interface
		 * they contain only one abstract method ex. ActionListener, Runnable,
		 * (user-defined)
		 *
		 * A Lambda expression can be used in any place where a functional interface is
		 * required How to use a lambda expression: (arguments) -> {statement/s}
		 */

		String userName = "Rein";
		char userSymbol = '!';

		// Creating a MyInterface object
		// variable names in these parameters must not be the same as the actual
		// variable names
		MyInterface interfaceOne = (myString, myChar) -> {
			// creates sayMessage in MyInterface
			System.out.println("Hello World!");
			System.out.println("Quite a nice day " + myString + myChar);
		};

		interfaceOne.sayMessage(userName, userSymbol);
		
		MyInterface interfaceTwo = (myString, myChar) -> {
			
			System.out.println("Good Day!");
			System.out.println("Nice to meet you " + myString + myChar);
			
		};
		
		interfaceTwo.sayMessage(userName, userSymbol);

	}

}

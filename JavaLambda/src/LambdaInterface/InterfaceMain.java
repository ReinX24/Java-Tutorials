package LambdaInterface;

public class InterfaceMain {

	public static void main(String[] args) {

		/*
		 * Basically, a lambda expression is a shorter way of using a method of an
		 * interface
		 */

		// Creating an interface object and using its methods using a lambda expression

		String myName = "Rein";
		char mySymbol = ';';

		Greeting testOne = (userName, userSymbol) -> {

			System.out.println("Nice to meet you " + userName);
			System.out.println("Your symbol is: " + userSymbol);

		};

		testOne.sayGreeting(myName, mySymbol);

		String testName = "Nikole";
		char testChar = '#';

		Greeting testTwo = (userName, userSymbol) -> {

			System.out.println("Hello " + userName + "!");
			System.out.println("Given symbol is: " + testChar);

		};

		testTwo.sayGreeting(testName, testChar);

	}

}

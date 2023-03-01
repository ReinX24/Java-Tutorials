
public class Main {

	public static void main(String[] args) {
		// method = a block of code that is executed whenever it is called upon
		String myName = "Rein";
		int myAge = 19;
		printHello(myName, myAge); // passing in myName in parameter

		// method that returns a value
		int x = 3;
		int y = 4;
		int resultNum = addNum(x, y); // adding the two values in a method
		System.out.println(resultNum); // print resultNum
	}

	static void printHello(String paramName, int paramAge) { // no need for public before static
		System.out.println("Hello " + paramName + "!");
		System.out.println("You are " + paramAge + " years old!");
	}

	static int addNum(int x, int y) {
		return x + y;
	}

}

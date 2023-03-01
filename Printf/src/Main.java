
public class Main {

	public static void main(String[] args) {
		// printf() = 	an optional method to control, format, and display text to the console window
		//				two arguments = format string + (object/variable/value)
		//				% [flags] [precision] [width] [conversion-character]
		System.out.printf("%d This is a format String\n", 123);

		boolean myBoolean = true;
		char myChar = '$';
		String myString = "Rein";
		int myInt = 5;
		double myDouble = 10000000;

		System.out.printf("This is a boolean: %b\n", myBoolean);
		System.out.printf("This is a char: %c\n", myChar);
		System.out.printf("This is a String: %s\n", myString);
		System.out.printf("This is a integer: %d\n", myInt);
		System.out.printf("This is a double: %f\n", myDouble);
		
		//[width]
		// minimum number of characters to be written as output
		System.out.printf("Hello %10s\n", myString); // reserves 10 characters

		//[precision]
		// sets number of digits of precision when outputting floating-point values
		System.out.printf("You have this much money: %.1f\n", myDouble); // rounds decimal by 1
		
		// [flags]
		// adds an effect to output based on the flag added to format specifier
		// - : left-justify
		// + : output a plus ( + ) or minus ( - ) sign for a numeric value
		// 0 : numeric values are zero-padded
		// , : comma grouping separator if numbers > 1000
		System.out.printf("You have this much money: %020.2f\n", myDouble); // prints 0s before the number
		System.out.printf("You have this much money: %,.0f\n", myDouble); // adds comma & rounds off

	}
	
}

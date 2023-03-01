
public class Main {

	public static void main(String[] args) {
		// Expressions: operands & operators
		// Operands: values, variables, numbers, and quantity
		// Operators: +, -, *, /

		int friendsAmount = 10;
		// Adding one friend
		friendsAmount = friendsAmount + 1;
		System.out.println(friendsAmount);
		// Subtracting one friend
		friendsAmount = friendsAmount - 1;
		System.out.println(friendsAmount);
		// Multiplying friends
		friendsAmount = friendsAmount * 2;
		System.out.println(friendsAmount);
		// Dividing friends
		friendsAmount = friendsAmount / 3;
		System.out.println(friendsAmount); // 6
		// Performing the module operator on friends
		friendsAmount = friendsAmount % 5;
		System.out.println(friendsAmount); // remainder of 1
		
		// Incrementing 
		friendsAmount++;
		System.out.println(friendsAmount); // 2
		// Decrementing
		friendsAmount--;
		System.out.println(friendsAmount); // 1
		
		// Integer division
		int numOne = 10;
		numOne = numOne / 3;
		System.out.println(numOne); // 3
		
		// Double division
		double numTwo = 10;
		numTwo = numTwo / 3;
		System.out.println(numTwo); // 3.33...
	}

}

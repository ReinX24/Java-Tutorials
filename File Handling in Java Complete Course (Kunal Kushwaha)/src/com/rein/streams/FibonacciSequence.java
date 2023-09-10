package com.rein.streams;

import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {
		// This is an example of using InputStreams by entering inputs through our
		// program using the Scanner class
		// Generates fibonacci sequence up to a certain index
		System.out.print("Enter fibonacci index number: ");
		Scanner userInput = new Scanner(System.in);
		int endCount = userInput.nextInt();

		int firstNum = 0;
		int secondNum = 1;

		for (int i = 0; i <= endCount; i++) {
			System.out.println(firstNum + " ");
			int nextNum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = nextNum;
		}

		userInput.close();
	}

}

package com.rein.lamdaFunctions;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {

//	static Operation sumOne = (a, b) -> a + b;
	
	public static void main(String[] args) {

		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			numList.add(i + 1);
		}

		// Example of using a lambda function
//		numList.forEach((eachElement) -> {
//			System.out.println(eachElement * 2);
//		});

		Consumer<Integer> doubleNum = (eachElement) -> System.out.println(eachElement * 2);
//		numList.forEach(doubleNum);

		// Creating an Operation object and implementing its methods
		Operation sumOne = (a, b) -> a + b;
//		System.out.println(sumOne.operateInteger(5, 3)); // 8

		Operation differenceOne = (a, b) -> a - b;
//		System.out.println(differenceOne.operateInteger(7, 3)); // 4

		Operation productOne = (a, b) -> a * b;
//		System.out.println(productOne.operateInteger(5, 4)); // 20

		Operation quotientOne = (a, b) -> a / b;
//		System.out.println(quotientOne.operateInteger(10, 2)); // 5

		Main myCalculator = new Main();
		System.out.println(myCalculator.operateNum(5, 3, sumOne)); // 8
		System.out.println(myCalculator.operateNum(5, 3, productOne)); // 15
		System.out.println(myCalculator.operateNum(5, 3, differenceOne)); // 2
	}

	private static int operateNum(int a, int b, Operation opObj) {
		return opObj.operateInteger(a, b);
	}

}

// This is an interface for lambda functions
interface Operation {
	int operateInteger(int a, int b);
}

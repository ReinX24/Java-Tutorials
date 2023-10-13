package com.rein.geeksforgeeks;

import java.util.ArrayList;

public class GenericsMain {

	public static void main(String[] args) {

		// Generic Classes
//		Test<Integer> testOne = new Test<Integer>(1);
//		System.out.println(testOne.getTestObject());

//		Test<Character> testTwo = new Test<Character>('A');
//		System.out.println(testTwo.getTestObject());

		// Generic Classes with multiple parameters
//		MultipleGenericParameters<String, Integer> multipleOne = new MultipleGenericParameters<String, Integer>("Rein", 20);
//		System.out.println(multipleOne.getFirstParameter());
//		System.out.println(multipleOne.getSecondParameter());

		// Generic methods
//		Test.displayGeneric(5);
//		Test.displayGeneric("Rein");
//		Test.displayGeneric(25.5);

		// Different Type parameters cannot be reassigned
//		Test<Integer> intTest = new Test<Integer>(5);
//		Test<Character> charTest = new Test<Character>('A');
//		intTest = charTest; // throws an error

		// Common Type Parameters in Java Generics
		// T – Type, E – Element, K – Key, N – Number, V – Value
		
		// Type casting is not needed, we can get values using indexes
//		ArrayList<String> listOne = new ArrayList<>();
//		listOne.add("Rein");
//		listOne.add("Nikole");
		
//		System.out.println(listOne.get(0));
//		System.out.println(listOne.get(1));

	}

}

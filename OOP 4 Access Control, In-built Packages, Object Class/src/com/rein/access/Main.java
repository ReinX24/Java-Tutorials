package com.rein.access;

import java.util.ArrayList;
import java.util.Collections;

//import java.util.*; // for ArrayList class

public class Main {

	public static void main(String[] args) {
		A aObj = new A(20, "Rein");
		// Things to do:
		// 1. access the data members
		// 2. modify the data members
//		aObj.printAttributes();

//		ArrayList<Integer> intList = new ArrayList<>();
//		intList.DEFAULT_CAPACITY; // cannot be accessed because it is a private variable

//		System.out.println(aObj.aNum); // cannot print this variable because it is a private variable

		System.out.println(aObj.aString); // we can access this because it is in the same package
		System.out.println(aObj.aArr); // can be accessed, has the protected access modifier

		// Using getters to access object variables
		System.out.println(aObj.getInt());
		
	}

}

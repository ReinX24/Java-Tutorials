package com.rein.otherPackageExample;

import com.rein.access.*;

public class Main extends A {

	public Main(int aNum, String aString) {
		super(aNum, aString);
	}

	public static void main(String[] args) {
		A aObj = new A(20, "Rein");
//		System.out.println(aObj.aString); 
		// Cannot be printed because it has the default access modifier and this is in a
		// different package

		// Cannot be accessed because the protected keyword only applies for child
		// classes
		// that are outside of its original package
		// Different package but not subclass does not work for protected keyword
//		System.out.println(aObj.aArr); 

		Main mainOne = new Main(20, "Rein");
		// Can be accessed because this is a subclass and aArr is a protected variable
		System.out.println(mainOne.aArr);

	}

}

class MainSubClass extends Main {

	public MainSubClass(int aNum, String aString) {
		super(aNum, aString);
	}

	public static void main(String[] args) {
		MainSubClass mainSubOne = new MainSubClass(20, "Rein");
		// Child classes of a child class can access protected variables from the parent
		// class too
		System.out.println(mainSubOne.aArr);
	}

}

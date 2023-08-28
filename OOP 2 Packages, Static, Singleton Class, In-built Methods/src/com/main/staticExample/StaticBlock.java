package com.main.staticExample;

// Initialization of static variables
public class StaticBlock {
	static int a = 4;
	static int b;

	// This runs when the StaticBlock class is made, this will run regardless if an
	// object of the class is made or not
	// This will only run once
	static {
		System.out.println("I am in static block");
		b = a * 5; // 20
	}

	public static void main(String[] args) {
//		StaticBlock objOn = new StaticBlock();
		// No object creation is needed to call the static method
		System.out.println(StaticBlock.a + " " + StaticBlock.b); // 4 20

		StaticBlock.b += 3; // adds 3 to b
//		StaticBlock objTwo = new StaticBlock();
		System.out.println(StaticBlock.a + " " + StaticBlock.b); // 4 23
		// The static method is only called when the StaticBlock class is loaded, not
		// when an object is being made
	}

}

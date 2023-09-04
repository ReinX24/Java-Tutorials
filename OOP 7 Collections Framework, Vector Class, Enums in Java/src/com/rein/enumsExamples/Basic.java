package com.rein.enumsExamples;

public class Basic {

	enum Week implements Greetings {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
		// These are enum constants
		// All of these elements are public, static, and final
		// Cannot create child enums
		// Type is week

		// This cannot be public or protected, can either be private or default
		// This is because we do not want to create new objects in other packages
		// This iterates through all of our elements when a new Week object is being
		// made
		Week() {
			System.out.println("Constructor called for: " + this);
		}
		// This is what happens internally when the constructor is called
		// public static final Week Monday = new Week();

		@Override
		public void hello() {
			System.out.println("Hello there!");
		}

	}

	public static void main(String[] args) {

		Week dayOne;
		System.out.println("Calling constructor...");
		dayOne = Week.Monday; // constructor is called here
		dayOne.hello();

		System.out.println(dayOne); // prints Monday
//		System.out.println(dayOne.ordinal()); // prints 0
		System.out.println(Week.valueOf("Monday")); // prints Monday

//		for (Week eachDay : Week.values()) {
//			System.out.println(eachDay);
//		}

	}

}

package com.main.staticExample;

//class Test {
//	static String name;
//
//	public Test(String name) {
//		Test.name = name;
//	}
//}

public class InnerClass { // outside classes cannot be static

	static class Test { // inner classes need to be static
		String name;

		public Test(String name) {
			this.name = name;
		}
		
		// Overriding the built in toString method
		@Override
		public String toString() {
			return "Name: " + this.name;
		}

	}

	public static void main(String[] args) {
		// This is cannot call Test class because it is dependent on the outer class
		// This will only work if our Test class is static
		// Even though the Test class is static, the variables within it are still
		// instance variables, which means that their attributes will be independent on
		// each object
		Test objOne = new Test("Rein");
		Test objTwo = new Test("Nikole");
		System.out.println(objOne.name);
		System.out.println(objTwo.name);
		System.out.println(objOne.toString());
		System.out.println(objTwo.toString());
		// When the Test class is outside of InnerClass, we can create object normally
		// without it being static. On the other hand, if it is inside InnerClass it is
		// now dependent on the InnerClass, which means we cannot call the Test class
		// directly if it is not static.
	}
}

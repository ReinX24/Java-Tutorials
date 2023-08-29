package com.main.polymorphism;

public class Numbers {

	// Example of constructor overloading
	public double addSum(double a, int b) { // converts integer to double automatically
		return a + b;
	}

	public int addSum(int a, int b) {
		return a + b;
	}

	public int addSum(int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String[] args) {

		Numbers sumOne = new Numbers();
		System.out.println(sumOne.addSum(1, 2));
		System.out.println(sumOne.addSum(1, 2, 3));

	}

}

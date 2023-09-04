package com.rein.exceptionHandling;

public class Demo {

	public static void main(String[] args) {
		Main.divide(3, 0); // prints stack trace but with the custom message in divide method
	}

}

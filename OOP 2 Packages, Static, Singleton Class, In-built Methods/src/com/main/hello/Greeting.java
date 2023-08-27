package com.main.hello;

// importing a method from another class inside this package
import static com.main.hello.Message.message;

public class Greeting {
	public static void main(String[] args) {
		System.out.println("Hello World");
		message(); // this is from our Message class
	}
}

package com.rein.extendDemoOne;

public class Main implements InterfaceTwo {

	public static void main(String[] args) {
		Main mainOne = new Main();
		mainOne.fun();
		mainOne.greet();
	}
	
	// We will need to import 2 methods, this is because InterfaceTwo extends
	// InterfaceOne which has the fun method and InterfaceTwo has the greet method
	@Override
	public void fun() {
		System.out.println("I love Java programming!");
	}

	@Override
	public void greet() {
		System.out.println("Hello, World!");
	}

}

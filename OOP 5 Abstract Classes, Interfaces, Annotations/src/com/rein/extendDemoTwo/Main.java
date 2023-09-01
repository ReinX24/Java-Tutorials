package com.rein.extendDemoTwo;

public class Main implements InterfaceTwo, InterfaceOne {

	public static void main(String[] args) {
		Main mainOne = new Main();
		mainOne.fun();
		mainOne.greet();
		mainOne.editor();
		
		// Calling a static method using the interface name
		InterfaceOne.getInterfaceName();
	}

	@Override
	public void greet() {
		System.out.println("Hello, World!");
	}

	// InterfaceOne fun() method is being used
//	@Override
//	public void fun() {
//		InterfaceOne.super.fun();
//	}

	// InterfaceTwo fun() method is being used
	@Override
	public void fun() {
		InterfaceTwo.super.fun();
	}

	// I probably won't do this because it makes the code more confusing to read. I
	// would rather just make sure that these interfaces aren't too similar to each
	// other to a point where their methods have the same name.

}

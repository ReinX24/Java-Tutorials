package com.rein.extendDemoTwo;

public interface InterfaceOne {

	// Using the default keyword to set default code for method
	// This means that we do not need to add these methods when we are using this
	// interface in a class
	// We also cannot set these to private or protected, interface methods can
	// either only be default or static
	default void fun() {
		System.out.println("I love Functional programming");
	};

	// Static methods cannot be inherited or overriden
	static void getInterfaceName() {
		System.out.println("InterfaceOne");
	}

}

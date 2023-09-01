package com.rein.extendDemoTwo;

public interface InterfaceTwo {

	void greet();

	default void fun() {
		System.out.println("I love Object oriented programming");
	};

	// Does not conflict with InterfaceOne since InterfaceOne does not have a
	// default method named editor()
	default void editor() {
		System.out.println("I use VIM btw");
	}

}

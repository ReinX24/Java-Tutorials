package com.main.polymorphism;

public class Shapes {

	void shapeArea() {
		System.out.println("I am in Shapes");
	}

	// When the final keyword is added, this method cannot be overwritten in child
	// classes. This is called early binding since it tells the compiler that this
	// method is constant and that it will not need to check if it is overwritten
	// in other classes.
//	final void shapeArea() {
//		System.out.println("I am in shapes");
//	}

}

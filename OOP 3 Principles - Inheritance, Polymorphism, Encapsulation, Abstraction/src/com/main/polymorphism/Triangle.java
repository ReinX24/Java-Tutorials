package com.main.polymorphism;

public class Triangle extends Shapes {

	@Override
	void shapeArea() {
		System.out.println("Area is 0.5 * h * b");
	}

}

package com.main.polymorphism;

public class Main {

	public static void main(String[] args) {

		// Objects that are declared as Shape objects but initialized as various objects
		Shapes shapeOne = new Shapes();
		Shapes circleOne = new Circle();
		Shapes triangleOne = new Triangle();
		Shapes squareOne = new Square();

		// These all have different print statements, this is because in these classes,
		// we override the original method inside the Shapes class
		shapeOne.shapeArea();
		circleOne.shapeArea();
		triangleOne.shapeArea();
		squareOne.shapeArea();
		

	}

}

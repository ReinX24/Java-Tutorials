package com.rein.access;

public class ObjectDemo {

	public static void main(String[] args) {

		ObjectDemo objDemoOne = new ObjectDemo(12, 56.8f);
//		System.out.println(objDemoOne.hashCode()); // a unique representation of an object via a number

		ObjectDemo objDemoTwo = new ObjectDemo(12, 78.9f);
//		System.out.println(objDemoTwo.hashCode()); // different hash code because they are different objects
		// Hash code is not the address of the object in memory, it is just a random set
		// of numbers that represent an object

//		ObjectDemo objDemoThree = objDemoTwo;
//		System.out.println(objDemoThree.hashCode()); // will have the same hash code of objDemoTwo

		// Using the equals method
		// This checks if the two objects refer to the same variable or points to the
		// same address
		if (objDemoOne == objDemoTwo) {
			System.out.println("objDemoOne is equal to objDemoTwo");
		}

		// This checks if the two objects' values are the same
		if (objDemoOne.equals(objDemoTwo)) {
			System.out.println("objDemoOne is equal to objDemoTwo");
		}

		System.out.println(objDemoOne.getClass()); // returns class and path to class in package
		System.out.println(objDemoOne.getClass().getName()); // returns package and class

	}

	int objNum;
	float objFloat;

	public ObjectDemo(int objNum, float objFloat) {
		this.objNum = objNum;
		this.objFloat = objFloat;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.objNum == ((ObjectDemo) obj).objNum; // converts Object to ObjectDemo
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

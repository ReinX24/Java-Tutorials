package com.rein.objectCloning;

public class Main {

	public static void main(String[] args) {

		Human rein = new Human(20, "Rein Solis");
//		Human twin = new Human(rein); // cloning another Object's attributes to another Object
		Human twin = null;
		try {
			twin = (Human) rein.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

//		System.out.println(rein); // equivalent to calling toString() method
//		System.out.println(twin);
//		twin.numArr[0] = 10; // this changes for both rein and twin, this an example of shallow copying
//		System.out.println(rein); // 10, 2, etc.
//		System.out.println(twin);// 10, 2, etc
		// This happens because non primitive data types such as arrays references to
		// another object's attributes instead of creating new attributes (primitive
		// data types create their new attributes when copying to an object).

		// This is fixed when we instead make a deep copy of the object instead of a
		// shallow copy
		System.out.println(rein);
		System.out.println(twin);
		twin.numArr[0] = 20;
		twin.humanName = "Marc Solis";
		System.out.println(rein); // name and array are unchanged
		System.out.println(twin); // name and array are changed
	}

}

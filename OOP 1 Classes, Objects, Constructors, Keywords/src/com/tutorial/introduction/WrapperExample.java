package com.tutorial.introduction;

final public class WrapperExample {

	public static void main(String[] args) {
		int a = 10; // this is not an object
		int b = 20;
		Integer intOne = 10; // this is an object
		Integer intTwo = 20;
//		System.out.println(intOne.byteValue()); // our Integer object has built in methods because it is an object

		// This does not work because these are primitive data types
		swap(a, b);
//		System.out.println(a + " " + b);

		// This also does not swap, the reason for this is because the Integer class is
		// final and its values are immutable
		swapInteger(intOne, intTwo);
//		System.out.println(intOne + " " + intTwo);

		// The final keyword
		// final primitive data types
		final int FINAL_NUM = 2;
//		FINAL_NUM = 5; // throws an error
		System.out.println(FINAL_NUM);

		// When final is applied to objects, we can still change their attributes
		final Student studentExample = new Student();
		studentExample.studentName = "Rein";
		System.out.println(studentExample.studentName);

		Student otherStudent = new Student();
//		studentExample = otherStudent; // will throw an error because we cannot re-assign a final object
		System.out.println(otherStudent.studentName);

		final A rein = new A("Rein");
		rein.nameStr = "Aldwin";
		// When a non primitive data type is final, you cannot re-assign it but you can
		// change its values
//		rein = new A("Rain"); // we cannot initialize the object again due to the final keyword

		A objA = new A("New Object");

		// Removing and adding objects to memory, we overflow our memory by creating an
		// object over and over again which overflows our memory and destroys unused
		// objects. This will call the custom finalize method in our A class
//		for (int i = 0; i < 1000000000; i++) {
//			objA = new A("Random Name");
//		}
		
		// Destroying an object manually
		try {
			objA.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	static void swapInteger(Integer a, Integer b) {
		Integer temp = a;
		a = b;
		b = temp;
	}

}

class A {
//	final int num = 10; // will throw an error if it is not initialized, always initialize when declaring a final variable
	String nameStr;

	public A(String nameStr) {
		this.nameStr = nameStr;
	}

	// This finalize object will be called whenever an A object is removed from
	// memory
	@Override
	protected void finalize() throws Throwable {
//			super.finalize();
		System.out.println("Object is destroyed");
	}
}

package com.rein.geeksforgeeks;

public class Test<T> {

	T testObject;

	public Test(T testObject) {
		this.testObject = testObject;
	}

	public static <T> void displayGeneric(T testObject) {
		System.out.println(testObject.getClass().getName() + " : " + testObject);
	}

	public T getTestObject() {
		return testObject;
	}

	public void setTestObject(T testObject) {
		this.testObject = testObject;
	}

}

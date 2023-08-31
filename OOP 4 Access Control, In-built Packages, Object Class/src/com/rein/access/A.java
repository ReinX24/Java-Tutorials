package com.rein.access;

import java.util.Arrays;

public class A {

	private int aNum; // can only be accessed in this class
	String aString; // can only be accessed by classes in the same package
	protected int[] aArr; // can be accessed by subclasses in different packages

	public A(int aNum, String aString) {
		this.aNum = aNum;
		this.aString = aString;
		this.aArr = new int[aNum];
	}

	public void printAttributes() {
		System.out.println(
				"[" + "aNum=" + this.aNum + ",aString=" + this.aString + ",aArr=" + Arrays.toString(aArr) + "]");
	}

	// Getter methods
	public int getInt() {
		return this.aNum;
	}

	public String getString() {
		return this.aString;
	}

	public int[] getArray() {
		return this.aArr;
	}

	// Setter methods
	public void setInt(int newNum) {
		this.aNum = newNum;
	}

	public void setString(String newString) {
		this.aString = newString;
	}

	public void setArray(int[] newArray) {
		this.aArr = newArray;
	}

}

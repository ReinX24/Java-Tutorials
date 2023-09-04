package com.rein.objectCloning;

import java.util.Arrays;

public class Human implements Cloneable {

	int humanAge;
	String humanName;
	int[] numArr;

	public Human(int humanAge, String humanName) {
		this.humanAge = humanAge;
		this.humanName = humanName;
		this.numArr = new int[] { 1, 2, 3, 4, 5 };
	}

	@Override
	public String toString() {
		return "Human [humanAge=" + humanAge + ", humanName=" + humanName + ", numArr=" + Arrays.toString(numArr) + "]";
	}

	// Shallow copy of clone method
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		// Shallow copying
//		return super.clone();
//	}

	// Deep copy
	@Override
	public Human clone() throws CloneNotSupportedException {

		// Human object to store copied data, copies data first using super.clone()
		Human newHuman = (Human) super.clone(); // this is actually shallow copying

		// Making a deep copy
		newHuman.numArr = new int[newHuman.numArr.length];
		for (int i = 0; i < numArr.length; i++) {
			newHuman.numArr[i] = this.numArr[i];
		}

		return newHuman;

	}

}

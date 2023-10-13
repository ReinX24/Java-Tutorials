package com.rein.teluskogenerics;

import java.util.ArrayList;

// This class only accepts Number and its child classes
public class Container<T extends Number> {

	private T value;

	public void showType() {
		System.out.println(value + " : " + value.getClass().getName());
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	// ? means any Object, in this case, we will be accepting Objects that are
	// Number types
	public void printGenericList(ArrayList<? extends Number> genericList) {
		System.out.println(genericList.getClass().getName());
	}

}

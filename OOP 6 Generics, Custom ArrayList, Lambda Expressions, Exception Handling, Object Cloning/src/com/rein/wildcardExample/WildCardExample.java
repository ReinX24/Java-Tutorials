package com.rein.wildcardExample;

import java.util.List;

// This class can only be instantiated with the Number class and its child classes (Integer, Float, etc.).
public class WildCardExample<T extends Number> {

	Object[] dataArr;
	final int DEFAULT_SIZE = 10;
	int dataSize = 0;

	public WildCardExample() {
		dataArr = new Object[DEFAULT_SIZE];
	}

	public void add(T newElem) {
		if (this.isFull()) {
			this.resize();
		}
		dataArr[dataSize++] = newElem;
	}

	private boolean isFull() {
		return dataSize == dataArr.length;
	}

	private void resize() {
		Object[] tempArr = new Object[dataArr.length * 2];
		for (int i = 0; i < dataArr.length; i++) {
			tempArr[i] = dataArr[i];
		}
		dataArr = tempArr;
	}

	public T remove() {
		return (T) dataArr[--dataSize];
	}

	public T get(int elemIndex) {
		return (T) dataArr[elemIndex];
	}

	private void set(int addIndex, T newElem) {
		if (addIndex > dataArr.length) {
			this.resize();
		}
		dataArr[addIndex] = newElem;
	}

	@Override
	public String toString() {
		return "WildCardExample{dataArr=" + convertArrayString() + ", dataSize=" + dataSize + "}";
	}

	public String convertArrayString() {
		StringBuilder convertedStrBuilder = new StringBuilder();
		convertedStrBuilder.append("[");
		for (int i = 0; i < dataSize - 1; i++) {
			convertedStrBuilder.append(dataArr[i] + ", ");
		}
		convertedStrBuilder.append(dataArr[dataSize - 1] + "]");
		return convertedStrBuilder.toString();
	}

	public static void main(String[] args) {

		WildCardExample<Integer> wildOne = new WildCardExample<>();
		for (int i = 0; i < 14; i++) {
			wildOne.add(2 * i);
		}
		System.out.println(wildOne.toString());

//		WildCardExample<String> wildTwo = new WildCardExample<>(); // String is not part of the Number class

		WildCardExample<Float> wildThree = new WildCardExample<>();
		wildThree.add(0.1f);
		wildThree.add(0.3f);
		wildThree.add(0.5f);
		System.out.println(wildThree.toString());

	}

	// Another example of using Wildcards
	public void getList(List<? extends Number> paraList) {
		// Do something
		// This method can only accept Number types
	}

}

package com.rein.customGenericArrayList;

// The T in here stands for the type of Object passed in. We will be using this to check if the elements that we are adding, removing, etc are the same Object type as T.
public class CustomGenericArrayList<T> {

	Object[] dataList;
	final int DEFAULT_SIZE = 10;
	int dataSize;

	public CustomGenericArrayList() {
//		dataList = new T[DEFAULT_SIZE]; // this throws an error
		// This is because when this is being compiled at runtime, it does not know what
		// type of array it is instantiating as.k
		dataList = new Object[DEFAULT_SIZE];
	}

	public void add(T newElement) {
		if (this.isFull()) {
			this.resize();
		}
		dataList[dataSize++] = newElement;
	}

	private boolean isFull() {
		return dataSize == dataList.length;
	}

	private void resize() {
		Object[] tempArr = new Object[dataList.length * 2];
		for (int i = 0; i < dataList.length; i++) {
			tempArr[i] = dataList[i];
		}
		dataList = tempArr;
	}

	public T remove() {
		T removedNum = (T) dataList[--dataSize];
		return removedNum;
	}

	public T get(int numIndex) {
		return (T) dataList[numIndex];
	}

	public int size() {
		return dataSize;
	}

	public void set(int numIndex, T newElement) {
		dataList[numIndex] = newElement;
	}

	@Override
	public String toString() {
		return "CustomGenericArrayList{numArr=" + convertArrayString() + ", dataSize=" + dataSize + "}";
	}

	public String convertArrayString() {
		StringBuilder convertedStrBuilder = new StringBuilder();
		convertedStrBuilder.append("[");
		// Adds all elements to convertedStr except for the last element
		for (int i = 0; i < dataSize - 1; i++) {
			convertedStrBuilder.append(dataList[i] + ", ");
		}
		// Returning convertedStr with the last element
		convertedStrBuilder.append(dataList[dataSize - 1] + "]");
		return convertedStrBuilder.toString();
	}

	public static void main(String[] args) {

		CustomGenericArrayList<Integer> intListOne = new CustomGenericArrayList<>();

		for (int i = 0; i < 14; i++) {
			intListOne.add(2 * i);
		}

		System.out.println(intListOne.toString());

	}

}

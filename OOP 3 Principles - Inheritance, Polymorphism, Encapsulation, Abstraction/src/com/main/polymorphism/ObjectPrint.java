package com.main.polymorphism;

public class ObjectPrint {

	int objectNum;

	public ObjectPrint(int objectNum) {
		this.objectNum = objectNum;
	}

	@Override
	public String toString() {
		return "ObjectPrint{" + "objectNum=" + objectNum + "}";
	}

	public static void main(String[] args) {
		ObjectPrint objOne = new ObjectPrint(54);

		System.out.println(objOne);
	}

}

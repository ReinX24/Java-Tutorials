package com.rein.access;

public class ObjectDemo {

	public static void main(String[] args) {
	
		int startTime = (int) System.nanoTime();
		ObjectDemo objDemoOne = new ObjectDemo(42);
		int endTime = (int) System.nanoTime();
		System.out.println("Run time: " + (endTime - startTime) + "ns");
		
	}

	int objNum;

	public ObjectDemo(int objNum) {
		this.objNum = objNum;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

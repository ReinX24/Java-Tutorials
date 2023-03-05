package packageTwo;

import packageOne.*; // imports all classes from packageOne

public class Asub extends A {
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.defaultStr); // can be displayed since it is in the same package
		
		Asub aSubClass = new Asub();
		System.out.println(aSubClass.protectedStr); // can be accessed since this is a subclass of A
	}
}

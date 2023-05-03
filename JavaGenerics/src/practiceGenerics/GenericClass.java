package practiceGenerics;

public class GenericClass<T> {

	T myValue;

	public GenericClass(T paraValue) {
		myValue = paraValue;
	}

	public <T> void printValue() {
		System.out.println(myValue);
	}

}

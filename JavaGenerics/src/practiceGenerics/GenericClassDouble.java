package practiceGenerics;

public class GenericClassDouble<T, V> {

	T firstValue;
	V secondValue;

	public GenericClassDouble(T firstValue, V secondValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

	public <T> void printFirstVal() {
		System.out.println(firstValue);
	}

	public <T> void printSecondVal() {
		System.out.println(secondValue);
	}

}

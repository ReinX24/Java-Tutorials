
// Turning our interface into a functional interface

@FunctionalInterface // requires our interface to at least have 1 method
public interface MyInterface {

	public void sayMessage(String userName, char userSymbol); // adding a method to our interface

}

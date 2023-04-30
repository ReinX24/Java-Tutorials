package practiceInnerClasses;

public class Main {

	public static void main(String[] args) {

		// Creating and accessing OuterClass objects and variables
		OuterClass myOuterClass = new OuterClass();
		System.out.println(myOuterClass.outerClassString);
		
		// Creating and accessing InnerClass objects, variables, and methods
		OuterClass.InnerClass myInnerClass = myOuterClass.new InnerClass();
		System.out.println(myInnerClass.innerClassString);
		myInnerClass.printFooBar(); // InnerClass method
		
	}

}

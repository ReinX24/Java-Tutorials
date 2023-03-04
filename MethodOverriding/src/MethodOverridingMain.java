
public class MethodOverridingMain {

	public static void main(String[] args) {
		// method overriding = Declaring a method in sub class,
		// which is already present in parent class.
		// done so that a child class can give its own implementation

		Animal animalTest = new Animal();
		animalTest.animalSpeak(); // using original method
		Dog dogOne = new Dog();
		dogOne.animalSpeak(); // using overriding method from Animal class
	}

}

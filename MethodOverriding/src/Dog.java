
public class Dog extends Animal {

	// Overrides method in animal class
	@Override // note that tells people method overrides method from parent class
	void animalSpeak() {
		System.out.println("The dog goes *bark*");
	}

}

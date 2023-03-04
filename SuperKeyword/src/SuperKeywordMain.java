
public class SuperKeywordMain {

	public static void main(String[] args) {
		// super = keyword refers to the superclass (parent) of an object
		// very similar to the "this" keyword

		Hero heroOne = new Hero("Batman", 42, "$$$");
		Hero heroTwo = new Hero("Superman", 43, "Everything");

		// All attributes are in heroOne even if the constructor is from Person class
		System.out.println(heroOne.personName);
		System.out.println(heroOne.personAge);
		System.out.println(heroOne.heroPower);
		
		System.out.println(heroTwo.toString());
	}

}


public class JavaConstructorsMain {

	public static void main(String[] args) {
		// Constructor: A special method that is called when an object is instantiated
		// or created

		// Creating Human objects
		Human humanOne = new Human("Rein", 19, 74.5);
		System.out.println(humanOne.humanName);

		Human humanTwo = new Human("Morty", 60, 50.4);
		System.out.println(humanTwo.humanName);

		humanOne.humanEat();
		humanTwo.humanDrink();
		
		humanOne.showHumanInfo();
		humanTwo.showHumanInfo();
	}

}

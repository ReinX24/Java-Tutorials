
// Creating an enum in our main file
enum Planet {

	// Adding objects to our enum and setting values for each object
	MERCURY(1), VENUS(2), EARTH(3), MARS(4), JUPITER(5), SATURN(6), URANUS(7), NEPTUNE(8), PLUTO(9);

	int planetNumber; // int variable for created Planet object

	Planet(int myNumber) { // constructor when creating a Planet object

		this.planetNumber = myNumber; // constructor assigns planetNumber with the Planet objects number

	}

}

public class EnumMain {

	public static void main(String[] args) {

		// enum : enumerated, ordered listing of items in a collection
		// is a grouping of constants that behave similarly to objects

		MyPlanets myPlanet = MyPlanets.EARTH; // creating a Planet object and selecting one of the choices

		canILiveHere(myPlanet);

		MyPlanets planetOne = MyPlanets.MARS;

		canILiveHere(planetOne);

	}

	// Method that accepts a Planet object as a parameter
	static void canILiveHere(MyPlanets myPlanet) {

		switch (myPlanet) {

		case EARTH:
			System.out.println("You can live here! :D");
			System.out.println("This is planet #" + myPlanet.planetNumber); // prints planet's number
			break;

		default:
			System.out.println("You can't live here... yet :(");
			System.out.println("This is planet #" + myPlanet.planetNumber);
			break;
		}

	}

}


enum MyPlanets {

	MERCURY(1), VENUS(2), EARTH(3), MARS(4), JUPITER(5), SATURN(6), URANUS(7), NEPTUNE(8), PLUTO(9);

	int planetNumber;

	MyPlanets(int myNumber) {
		
		this.planetNumber = myNumber;
		
	}

}

public class EnumPractice {

	public static void main(String[] args) {

		Planet myPlanet = Planet.EARTH;
		
		canILiveHere(myPlanet);
		
		Planet planetTestOne = Planet.MARS;
		
		canILiveHere(planetTestOne);

		Planet planetTestTwo = Planet.PLUTO;
		
		canILiveHere(planetTestTwo);
		
	}
	
	public static void canILiveHere (Planet myPlanet) {
		
		switch (myPlanet) {
		
			case EARTH:
				System.out.println("You can live here at " + myPlanet + "!");
				System.out.println("Planet #" + myPlanet.planetNumber);
				break;
				
			default:
				System.out.println("You cannot live at " + myPlanet +"!");
				System.out.println("Planet #" + myPlanet.planetNumber);
				break;
				
		}
		
	}

}

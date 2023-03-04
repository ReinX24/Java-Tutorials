
public class Hero extends Person {

	String heroPower;
	
	public Hero(String heroName, int heroAge, String heroPower) {
//		this.personName = heroName; // variables from Person class
//		this.personAge = heroAge;
		
		super(heroName, heroAge); // calls the constructor of the Parent class
		this.heroPower = heroPower; // variable in this class
	}
	
	public String toString() {
		// calling toString method from Person class
		return super.toString() + this.heroPower;
	}
	
}

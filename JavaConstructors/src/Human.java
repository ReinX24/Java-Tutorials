
public class Human {

	String humanName;
	int humanAge;
	double humanWeight;

	// Constructor for Human class
	Human(String humanName, int humanAge, double humanWeight) {
		this.humanName = humanName;
		this.humanAge = humanAge;
		this.humanWeight = humanWeight;
	}

	void humanEat() {
		System.out.println(this.humanName + " is eating!");
	}

	void humanDrink() {
		System.out.println(this.humanName + " is drinking! *burp*");
	}

	void showHumanInfo() {
		System.out.println("-------------------");
		System.out.printf("|%-8s:%-8s|\n", "Name", this.humanName);
		System.out.printf("|%-8s:%-8s|\n", "Age", this.humanAge);
		System.out.printf("|%-8s:%-8s|\n", "Weight", this.humanWeight);
		System.out.println("-------------------");
	}

}

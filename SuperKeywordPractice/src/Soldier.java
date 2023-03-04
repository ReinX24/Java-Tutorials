
public class Soldier {

	String soldierClass;
	int soldierHealth;
	String soldierWeapon;

	public Soldier(String soldierClass, int soldierHealth, String soldierWeapon) {
		this.soldierClass = soldierClass;
		this.soldierHealth = soldierHealth;
		this.soldierWeapon = soldierWeapon;
	}

	public String toString() {
		return "Class: " + this.soldierClass + "\nHealth: " + this.soldierHealth + "\nWeapon: " + this.soldierWeapon
				+ "\n";
	}

}

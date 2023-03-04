
public class Medic extends Soldier {

	int medkitAmount;
	int healBoost;

	public Medic(String soldierClass, int soldierHealth, String soldierWeapon, int medkitAmount, int healBoost) {
		super(soldierClass, soldierHealth, soldierWeapon);
		this.medkitAmount = medkitAmount;
		this.healBoost = healBoost;
	}

	public String toString() {
		return super.toString() + "Medkit Amount: " + this.medkitAmount + "\nHeal Boost Amount: " + this.healBoost
				+ "\n";
	}

}


public class Assault extends Soldier {

	int grenadeAmount;
	int speedBoostAmount;

	public Assault(String soldierClass, int soldierHealth, String soldierWeapon, int grenadeAmount,
			int speedBoostAmount) {
		super(soldierClass, soldierHealth, soldierWeapon);
		this.grenadeAmount = grenadeAmount;
		this.speedBoostAmount = speedBoostAmount;
	}

	public String toString() {
		return super.toString() + "Grenade Amount: " + this.grenadeAmount + "\nSpeed Boost Amount: "
				+ this.speedBoostAmount + "\n";
	}

}


public class Sniper extends Soldier {

	// Special attributes for this class
	int sniperScopeAmount;
	int stealthBoost;

	// Constructors for child classes
	public Sniper(String soldierClass, int soldierHealth, String soldierWeapon, int sniperScopeAmount,
			int stealthBoost) {
		super(soldierClass, soldierHealth, soldierWeapon); // calls constructor in Soldier method
		this.sniperScopeAmount = sniperScopeAmount;
		this.stealthBoost = stealthBoost;
	}

	// Calling toString method from Soldier class
	public String toString() {
		return super.toString() + "Scope Amount: " + this.sniperScopeAmount + "\nStealth Boost: " + this.stealthBoost
				+ "\n";
	}

}

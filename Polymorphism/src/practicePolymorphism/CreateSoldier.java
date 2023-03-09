package practicePolymorphism;

public class CreateSoldier {

	public static void main(String[] args) {

		Assault soldierOne = new Assault();
		Sniper soldierTwo = new Sniper();
		Medic soldierThree = new Medic();

		Soldier[] soldierTroop = { soldierOne, soldierTwo, soldierThree };

		for (Soldier eachTroop : soldierTroop) {
			eachTroop.shootGun();
		}

		for (Soldier eachTroop : soldierTroop) {
			eachTroop.startRun();
		}

		for (Soldier eachTroop : soldierTroop) {
			eachTroop.crouchDown();
		}

	}

}

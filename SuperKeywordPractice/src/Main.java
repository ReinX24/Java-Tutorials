
public class Main {

	public static void main(String[] args) {
		Soldier soldierTest = new Soldier("None", 100, "USP");
		Sniper playerOne = new Sniper("Sniper", 80, "AWP", 1, 50);
		Assault playerTwo = new Assault("Assault", 120, "M4A4", 3, 50);
		Medic playerThree = new Medic("Medic", 100, "FAMAS", 4, 40);

		System.out.println(soldierTest.toString());
		System.out.println(playerOne.toString());
		System.out.println(playerTwo.toString());
		System.out.println(playerThree.toString());
	}

}

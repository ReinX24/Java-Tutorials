package practiceInterface;

import java.util.Scanner;

public class AgentSelectMain {

	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * This program will ask the player to choose 1 of two modes (Death Match &
		 * Unrated). If they select death match, they will be automatically be given an
		 * agent and a map. If they choose unrated, they will be given the chance to
		 * select their desired agent.
		 */

		askMode();
	}

	static void askMode() {
		System.out.print("[Pick Mode]\n[1 - Death Match]\n[2 - Unrated]\nEnter Mode Number: ");
		int modeNum = userInput.nextInt();
		checkMode(modeNum);
	}

	static void checkMode(int modeNum) {
		if (modeNum == 1) {
			System.out.println("\n[Death Match chosen!]");
			DeathMatch gameDeathMatch = new DeathMatch();
			gameDeathMatch.startGame();
		} else if (modeNum == 2) {
			System.out.println("Unrated chosen!");
			Unrated gameUnrated = new Unrated();
			gameUnrated.startGame();
		} else {
			System.out.println("Not a valid mode!");
		}
	}

}

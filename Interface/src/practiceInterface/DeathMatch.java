package practiceInterface;

import java.util.Random;
import java.util.Scanner;

public class DeathMatch implements Agent {

	Scanner userInput = new Scanner(System.in);
	String gameMap;
	String gameAgent;

	public void startGame() {
		generateMap();
		generateAgent();
		askAction();
	}

	public void generateMap() {
		String[] mapArr = { "Ascent", "Bind", "Breeze", "Fracture", "Haven", "Icebox", "Pearl", "Split" };
		this.gameMap = mapArr[randomNum(mapArr.length)]; // selects a random map from the array
		System.out.printf("[%-10s:%-10s]\n", "Map", gameMap);
	}

	public void generateAgent() {
		String[] agentArr = { "Astra", "Breach", "Brimstone", "Chamber", "Cypher", "Jett", "Kay/O", "Killjoy", "Neon",
				"Omen", "Phoenix", "Raze", "Reyna", "Sage", "Skye", "Sova", "Viper", "Yoru" };
		this.gameAgent = agentArr[randomNum(agentArr.length)]; // selects random agent from the array
		System.out.printf("[%-10s:%-10s]\n", "Agent", gameAgent);
	}

	public int randomNum(int numMax) {
		Random createRandomNum = new Random();
		return createRandomNum.nextInt(numMax);
	}

	public void askAction() {
		int userAction;
		do {
			System.out.println("\n[Choose Action]");
			System.out.println("\n[1 - Walk]\n[2 - Run]\n[3 - Shoot]\n[4 - Aim Down Sight]\n[5 - Exit Game]");
			System.out.print("Enter Action: ");
			userAction = userInput.nextInt();
			checkAction(userAction);
		} while (userAction != 5);
	}

	public void checkAction(int actionNum) {
		switch (actionNum) {
		case 1:
			agentWalk(gameAgent);
			break;
		case 2:
			agentRun(gameAgent);
			break;
		case 3:
			agentShoot(gameAgent);
			break;
		case 4:
			agentADS(gameAgent);
			break;
		case 5:
			exitGame();
			break;
		}
	}

	public void exitGame() {
		System.out.println("[Game Exited!]");
		System.exit(0); // terminates the program
	}

	@Override
	public void agentWalk(String agentName) {
		System.out.println("\n" + agentName + " is walking!");
	}

	@Override
	public void agentRun(String agentName) {
		System.out.println("\n" + agentName + " is running!");
	}

	@Override
	public void agentShoot(String agentName) {
		System.out.println("\n" + agentName + " is shooting!");
	}

	@Override
	public void agentADS(String agentName) {
		System.out.println("\n" + agentName + " is aiming down their sight!");
	}

}

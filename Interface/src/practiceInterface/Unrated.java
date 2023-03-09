package practiceInterface;

import java.util.Random;
import java.util.Scanner;

public class Unrated implements Agent, Abilities {

	Scanner userInput = new Scanner(System.in);
	String gameMap;
	String gameAgent;
	String firstAbility;
	String secondAbility;
	String thirdAbility;
	String ultimateAbility;

	public void startGame() {
		generateMap();
		pickAgent();
		assignAbilities(gameAgent);
		askAction();
	}

	public void generateMap() {
		String[] mapArr = { "Ascent", "Bind", "Breeze", "Fracture", "Haven", "Icebox", "Pearl", "Split" };
		this.gameMap = mapArr[randomNum(mapArr.length)]; // selects a random map from the array
		System.out.printf("[%-10s:%-10s]\n", "Map", gameMap);
	}

	public void pickAgent() {
		int agenNum;
		String[] agentArr = { "[0] Astra", "[1] Breach", "[2] Brimstone", "[3] Chamber", "[4] Cypher", "[5] Jett",
				"[6] Kay/O", "[7] Killjoy", "[8] Neon", "[9] Omen", "[10] Phoenix", "[11] Raze", "[12] Reyna",
				"[13] Sage", "[14] Skye", "[15] Sova", "[16] Viper", "[17] Yoru" };
		for (int i = 0; i < agentArr.length; i++) {
			System.out.println(agentArr[i]);
		}
		System.out.print("Pick Agent : ");
		agenNum = userInput.nextInt();
		this.gameAgent = agentArr[agenNum];
		System.out.printf("[%-10s:%-10s]\n", "Agent", gameAgent);
	}

	public int randomNum(int numMax) {
		Random createRandomNum = new Random();
		return createRandomNum.nextInt(numMax);
	}

	public void assignAbilities(String gameAgent) {
		this.firstAbility = gameAgent + " Ability 1";
		this.secondAbility = gameAgent + " Ability 2";
		this.thirdAbility = gameAgent + " Ability 3";
		this.ultimateAbility = gameAgent + " Ultimate Ability";
	}

	public void askAction() {
		int userAction;
		do {
			System.out.println("\n[Choose Action]");
			System.out.println("\n[1 - Walk]\n[2 - Run]\n[3 - Shoot]\n[4 - Aim Down Sight]\n[5 - Exit Game]");
			System.out.println("\n[6 - Skill 1]\n[7 - Skill 2]\n[8 - Skill 3]\n[9 - Skill 4]\n[10 - Get Orb]");
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
		case 6:
			firstAbility("\nAbility 1");
			break;
		case 7:
			secondAbility("\nAbility 2");
			break;
		case 8:
			thirdAbility("\nAbility 3");
			break;
		case 9:
			ultimateAbility("\nUltimate Ability");
			break;
		case 10:
			getOrb();
			break;
		default:
			System.out.println("Not a valid action!");
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

	@Override
	public void firstAbility(String abilityName) {
		System.out.println(abilityName + " used!");
	}

	@Override
	public void secondAbility(String abilityName) {
		System.out.println(abilityName + " used!");
	}

	@Override
	public void thirdAbility(String abilityName) {
		System.out.println(abilityName + " used!");
	}

	@Override
	public void ultimateAbility(String abilityName) {
		System.out.println(abilityName + " used!");
	}

	public void getOrb() {
		System.out.println("\nGetting Orb!");
	}

}

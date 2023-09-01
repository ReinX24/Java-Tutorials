package com.rein.interfaceDemo;

import java.util.Scanner;

public class Main {

	static Scanner userInput = new Scanner(System.in);
	static boolean menuRunning = true; // set to true to start the Car Creator program

	public static void main(String[] args) {

//		Engine carOne = new Car("Car");
//		System.out.println(carOne.ENGINE_PRICE);
//		System.out.println(carOne.carType); // cannot access variables of other classes
		// Can only access variables in its class
		// But this engine class can use Car class methods
//		carOne.carStart();

		int userChoice;

		while (menuRunning) {
			System.out.println("[Car Creator]");
			System.out.println("[0] Generic Car");
			System.out.println("[1] Toyota");
			System.out.println("[2] Honda");
			System.out.println("[3] Tesla");
			System.out.println("[4] Exit");
			System.out.print("Input: ");
			userChoice = userInput.nextInt();

			switch (userChoice) {

			case 0:
				System.out.println("Generic Car created!");
				Car userCar = new Car("Car");
				carOptions(userCar);
				break;

			case 1:
				System.out.println("Toyota Car created!");
				Car toyotaCar = new Toyota("Toyota");
				carOptions(toyotaCar); // can accept child classes of Car
				break;

			case 2:
				System.out.println("Honda Car created!");
				Car hondaCar = new Honda("Honda");
				carOptions(hondaCar);
				break;

			case 3:
				System.out.println("Tesla Car created!");
				Car testlaCar = new Tesla("Tesla");
				carOptions(testlaCar);
				break;

			case 4:
				System.out.println("Car created exited!");
				System.exit(0);
				break;

			}

		}

	}

	public static void carOptions(Car userCar) {
		menuRunning = false;
		int carChoice;
		while (!menuRunning) {
			System.out.println("[" + userCar.getCarType() + " Options]");
			System.out.println("[0] Start");
			System.out.println("[1] Stop");
			System.out.println("[2] Accelerate");
			System.out.println("[3] Brake");
			System.out.println("[4] Play Media");
			System.out.println("[5] Stop Media");
			System.out.println("[6] Exit");
			System.out.print("Input: ");
			carChoice = userInput.nextInt();

			switch (carChoice) {

			case 0:
				userCar.engineStart();
				break;

			case 1:
				userCar.engineStop();
				break;

			case 2:
				userCar.engineAcc();
				break;

			case 3:
				userCar.carBrake();
				break;

			case 4:
				userCar.mediaStart();
				break;

			case 5:
				userCar.mediaStop();
				break;

			case 6:
				System.out.println(userCar.carType + " exited!");
				menuRunning = true;
				break;

			}

		}
	}

}

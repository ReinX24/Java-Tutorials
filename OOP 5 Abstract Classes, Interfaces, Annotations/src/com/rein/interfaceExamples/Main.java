package com.rein.interfaceExamples;

public class Main {

	public static void main(String[] args) {

		NiceCar niceCarOne = new NiceCar();
		niceCarOne.carStart(); // will have a power engine
		niceCarOne.carAcc();
		niceCarOne.startMusic();
		
		ElectricEngine electricEngineOne = new ElectricEngine();
		MP3Player mp3PlayerOne = new MP3Player();
		
		System.out.println("[***********************************]");
		// Replacing NiceCar Engine and Media
		niceCarOne.setEngine(electricEngineOne);
		niceCarOne.setPlayer(mp3PlayerOne);
		niceCarOne.carStart();
		niceCarOne.carAcc();
		niceCarOne.startMusic();
		System.out.println("[***********************************]");
		
		

		NiceCar niceCarTwo = new NiceCar(electricEngineOne, mp3PlayerOne);
		niceCarTwo.carStart();
		niceCarTwo.carAcc();
		niceCarTwo.startMusic();

	}

}

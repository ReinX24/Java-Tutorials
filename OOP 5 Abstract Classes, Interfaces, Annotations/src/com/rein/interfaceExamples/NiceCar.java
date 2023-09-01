package com.rein.interfaceExamples;

import com.rein.interfaceDemo.Engine;
import com.rein.interfaceDemo.Media;

public class NiceCar {

	private Engine carEngine;
	private Media musicPlayer;

	// Default constructor
	public NiceCar() {
		carEngine = new PowerEngine();
		musicPlayer = new CDPlayer();
	}

	// Constructor with a newEngine and newMedia
	public NiceCar(Engine newEngine, Media newMedia) {
		this.carEngine = newEngine;
		musicPlayer = newMedia;
	}

	public void carStart() {
		carEngine.engineStart();
	}

	public void carStop() {
		carEngine.engineStop();
	}

	public void carAcc() {
		carEngine.engineAcc();
	}

	public void startMusic() {
		musicPlayer.mediaStart();
	}

	public void stopMusic() {
		musicPlayer.mediaStop();
	}

	public void setEngine(Engine newEngine) {
		this.carEngine = newEngine;
	}

	public void setPlayer(Media newPlayer) {
		this.musicPlayer = newPlayer;
	}

}

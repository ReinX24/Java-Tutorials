package com.rein.interfaceDemo;

public class Car implements Engine, Brake, Media {

	String carType;

	public Car(String carType) {
		this.carType = carType;
	}
	
	public String getCarType() {
		return this.carType;
	}

	@Override
	public void engineStart() {
		System.out.println(this.carType + " started!");
	}

	@Override
	public void engineStop() {
		System.out.println(this.carType + " stopped!");
	}

	@Override
	public void engineAcc() {
		System.out.println(this.carType + " started accelerating!");
	}

	@Override
	public void carBrake() {
		System.out.println(this.carType + " brakes triggered!");
	}

	@Override
	public void exitCar() {
		System.out.println(this.carType + " exited!");
	}

	@Override
	public void mediaStart() {
		System.out.println(this.carType + " media started playing!");
	}

	@Override
	public void mediaStop() {
		System.out.println(this.carType + " media stopped playing!");
	}

}

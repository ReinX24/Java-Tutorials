package com.rein.interfaceExamples;

import com.rein.interfaceDemo.Engine;

public class PowerEngine implements Engine {

	@Override
	public void engineStart() {
		System.out.println("Power engine started!");
	}

	@Override
	public void engineStop() {
		System.out.println("Power engine stopped!");
	}

	@Override
	public void engineAcc() {
		System.out.println("Power engine started accelerating!");
	}

}

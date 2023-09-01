package com.rein.interfaceExamples;

import com.rein.interfaceDemo.Engine;

public class ElectricEngine implements Engine {

	@Override
	public void engineStart() {
		System.out.println("Electric engine started!");
	}

	@Override
	public void engineStop() {
		System.out.println("Electric engine stopped!");
	}

	@Override
	public void engineAcc() {
		System.out.println("Electric engine accelerating!");
	}

}

package com.rein.interfaceExamples;

import com.rein.interfaceDemo.Media;

public class CDPlayer implements Media {

	@Override
	public void mediaStart() {
		System.out.println("CD Player started playing music!");
	}

	@Override
	public void mediaStop() {
		System.out.println("CD player stopped playing music!");
	}

}

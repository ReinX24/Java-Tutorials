package com.rein.interfaceExamples;

import com.rein.interfaceDemo.Media;

public class MP3Player implements Media {

	@Override
	public void mediaStart() {
		System.out.println("MP3 Player started playing music!");
	}

	@Override
	public void mediaStop() {
		System.out.println("MP3 Player stopped playing music!");
	}

}

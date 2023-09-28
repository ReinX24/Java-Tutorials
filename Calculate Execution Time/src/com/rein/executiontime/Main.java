package com.rein.executiontime;

public class Main {
	
	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		// PROGRAM START
			
		try {
			Thread.sleep(3000); // 3000 milliseconds or 3 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// PROGRAM END
		
		long durationTime = (System.nanoTime() - startTime) / 1000000; // converts to milliseconds
		System.out.println(durationTime + "ms");
	}

}

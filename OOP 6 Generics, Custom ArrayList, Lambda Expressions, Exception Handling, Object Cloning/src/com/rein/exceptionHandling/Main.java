package com.rein.exceptionHandling;

public class Main {

	public static void main(String[] args) {
		/*
		 * Difference between an error and an exception An error cannot be handled
		 * through code whereas an exception can be handled through code by using try
		 * catch blocks and various means.
		 * 
		 * There are two kinds of exceptions: Checked exceptions are exceptions that
		 * happen during compile time. On the other hand, unchecked exceptions happen
		 * during runtime and are not detected during compile time.
		 */

		int a = 5;
		int b = 0;
		try {
//			int c = a / b; // this throws an ArithmeticException since we cannot divide by 0
//			divide(a, b); // this also throws an ArithmeticException

			// Throwing an Exception, is caught by the catch block with Exception e
//			throw new Exception("For fun exception");
			
			// Throwing our CustomException
			String myName = "Rein";
			if (myName.equals("Rein")) {
				throw new CustomException("My name is Rein");
			}	
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Normal exception");
		} finally {
			System.out.println("This will always execute");
		}
	}

	static int divide(int a, int b) throws ArithmeticException { // possible exceptions that this method could throw
		if (b == 0) {
			throw new ArithmeticException("please do not divide by 0");
		}

		return a / b;
	}

}

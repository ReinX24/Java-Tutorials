
public class Assignment {
	
	public static void main (String[] args) {
		
		int numOne = 5;
		int numTwo = 3;
		int tempNum;
		
		System.out.println("[Original Variables]");
		System.out.println(numOne);
		System.out.println(numTwo);
		
		/* Swapping the two variables */
		tempNum = numOne;
		numOne = numTwo;
		numTwo = tempNum;
		
		System.out.println("[Swapped Variables]");
		System.out.println(numOne);
		System.out.println(numTwo);
		
	}

}

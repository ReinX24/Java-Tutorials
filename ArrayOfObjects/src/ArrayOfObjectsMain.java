
public class ArrayOfObjectsMain {

	public static void main(String[] args) {
		int[] numArr = new int[3]; // 3 elements for array
		char[] charArr = new char[3];
		String[] strArr = new String[3];

		Food[] myRefrigerator = new Food[3]; // array of Food objects

		// Creating food objects
		Food foodOne = new Food("Apple");
		Food foodTwo = new Food("Banana");
		Food foodThree = new Food("Carrot");

		// Adding our Food objects to our array
		myRefrigerator[0] = foodOne;
		myRefrigerator[1] = foodTwo;
		myRefrigerator[2] = foodThree;

		// Printing myRefrigerator elements
		for (int i = 0; i < myRefrigerator.length; i++) {
			System.out.println(myRefrigerator[i]);
		}

		System.out.println();
		
		// Creating food objects & creating food array w/ objects
		Food chickenMRE = new Food("Chicken");
		Food cheeseMRE = new Food("Cheese");
		Food beefMRE = new Food("Beef");
		Food[] myEmergencyStock = { chickenMRE, cheeseMRE, beefMRE };
		
		// Printing myEmergencyStock elements
		for (int i = 0; i < myEmergencyStock.length; i++) {
			System.out.println(myEmergencyStock[i]);
		}
	}

}

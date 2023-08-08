
public class DynamicArraysMain {

	public static void main(String[] args) {

		// A static array has a fixed amount of elements whereas ArrayLists has a
		// dynamic amount of elements, this means that we could change

		// Static array
		String[] staticArray = new String[5];
		staticArray[0] = "A";
		staticArray[0] = "B";
		staticArray[0] = "C";
		staticArray[0] = "D";
		staticArray[0] = "E";

		// Dynamic array
		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.add("A");
		dynamicArray.add("B");
		dynamicArray.add("C");
		
		dynamicArray.insert(0, "X");
		dynamicArray.delete("A");
		
		System.out.println(dynamicArray);
		System.out.println("Size: " + dynamicArray.sizeNum);
		System.out.println("Capacity: " + dynamicArray.capacityNum);
		System.out.println("Empty: " + dynamicArray.isEmpty());
	}

}


public class DynamicArray {

	int sizeNum = 0; // size of added element
	int capacityNum = 10;
	Object[] myArray;

	public DynamicArray() {
		this.myArray = new Object[capacityNum];
	}

	public DynamicArray(int paraCapacity) {
		this.capacityNum = paraCapacity;
		this.myArray = new Object[capacityNum];
	}

	public void add(Object objectData) {
		// If the size is greater than or equal than capacityNum, increase size using
		// the grow method
		if (this.sizeNum >= capacityNum) {
			grow();
		}
		myArray[this.sizeNum] = objectData;
		this.sizeNum++;
	}

	public void insert(int index, Object objectData) {
		if (sizeNum >= capacityNum) {
			grow();
		}
		// Moving the elements for the insertion of objectData
		// Starts at the end and moves each element one index to the right
		for (int i = sizeNum; i > index; i--) {
			myArray[i] = myArray[i - 1]; // move the elements to the right
		}
		myArray[index] = objectData;
		sizeNum++;
	}

	public void delete(Object objectData) {
		for (int i = 0; i < sizeNum; i++) {
			if (myArray[i] == objectData) {
				// Make current iterated element that has been matched to null
				myArray[i] = null;
				// Shifting elements to the left
				// An easier solution that I have made myself
				for (int j = i; j < sizeNum; j++) {
					myArray[j] = myArray[j + 1];
				}

				// Bro Code solution, it was a but confusing for me so I went ahead and made my
				// own solution
//				for (int j = 0; j < (sizeNum - i - 1); j++) {
//					myArray[i + j] = myArray[i + j + 1];
//				}
//				myArray[sizeNum - 1] = null;

				sizeNum--;
				// If the sizeNum (amount if elements in the array) is less than 1 / 3 of
				// capacityNum, decrease the size of myArray using the shrink() method
				if (sizeNum <= (int) (capacityNum / 3)) {
					shrink();
				}
				break;
			}
		}
	}

	public int search(Object objectData) {
		for (int i = 0; i < sizeNum; i++) {
			if (myArray[i] == objectData) {
				return i; // returns the index of the Object
			}
		}
		return -1; // if Object was not found
	}

	// Shrink the Object array to half whenever the amount of elements (sizeNum) is
	// less than or equal to 1 / 3 of the current capacityNum
	private void grow() {
		int newCapacity = capacityNum * 2; // doubling current capacity
		Object[] newArray = new Object[newCapacity]; // creating an Object array with newCapacity

		for (int i = 0; i < sizeNum; i++) {
			newArray[i] = myArray[i];
		}
		capacityNum = newCapacity;
		myArray = newArray; // replace myArray with newArray, it has the same contents but has more space
	}

	private void shrink() {
		int newCapacity = capacityNum / 2;
		Object[] newArray = new Object[newCapacity];

		for (int i = 0; i < sizeNum; i++) {
			newArray[i] = myArray[i];
		}
		capacityNum = newCapacity;
		myArray = newArray;
	}

	public boolean isEmpty() {
		// Returns true if the size is equal to 0
		return sizeNum == 0;
	}

	public String toString() {
		String arrayString = "";
		// Only adding added elements to arrayString
		for (int i = 0; i < capacityNum; i++) {
			arrayString += myArray[i] + ", ";
		}
		// Removing the last comma and enclosing the entire String with brackets
		if (!arrayString.equals("")) {
			arrayString = "[" + arrayString.substring(0, arrayString.length() - 2) + "]";
		} else {
			arrayString = "[]";
		}
		return arrayString;
	}

}

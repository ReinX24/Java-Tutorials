
public class Friend {

	String friendName;
	static int friendAmount; // static variable

	public Friend(String friendName) {
		this.friendName = friendName;
		friendAmount++; // increments friendAmount when a Friend object is made
	}

	// Creating a static method, can be accessed even if no Friend object is made
	static void displayFriendAmount() {
		// no need to have the this. keyword since it is a static variable
		System.out.println("You have: " + friendAmount + " friends!");
		// this. is only important for non static variables
	}

}


public class StaticKeywordMain {

	public static void main(String[] args) {
		/*
		 * Static: A modifier. A single copy of a variable / method is created and
		 * shared. The class "owns" the static member.
		 */

		Friend friendOne = new Friend("Spongebob");
		Friend friendTwo = new Friend("Patrick");
		Friend friendThree = new Friend("Squidward");
		Friend friendFour = new Friend("Sandy");

		System.out.println(Friend.friendAmount); // no need to create Friend object to access variable
		System.out.println(friendOne.friendAmount); // can also access through objects, not recommended
		System.out.println(friendTwo.friendAmount);
		System.out.println(friendThree.friendAmount);
		System.out.println(friendFour.friendAmount);

		Friend.displayFriendAmount(); // using a static method
		
		// static methods from built in classes and functions
		System.out.println(Math.round(5.6)); // rounds up to 6
	}

}

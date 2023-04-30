package practiceAnonymousInnerClasses;

public class PracticeMain {

	public static void main(String[] args) {

		PracticeRole roleOne = new PracticeRole();
		roleOne.sayRole();

		PracticeRole roleTwoAnonymous = new PracticeRole() {

			@Override
			public void sayRole() { // overriding method in PracticeRole class
				System.out.println("I am a sniper!");
			}

//			public void sayRank() {
//				System.out.println("I am a private!");
//			}

		};

		roleTwoAnonymous.sayRole();
//		roleTwoAnonymous.sayRank(); // will result in an exception, can only override methods

		// Calling the constructor of our PracticeFrame class
		new PracticeFrame();

	}

}

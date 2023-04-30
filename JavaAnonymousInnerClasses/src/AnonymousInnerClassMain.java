public class AnonymousInnerClassMain {

	public static void main(String[] args) {

		/*
		 * anonymous class = an inner class without a name only a single object is
		 * created from one The object may have “extras” or "changes" and no need to
		 * create a separate innerclass when it only need it once. Helps us to avoid
		 * cluttering code with a class name
		 * 
		 * Syntax is similar to a constructor, except that there is also a class
		 * definition within a block of code. GREAT FOR LISTENERS
		 */

		// Creating an object and using a method of our object
		Greeting myGreeting = new Greeting();
		myGreeting.Welcome();

		// Using anonymous inner class
		Greeting myInnerGreeting = new Greeting() {

			// Can create custom methods, can also override existing methods
			@Override
			public void Welcome() {
				System.out.println("Hello Bro!");
			}

		};

		myInnerGreeting.Welcome();

	}

}

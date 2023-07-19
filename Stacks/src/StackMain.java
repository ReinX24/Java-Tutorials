import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		// stack = LIFO data structure. Last-In First-Out
		// stores objects into a sort of "vertical tower"
		// push() to add to the top
		// pop() to remove from the top

		Stack<String> myStack = new Stack<String>();
//		System.out.println(myStack.empty()); // prints true

		myStack.push("Minecraft");
		myStack.push("Skyrim");
		myStack.push("DOOM");
		myStack.push("Borderlands");
		myStack.push("FFVII");

//		System.out.println(myStack.empty()); // prints false
//		System.out.println(myStack); // prints stack elements

//		myStack.pop(); // removes last object added (FFVII)
//		System.out.println(myStack);

//		myStack.pop();
//		myStack.pop();
//		myStack.pop();
//		myStack.pop();
//		myStack.pop(); // will throw an exception since there are no more stack elements
//		System.out.println(myStack);

//		String myFavoriteGame = myStack.pop(); // removes last element added and stores it in a String
//		System.out.println(myStack);
//		System.out.println(myFavoriteGame);

//		System.out.println(myStack.peek()); // prints topmost item
//		System.out.println(myStack);

//		System.out.println(myStack.search("FFVII")); // prints 1, topmost item in the stack
//		System.out.println(myStack.search("Borderlands")); // 2
//		System.out.println(myStack.search("DOOM")); // 3
//		System.out.println(myStack.search("Skyrim")); // 4
//		System.out.println(myStack.search("Minecraft")); // 5
//		System.out.println(myStack.search("Fallout76")); // -1
		
		// Overflowing our stack, causes an out of memory error
//		for (int i = 0; i < Integer.MAX_VALUE; i++) {
//			myStack.push("Fallout76");
//		}
		
		// Uses of stacks?
		// 1. undo / redo features in text editors
		// 2. moving back / forward through browser history
		// 3. backtracking algorithms (maze, file directories)
		// 4. calling functions (call stack)
	}

}

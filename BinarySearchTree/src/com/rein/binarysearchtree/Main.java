package com.rein.binarysearchtree;

public class Main {

	public static void main(String[] args) {

		BinarySearchTree myTree = new BinarySearchTree();

		myTree.insert(new Node(5));
		myTree.insert(new Node(1));
		myTree.insert(new Node(9));
		myTree.insert(new Node(2));
		myTree.insert(new Node(7));
		myTree.insert(new Node(3));
		myTree.insert(new Node(6));
		myTree.insert(new Node(4));
		myTree.insert(new Node(8));

		myTree.remove(0);
		myTree.display();

//		myTree.remove(0); // 0 could not be found

//		System.out.println(myTree.search(0)); // prints false
//		System.out.println(myTree.search(1)); // prints true

	}

}

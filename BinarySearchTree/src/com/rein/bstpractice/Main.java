package com.rein.bstpractice;

public class Main {

	public static void main(String[] args) {

		BinarySearchTree treeOne = new BinarySearchTree();

		treeOne.insertNode(new Node(5)); // root

		// Left side of the tree
		treeOne.insertNode(new Node(1));
		treeOne.insertNode(new Node(2));
		treeOne.insertNode(new Node(3));
		treeOne.insertNode(new Node(4));

		// Right side of the tree
		treeOne.insertNode(new Node(9));
		treeOne.insertNode(new Node(7));
		treeOne.insertNode(new Node(6));
		treeOne.insertNode(new Node(8));

//		treeOne.display();

		System.out.println(treeOne.searchNode(5)); // prints true since 5 is in our tree
		System.out.println(treeOne.searchNode(0)); // prints false since 0 is not in our tree
		
		treeOne.remove(1); // removes Node with data of 1
		treeOne.remove(0); // 0 could not be found!
		treeOne.display();

	}

}

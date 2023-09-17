package com.rein.bstpractice;

public class BinarySearchTree {

	Node rootNode;

	public void insertNode(Node newNode) {
		rootNode = insertHelper(rootNode, newNode);
	}

	private Node insertHelper(Node rootNode, Node newNode) {

		int nodeData = newNode.nodeData; // storing newNode nodeData

		if (rootNode == null) { // if the rootNode is null, it is where we will place our newNode
			rootNode = newNode;
			return rootNode;
		} else if (nodeData < rootNode.nodeData) {
			// If the nodeData is less than the rootNode nodeData, it is at the left of the
			// tree. Repeat this process until the last node.
			rootNode.leftNode = insertHelper(rootNode.leftNode, newNode);
		} else {
			// If the nodeData is greater than rootNode nodeData, go to the right of the
			// tree.
			rootNode.rightNode = insertHelper(rootNode.rightNode, newNode);
		}
		return rootNode;
	}

	// For printing the tree values
	public void display() {
		displayHelper(rootNode);
	}

	public void displayHelper(Node rootNode) {

		if (rootNode != null) {
			// Printing all of the nodes at the left of the root node first before the right
			// nodes.
			displayHelper(rootNode.leftNode);
			System.out.println(rootNode.nodeData);
			displayHelper(rootNode.rightNode);
		}

	}

}

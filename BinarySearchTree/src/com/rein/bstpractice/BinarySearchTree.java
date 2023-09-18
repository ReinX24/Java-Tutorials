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

	private void displayHelper(Node rootNode) {

		if (rootNode != null) {
			// Printing all of the nodes at the left of the root node first before the right
			// nodes.
			displayHelper(rootNode.leftNode);
			System.out.println(rootNode.nodeData);
			displayHelper(rootNode.rightNode);
		}

	}

	public boolean searchNode(int nodeData) {
		return searchNodeHelper(rootNode, nodeData);
	}

	private boolean searchNodeHelper(Node rootNode, int nodeData) {

		if (rootNode == null) {
			return false;
		} else if (rootNode.nodeData == nodeData) {
			return true;
		} else if (nodeData < rootNode.nodeData) {
			return searchNodeHelper(rootNode.leftNode, nodeData);
		} else {
			return searchNodeHelper(rootNode.rightNode, nodeData);
		}

	}

	public void remove(int nodeData) {
		// Checking first if the nodeData exists in our tree
		if (searchNode(nodeData)) {
			removeHelper(rootNode, nodeData);
		} else {
			System.out.println(nodeData + " could not be found!");
		}

	}

	private Node removeHelper(Node rootNode, int nodeData) {

		if (rootNode == null) {
			return rootNode;
		} else if (nodeData < rootNode.nodeData) {
			rootNode.leftNode = removeHelper(rootNode.leftNode, nodeData);
		} else if (nodeData > rootNode.nodeData) {
			rootNode.rightNode = removeHelper(rootNode.rightNode, nodeData);
		} else {
			if (rootNode.leftNode == null && rootNode.rightNode == null) {
				rootNode = null;
			} else if (rootNode.rightNode != null) {
				rootNode.nodeData = successor(rootNode);
				rootNode.rightNode = removeHelper(rootNode.rightNode, rootNode.nodeData);
			} else {
				rootNode.nodeData = predecessor(rootNode);
				rootNode.leftNode = removeHelper(rootNode.leftNode, rootNode.nodeData);
			}
		}
		
		return rootNode;

	}

	// Find the least value below the right child of this root node
	private int successor(Node rootNode) {
		rootNode = rootNode.rightNode;
		while (rootNode.leftNode != null) {
			rootNode = rootNode.leftNode;
		}
		return rootNode.nodeData;
	}

	// Find the greatest value below the left child of this root node
	private int predecessor(Node rootNode) {
		rootNode = rootNode.leftNode;
		while (rootNode.rightNode != null) {
			rootNode = rootNode.rightNode;
		}
		return rootNode.nodeData;
	}

}

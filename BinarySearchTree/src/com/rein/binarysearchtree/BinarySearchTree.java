package com.rein.binarysearchtree;

public class BinarySearchTree {

	Node rootNode;

	public void insert(Node insertedNode) {
		rootNode = insertHelper(rootNode, insertedNode);
	}

	private Node insertHelper(Node rootNode, Node node) {
		int nodeData = node.nodeData;

		if (rootNode == null) {
			rootNode = node;
			return rootNode;
		} else if (nodeData < rootNode.nodeData) {
			rootNode.leftNode = insertHelper(rootNode.leftNode, node);
		} else {
			rootNode.rightNode = insertHelper(rootNode.rightNode, node);
		}
		return rootNode;
	}

	public void display() {
		displayHelper(rootNode);
	}

	private void displayHelper(Node rootNode) {

		if (rootNode != null) {
			displayHelper(rootNode.leftNode);
			System.out.println(rootNode.nodeData);
			displayHelper(rootNode.rightNode);
		}

	}

	public boolean search(int data) {
		return searchHelper(rootNode, data);
	}

	private boolean searchHelper(Node rootNode, int data) {

		// If the tree is empty
		if (rootNode == null) {
			return false;
		} else if (rootNode.nodeData == data) {
			return true;
		} else if (data < rootNode.nodeData) { // go left of the tree
			return searchHelper(rootNode.leftNode, data);
		} else {
			return searchHelper(rootNode.rightNode, data);
		}

	}

	public void remove(int data) {

		if (search(data)) {
			removeHelper(rootNode, data);
		} else {
			System.out.println(data + " could not be found");
		}

	}

	private Node removeHelper(Node rootNode, int data) {

		if (rootNode == null) {
			return rootNode;
		} else if (data < rootNode.nodeData) {
			rootNode.leftNode = removeHelper(rootNode.leftNode, data);
		} else if (data > rootNode.nodeData) {
			rootNode.rightNode = removeHelper(rootNode.rightNode, data);
		} else { // node is found
			// if the node removed node is a leaf
			if (rootNode.leftNode == null && rootNode.rightNode == null) {
				rootNode = null;
			} else if (rootNode.rightNode != null) { // finding a successor to replace this node
				rootNode.nodeData = successor(rootNode);
				rootNode.rightNode = removeHelper(rootNode.rightNode, rootNode.nodeData);
			} else { // finding a predecessor to replace this node
				rootNode.nodeData = predessor(rootNode);
				rootNode.leftNode = removeHelper(rootNode.leftNode, rootNode.nodeData);
			}
		}

		return rootNode;

	}

	private int successor(Node rootNode) { // find the least value below the right child of this root node
		rootNode = rootNode.rightNode;
		while (rootNode.leftNode != null) {
			rootNode = rootNode.leftNode;
		}
		return rootNode.nodeData;
	}

	private int predessor(Node rootNode) { // find the greatest value below the left child of this root node
		rootNode = rootNode.leftNode;
		while (rootNode.rightNode != null) {
			rootNode = rootNode.rightNode;
		}
		return rootNode.nodeData;
	}

}

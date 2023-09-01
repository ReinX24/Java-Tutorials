package com.rein.adjacencyList;

public class Main {

	public static void main(String[] args) {

		// Adjacency List: An array/arraylist of linkedlists.
		// Each linked list has a unique node at the head.
		// All adjacency neighbors to that node are added to the node's linkedlist
		// Runtime complexity to check an Edge: O(n), means that this is dependent on
		// how much elements are in our list. n means node.
		// Space complexity: O(n + e). n means node and e means edges
		// This takes longer to look for an edge when compared to a adjacency matrix but
		// it does takes less space.

		Graph graphOne = new Graph();
		graphOne.addNode(new Node('A'));
		graphOne.addNode(new Node('B'));
		graphOne.addNode(new Node('C'));
		graphOne.addNode(new Node('D'));
		graphOne.addNode(new Node('E'));

		graphOne.addEdge(0, 1); // adds an edge from A(src) to B(dst)
		graphOne.addEdge(1, 2);
		graphOne.addEdge(1, 4);
		graphOne.addEdge(2, 3);
		graphOne.addEdge(2, 4);
		graphOne.addEdge(4, 0);
		graphOne.addEdge(4, 2);
		
		graphOne.printGraph();

	}

}

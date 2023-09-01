package com.rein.adjacencyListPractice;

public class Main {

	public static void main(String[] args) {

		Graph adjacencyListOne = new Graph();

		// Adding Nodes to our adjacency list
		adjacencyListOne.addNode(new Node('A'));
		adjacencyListOne.addNode(new Node('B'));
		adjacencyListOne.addNode(new Node('C'));
		adjacencyListOne.addNode(new Node('D'));
		adjacencyListOne.addNode(new Node('E'));

		// Adding edges to our adjacency list, we have a total of 7 edges
		adjacencyListOne.addEdge(0, 1);
		adjacencyListOne.addEdge(1, 2);
		adjacencyListOne.addEdge(1, 4);
		adjacencyListOne.addEdge(2, 3);
		adjacencyListOne.addEdge(2, 4);
		adjacencyListOne.addEdge(4, 0);
		adjacencyListOne.addEdge(4, 2);
		
		// Printing our adjacency list
		adjacencyListOne.printList();
		
		// Testing our checkEdge() method
		System.out.println(adjacencyListOne.checkEdge(0, 1)); // A to B true
		System.out.println(adjacencyListOne.checkEdge(2, 4)); // C to E true
		System.out.println(adjacencyListOne.checkEdge(2, 1)); // C to B false
		System.out.println(adjacencyListOne.checkEdge(0, 4)); // A to E false

	}

}

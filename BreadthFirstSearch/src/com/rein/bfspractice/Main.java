package com.rein.bfspractice;

public class Main {

	public static void main(String[] args) {

		Graph graphOne = new Graph(5);

		graphOne.addNode(new Node('A'));
		graphOne.addNode(new Node('B'));
		graphOne.addNode(new Node('C'));
		graphOne.addNode(new Node('D'));
		graphOne.addNode(new Node('E'));

		graphOne.addEdge(0, 1);
		graphOne.addEdge(1, 2);
		graphOne.addEdge(1, 4);
		graphOne.addEdge(2, 3);
		graphOne.addEdge(2, 4);
		graphOne.addEdge(4, 2);
		graphOne.addEdge(4, 0);

		graphOne.printGraph();

		System.out.println("\nDepth First Search");
		graphOne.depthFirstSearch(0);
		System.out.println("\nBreadth First Search");
		graphOne.breadthFirstSearch(0);

	}

}

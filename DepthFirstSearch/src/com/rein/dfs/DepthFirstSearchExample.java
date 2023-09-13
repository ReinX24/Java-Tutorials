package com.rein.dfs;

public class DepthFirstSearchExample {
	
	public static void main(String[] args) {
		
		// directedGraphOne.png
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
		
		graphOne.depthFirstSearch(0);
		
		// directedGraphTwo.png
		Graph graphTwo = new Graph(4);
		
		graphTwo.addNode(new Node('A')); // 1
		graphTwo.addNode(new Node('B')); // 2
		graphTwo.addNode(new Node('C')); // 3
		graphTwo.addNode(new Node('D')); // 4
		
		graphTwo.addEdge(0, 1);
		graphTwo.addEdge(0, 2);
		graphTwo.addEdge(2, 1);
		graphTwo.addEdge(2, 3);
		graphTwo.addEdge(3, 2);
		
		graphTwo.printGraph();
		
		graphTwo.depthFirstSearch(0);
		
	}

}

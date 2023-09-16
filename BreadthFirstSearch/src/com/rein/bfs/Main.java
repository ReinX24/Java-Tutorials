package com.rein.bfs;

public class Main {

	public static void main(String[] args) {

		// Breadth First Search goes through a graph by visiting all nodes on one level
		// before moving on to the next.

		/*
		 * Breadth FS
		 * 
		 * - Traverse a graph level by level
		 * 
		 * - Utilize a Queue
		 * 
		 * - Better if destination is on average close to start
		 * 
		 * - Siblings are visited before children
		 * 
		 * Depth FS
		 * 
		 * - Traverse a graph branch by branch
		 * 
		 * - Utilizes a stack
		 * 
		 * - Better if destination in on average far from the start
		 * 
		 * - Children are visited before siblings
		 * 
		 * - More popular for games/puzzles
		 * 
		 */

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

		graphOne.breadthFirstSearch(0);
		graphOne.bfsPractice(0);

	}

}

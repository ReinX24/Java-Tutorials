package com.rein.bfspractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	ArrayList<Node> graphList;
	int[][] graphMatrix;

	public Graph(int graphSize) {
		graphList = new ArrayList<>();
		graphMatrix = new int[graphSize][graphSize];
	}

	public void addNode(Node newNode) {
		graphList.add(newNode);
	}

	public void addEdge(int src, int dst) {
		graphMatrix[src][dst]++;
	}

	public boolean checkEdge(int src, int dst) {
		return graphMatrix[src][dst] == 1;
	}

	public void printGraph() {
		System.out.print("  ");
		for (int i = 0; i < graphList.size(); i++) {
			System.out.print(graphList.get(i).nodeData + " ");
		}
		System.out.println();
		for (int i = 0; i < graphMatrix.length; i++) {
			System.out.print(graphList.get(i).nodeData + " ");
			for (int j = 0; j < graphMatrix[i].length; j++) {
				System.out.print(graphMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void depthFirstSearch(int src) {
		boolean[] visitedArr = new boolean[graphMatrix.length];
		dfsHelper(src, visitedArr);
	}

	public void dfsHelper(int src, boolean[] visitedArr) {
		if (visitedArr[src]) {
			return;
		} else {
			visitedArr[src] = true;
			System.out.println(graphList.get(src).nodeData + " is visited!");
		}
		for (int i = 0; i < graphMatrix.length; i++) {
			if (graphMatrix[src][i] == 1) {
				dfsHelper(i, visitedArr);
			}
		}
	}

	public void breadthFirstSearch(int src) {

		Queue<Integer> graphQueue = new LinkedList<>();
		boolean[] visitedArr = new boolean[graphMatrix.length];

		graphQueue.offer(src);
		visitedArr[src] = true;

		while (graphQueue.size() != 0) {

			src = graphQueue.poll();
			System.out.println(graphList.get(src).nodeData + " is visited!");

			for (int i = 0; i < graphMatrix[src].length; i++) {
				if (graphMatrix[src][i] == 1 && !visitedArr[i]) {
					graphQueue.offer(i);
					visitedArr[i] = true;
				}
			}

		}

	}

}

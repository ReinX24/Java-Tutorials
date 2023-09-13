package com.rein.dfs;

import java.util.ArrayList;

public class Graph {

	ArrayList<Node> nodeList;
	int[][] nodeMatrix;

	public Graph(int matrixSize) {
		nodeList = new ArrayList<>();
		nodeMatrix = new int[matrixSize][matrixSize];
	}

	public void addNode(Node newNode) {
		nodeList.add(newNode);
	}

	public void addEdge(int src, int dst) {
		nodeMatrix[src][dst] = 1;
	}

	public boolean checkEdge(int src, int dst) {
		return nodeMatrix[src][dst] == 1;
	}

	public void printGraph() {
		System.out.print("  ");
		for (int i = 0; i < nodeList.size(); i++) {
			System.out.print(nodeList.get(i).nodeData + " ");
		}
		System.out.println();
		for (int i = 0; i < nodeMatrix.length; i++) {
			System.out.print(nodeList.get(i).nodeData + " ");
			for (int j = 0; j < nodeMatrix[i].length; j++) {
				System.out.print(nodeMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void depthFirstSearch(int src) {
		boolean[] visited = new boolean[nodeMatrix.length]; // for checking if a node is visited
		dfsHelper(src, visited);
		System.out.println();
	}

	private void dfsHelper(int src, boolean[] visited) {
		if (visited[src]) {
			return; // terminate if the node is already visited
		} else {
			visited[src] = true;
			System.out.println(nodeList.get(src).nodeData + " = visited");
		}
		// Finding the adjacent or connected node that has not been visited
		for (int i = 0; i < nodeMatrix[src].length; i++) {
			if (nodeMatrix[src][i] == 1) {
				dfsHelper(i, visited);
			}
		}
		return;
	}

}

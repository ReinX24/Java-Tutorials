package com.rein.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	ArrayList<Node> nodeList;
	int[][] nodeGraph;

	public Graph(int graphSize) {
		nodeList = new ArrayList<>();
		nodeGraph = new int[graphSize][graphSize];
	}

	public void addNode(Node newNode) {
		nodeList.add(newNode);
	}

	public void addEdge(int src, int dst) {
		nodeGraph[src][dst]++;
	}

	public boolean checkEdge(int src, int dst) {
		return nodeGraph[src][dst] == 1;
	}

	public void printGraph() {
		System.out.print("  ");
		for (int i = 0; i < nodeList.size(); i++) {
			System.out.print(nodeList.get(i).nodeData + " ");
		}
		System.out.println();
		for (int i = 0; i < nodeGraph.length; i++) {
			System.out.print(nodeList.get(i).nodeData + " ");
			for (int j = 0; j < nodeGraph[i].length; j++) {
				System.out.print(nodeGraph[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void breadthFirstSearch(int src) {

		Queue<Integer> graphQueue = new LinkedList<>();
		boolean[] visitedArr = new boolean[nodeGraph.length]; // checking of the node is visited

		graphQueue.offer(src);
		visitedArr[src] = true;

		while (graphQueue.size() != 0) {

			src = graphQueue.poll(); // removes the last added element to graphQueue
			System.out.println(nodeList.get(src).nodeData + " = visited");

			for (int i = 0; i < nodeGraph[src].length; i++) {
				if (nodeGraph[src][i] == 1 && !visitedArr[i]) {
					graphQueue.offer(i);
					visitedArr[i] = true;
				}
			}

		}
	}

	public void bfsPractice(int src) {

		Queue<Integer> graphQueue = new LinkedList<>();
		boolean[] visitedArr = new boolean[nodeGraph.length];

		graphQueue.offer(src);
		visitedArr[src] = true;

		while (graphQueue.size() != 0) {

			src = graphQueue.poll();
			System.out.println(nodeList.get(src).nodeData + " is visited!");

			for (int i = 0; i < nodeGraph[src].length; i++) {
				if (nodeGraph[src][i] == 1 && !visitedArr[i]) {
					graphQueue.offer(i);
					visitedArr[i] = true;
				}
			}

		}

	}

}

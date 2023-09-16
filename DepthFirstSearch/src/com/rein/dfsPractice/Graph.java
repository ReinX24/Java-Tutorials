package com.rein.dfsPractice;

import java.util.ArrayList;

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
		for (int i = 0; i < nodeGraph.length; i++) {
			System.out.print(nodeList.get(i).nodeData + " ");
		}
		System.out.println();
		for (int i  = 0; i < nodeGraph.length; i++) {
			System.out.print(nodeList.get(i).nodeData + " ");
			for (int j = 0; j < nodeGraph[i].length; j++) {
				System.out.print(nodeGraph[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void depthFirstSearch(int src) {
		boolean[] visitNode = new boolean[this.nodeGraph.length];
		dfsHelper(src, visitNode);
	}
	
	public void dfsHelper(int src, boolean[] visitNode) {
		if (visitNode[src]) {
			return;
		} else {
			visitNode[src] = true;
			System.out.println(nodeList.get(src).nodeData + " visited!");
		}
		for (int i = 0; i < nodeGraph[src].length; i++) {
			if (nodeGraph[src][i] == 1) {
				dfsHelper(i, visitNode);
			}
		}
	}

}

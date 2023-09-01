package com.rein.adjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	
	// Creating an ArrayList that contains LinkedLists of Nodes
	ArrayList<LinkedList<Node>> graphList;

	public Graph() {
		graphList = new ArrayList<>();
	}
	
	public void addNode(Node newNode) {
		LinkedList<Node> currentList = new LinkedList<>();
		currentList.add(newNode);
		graphList.add(currentList);
	}
	
	public void addEdge(int src, int dst) {
		LinkedList<Node> currentList =  graphList.get(src);
		Node dstNode = graphList.get(dst).get(0); // address of the node we would like src to link to
		currentList.add(dstNode);
	}
	
	public boolean checkEdge(int src, int dst) {
		LinkedList<Node> currentList =  graphList.get(src);
		Node dstNode = graphList.get(dst).get(0);
		// Checking if the LinkedList in src has our dstNode
		for (Node eachNode : currentList) {
			if (eachNode == dstNode) {
				return true;
			}
		}
		return false;
	}
	
	public void printGraph() {
		for (LinkedList<Node> eachList : graphList) {
			for (Node eachNode : eachList) {
				System.out.print(eachNode.nodeData + " -> ");
			}
			System.out.println();
		}
	}
	
}

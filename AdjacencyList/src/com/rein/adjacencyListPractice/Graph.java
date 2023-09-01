package com.rein.adjacencyListPractice;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

	ArrayList<LinkedList<Node>> graphList;

	public Graph() {
		graphList = new ArrayList<>();
	}

	void addNode(Node newNode) {
		LinkedList<Node> newList = new LinkedList<>();
		newList.add(newNode);
		graphList.add(newList);
	}

	void addEdge(int srcNode, int dstNode) {
		LinkedList<Node> currentList = graphList.get(srcNode); // getting our source node in our ArrayList
		Node edgeNode = graphList.get(dstNode).get(0); // the first index of any node is its head
		currentList.add(edgeNode);
	}

	boolean checkEdge(int srcNode, int dstNode) {
		LinkedList<Node> currentList = graphList.get(srcNode);
		Node edgeNode = graphList.get(dstNode).get(0);
		for (Node eachNode : currentList) {
			if (eachNode == edgeNode) {
				return true;
			}
		}
		return false;
	}
	
	void printList() {
		for (LinkedList<Node> eachList : graphList) {
			for (Node eachNode : eachList) {
				System.out.print(eachNode.nodeData + " -> ");
			}
			System.out.println();
		}
	}

}

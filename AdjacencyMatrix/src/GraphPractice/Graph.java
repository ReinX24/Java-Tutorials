package GraphPractice;

import java.util.ArrayList;

// This class will be used to store our Node objects
public class Graph {

	ArrayList<Node> nodeList;
	int[][] matrixArr;

	// Our graph will have 5 methods, a constructor, method for adding a node to our
	// graph, adding an edge from one node to another, checking if there is an edge
	// from one node to another, and printing the graph

	public Graph(int graphSize) {
		nodeList = new ArrayList<>();
		matrixArr = new int[graphSize][graphSize];
	}

	public void addNode(Node newNode) {
		nodeList.add(newNode);
	}

	public void addEdge(int nodeSrc, int nodeDst) {
		matrixArr[nodeSrc][nodeDst]++;
	}

	public boolean checkEdge(int nodeSrc, int nodeDst) {
		return matrixArr[nodeSrc][nodeDst] == 1;
	}

	public void printGraph() {
		// Node markers for columns
		System.out.print("  ");
		for (Node eachNode : nodeList) {
			System.out.print(eachNode.nodeData + " ");
		}
		System.out.println();
		for (int i = 0; i < matrixArr.length; i++) {
			// Node markers for rows
			System.out.print(nodeList.get(i).nodeData + " ");
			for (int j = 0; j < matrixArr[i].length; j++) {
				System.out.print(matrixArr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

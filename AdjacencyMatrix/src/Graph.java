import java.util.ArrayList;

public class Graph {

	ArrayList<Node> nodesList; // ArrayList that will store our nodes
	int[][] graphMatrix;

	public Graph(int size) {
		nodesList = new ArrayList<>();
		graphMatrix = new int[size][size];
	}

	public void addNode(Node node) {
		nodesList.add(node);
	}

	public void addEdge(int src, int dst) {
		// Adding an edge between two nodes, this means that there is a path between two
		// nodes and we represent this path by putting in 1 in an index
		// src = row, dst = column
		graphMatrix[src][dst] = 1;
	}

	public boolean checkEdge(int src, int dst) {
		return graphMatrix[src][dst] == 1;
	}

	public void print() {
		System.out.print("  ");
		for (Node eachNode : nodesList) {
			System.out.print(eachNode.data + " ");
		}
		System.out.println();
		for (int i = 0; i < graphMatrix.length; i++) {
			System.out.print(nodesList.get(i).data + " ");
			for (int j = 0; j < graphMatrix[i].length; j++) {
				System.out.print(graphMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}


public class Main {

	public static void main(String[] args) {
		// Adjacency Matrix = A 2D array to store 1's/0's to represent edges
		// # of rows = # of unique nodes
		// # of columns = # of unique nodes

		// runtime complexity to check an Edge: 0(1)
		// space complexity: 0(n^2)

		// Creating a Graph object using our Graph class
		Graph myGraph = new Graph(5);
		// Adding nodes to our graph
		myGraph.addNode(new Node('A')); // index of 0
		myGraph.addNode(new Node('B')); // 1
		myGraph.addNode(new Node('C')); // 2
		myGraph.addNode(new Node('D')); // 3
		myGraph.addNode(new Node('E')); // 4
		// Adding edges to our graph
		myGraph.addEdge(0, 1); // node A and B will have an edge connecting them together
		myGraph.addEdge(1, 2);
		myGraph.addEdge(2, 3);
		myGraph.addEdge(2, 4); // node D will not have any edges

		// Adding 2 edges from E to A and E to C
		myGraph.addEdge(4, 0);
		myGraph.addEdge(4, 2);

		myGraph.print();

		// Checking edges, checking if there is an edge from one node to another node
		System.out.println(myGraph.checkEdge(0, 1)); // checking if there is an edge between nodes A and B, there is so
														// this returns true
		System.out.println(myGraph.checkEdge(3, 2)); // checking edges from D to C, returns false
	}

}

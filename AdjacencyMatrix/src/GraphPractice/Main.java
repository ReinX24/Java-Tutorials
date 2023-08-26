package GraphPractice;

public class Main {
	
	public static void main(String[] args) {
		// Challenge: create a Adjacency Matrix in regards to the graph photo inside this package
		// Creating our Graph object
		Graph myGraph = new Graph(5); // we will have 5 nodes
		// Adding our nodes
		myGraph.addNode(new Node('A'));
		myGraph.addNode(new Node('B'));
		myGraph.addNode(new Node('C'));
		myGraph.addNode(new Node('D'));
		myGraph.addNode(new Node('E'));
		
		myGraph.addEdge(0, 1); // A to B
		myGraph.addEdge(1, 2); // B to C
		myGraph.addEdge(1, 4); // B to E
		myGraph.addEdge(2, 4); // C to E
		myGraph.addEdge(4, 2); // E to C
		myGraph.addEdge(4, 0); // E to A
		myGraph.addEdge(2, 3); // C to D
		
		// Printing our Adjacency Matrix
		myGraph.printGraph();
		
		// Checking edges from one node to another
		System.out.println(myGraph.checkEdge(0, 1)); // A to B true, there is an edge
		System.out.println(myGraph.checkEdge(1, 4)); // B to E true
		System.out.println(myGraph.checkEdge(0, 4)); // A to E false, there is no edge
		System.out.println(myGraph.checkEdge(2, 1)); // C to B false
		
	}

}

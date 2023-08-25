
public class Main {

	public static void main(String[] args) {
		// There are 2 kinds of graphs, directed and undirected graph
		// A graph consists of 2 main components, the node or vertex (where the elements
		// are stored) and edges (the connectors of these nodes)
		// Link to video: https://youtu.be/-VgHk7UMPP4?si=iRyeSwVmxZliOSdG&t=278

		// To somewhat summarize, an adjacency matrix has an 0(1) time complexity but
		// 0(n ^ 2) space complexity, this means that while it can look up if there is a
		// vertex between two nodes in constant time, it does take up a lot of space

		// On the other hand, an adjacency list has the time complexity of 0(n) and a
		// space complexity of 0(n + e), n for nodes and e for edges, this means that
		// the time it takes to find a node is dependent on n which is the number of
		// nodes but the space it takes up is less than an adjacency matrix
	}

}

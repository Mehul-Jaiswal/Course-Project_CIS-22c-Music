
/**
 * Graph.java
 * @authors Mehul Jaiswal, Dinh Dang Nyugen
 * CIS 22C, Lab 6
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	private int vertices;
	private int edges;
	private ArrayList<LinkedList<String>> adj;
	private ArrayList<Character> color;
	private ArrayList<Integer> distance;
	private ArrayList<String> parent;
	private ArrayList<Integer> discoverTime;
	private ArrayList<Integer> finishTime;

	/** Constructors and Destructors */

	/**
	 * Initializes an empty graph, with n vertices and 0 edges
	 * 
	 * @param n the number of vertices in the graph
	 */
	public Graph(int n) {
		adj = new ArrayList<>(n + 1);
		color = new ArrayList<>(n + 1);
		distance = new ArrayList<>(n + 1);
		parent = new ArrayList<>(n + 1);
		discoverTime = new ArrayList<>(n + 1);
		finishTime = new ArrayList<>(n + 1);

		vertices = n;
		edges = 0;

		for (int i = 0; i <= n + 1; i++) {
			adj.add(new LinkedList<>());
			color.add('W');
			distance.add(-1);
			parent.add(null);
			discoverTime.add(-1);
			finishTime.add(-1);
		}
	}

	/*** Accessors ***/

	/**
	 * Returns the number of edges in the graph
	 * 
	 * @return the number of edges
	 */
	public int getNumEdges() {
		return edges;
	}

	/**
	 * Returns the number of vertices in the graph
	 * 
	 * @return the number of vertices
	 */
	public int getNumVertices() {
		return vertices;
	}

	/**
	 * returns whether the graph is empty (no edges)
	 * 
	 * @return whether the graph is empty
	 */
	public boolean isEmpty() {
		return getNumEdges() == 0;
	}

	/**
	 * Returns the value of the distance[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the distance of vertex v
	 * @throws IndexOutOfBoundsException when v is out of bounds
	 */
	public Integer getDistance(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("v not in range of vertices");
		}
		return distance.get(v);
	}

	/**
	 * Returns the value of the parent[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the parent of vertex v
	 * @throws IndexOutOfBoundsException when v is out of bounds
	 */
	public String getParent(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("v not in range of vertices");
		}
		return parent.get(v);
	}

	/**
	 * Returns the value of the color[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the color of vertex v
	 * @throws IndexOutOfBoundsException when v is out of bounds
	 */
	public Character getColor(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("v not in range of vertices");
		}
		return color.get(v);
	}

	/**
	 * Returns the value of the discoverTime[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the discover time of vertex v
	 * @throws IndexOutOfBoundsException when v is out of bounds
	 */
	public Integer getDiscoverTime(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("v not in range of vertices");
		}
		return discoverTime.get(v);
	}

	/**
	 * Returns the value of the finishTime[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the finish time of vertex v
	 * @throws IndexOutOfBoundsException when v is out of bounds
	 */
	public Integer getFinishTime(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("v not in range of vertices");
		}
		return finishTime.get(v);
	}

	/**
	 * Returns the LinkedList stored at index v
	 * 
	 * @param v a vertex in the graph
	 * @return the adjacency LinkedList a v
	 * @precondition 0 < v <= vertices
	 * @throws IndexOutOfBoundsException when v is out of bounds
	 */
	public ArrayList<Integer> getAdjacencyList(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("v not in range of vertices");
		}
		return adj.get(v);
	}

	/**
	 * Returns the value of the parent[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the parent of vertex v
	 * @throws IndexOutOfBoundsException when v is out of bounds
	 */
	public String getParent(String v) throws IndexOutOfBoundsException {
		if (!isValidVertex(v)) {
			throw new IndexOutOfBoundsException("v not in range of vertices");
		}
		return parent.get(Integer.parseInt(v));
	}

	/*** Manipulation Procedures ***/

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e., inserts v into
	 * the
	 * list at index u)
	 * 
	 * @throws IndexOutOfBoundsException when u or v is out of bounds
	 */
	public void addDirectedEdge(String u, String v) throws IndexOutOfBoundsException {
		if (!isValidVertex(u) || !isValidVertex(v)) {
			throw new IndexOutOfBoundsException("u or v not in range of vertices");
		}
		this.adj.get(Integer.parseInt(u)).addLast(v);
		edges++;
	}

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e., inserts v into
	 * the
	 * list at index u) and inserts u into the adjacent vertex list of v
	 * 
	 * @throws IndexOutOfBoundsException when u or v is out of bounds
	 */
	public void addUndirectedEdge(String u, String v) throws IndexOutOfBoundsException {
		if (!isValidVertex(u) || !isValidVertex(v)) {
			throw new IndexOutOfBoundsException("u or v not in range of vertices");
		}
		this.adj.get(Integer.parseInt(v)).addLast(u);
		this.adj.get(Integer.parseInt(u)).addLast(v);
		edges++;
	}

	/*** Additional Operations ***/

	/**
	 * Creates a String representation of the Graph Prints the adjacency list of
	 * each vertex in the graph, vertex: <space-separated list of adjacent vertices>
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= vertices; i++) {
			str.append(i + ": ");
			str.append(adj.get(i).toString() + "\n");
		}
		return str.toString();
	}

	/**
	 * Performs depth-first search on this Graph starting from a given source vertex
	 * 
	 * @param source the starting vertex
	 * @return ArrayList of vertices visited in DFS order
	 * @throws IndexOutOfBoundsException when the source vertex is out of bounds of
	 *                                   the graph
	 */
	public ArrayList<String> DFS(String source) throws IndexOutOfBoundsException {
		ArrayList<String> result = new ArrayList<>();
		if (!isValidVertex(source)) {
			throw new IndexOutOfBoundsException("Source vertex is out of bounds");
		}
		dfsHelper(result, source);
		return result;
	}

	/**
	 * Private recursive helper method for DFS
	 * 
	 * @param ans     the ArrayList to store the result
	 * @param vertex  the current vertex being visited
	 * @param visited a Set to keep track of visited vertices
	 */
	private void dfsHelper(ArrayList<String> result, String vertex) {
		// visited.add(vertex);
		ArrayList<String> adjacencyList = getAdjacencyList(vertex);
		if (adjacencyList != null) {
			for (String i : adjacencyList) {
				dfsHelper(result, i);
			}
		}
		result.add(vertex);
	}

	/**
	 * Checks if a vertex is valid (i.e., within the range of vertices)
	 * 
	 * @param vertex the vertex to check
	 * @return true if the vertex is valid, false otherwise
	 */
	private boolean isValidVertex(String vertex) {
		int v = Integer.parseInt(vertex);
		return v >= 1 && v <= vertices;
	}
}

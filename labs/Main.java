
/**
 * Graph_Application.java
 * @authors Mehul Jaiswal, Dinh Dang Nyugen
 * CIS 22C, Lab 6
 */
import Graph_Application;

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");

		String startVertex = "A";
		System.out.println("DFS Traversal from " + startVertex + ": " + graph.dfs(startVertex));
	}
}

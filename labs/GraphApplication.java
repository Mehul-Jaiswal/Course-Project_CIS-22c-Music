
/**
 * Graph.java
 * @authors Mehul Jaiswal, Dinh Dang Nyugen
 * CIS 22C, Lab 6
 */

import java.util.*;

public class GraphApplication {
	private TreeMap<String, List<String>> adjList;

	public Graph() {
        adjList = new TreeMap<>();
    }

	public void addVertex(String vertex) {
		adjList.put(vertex, new ArrayList<>());
	}

	public void addEdge(String source, String destination) {
		adjList.get(source).add(destination);
		// adjList.get(destination).add(source);
	}

	public List<String> getNeighbors(String vertex) {
		return adjList.get(vertex);
	}

	public Set<String> getVertices() {
		return adjList.keySet();
	}

	public List<String> dfs(String startVertex) {
		List<String> result = new ArrayList<>();
		Set<String> visited = new HashSet<>();

		dfshelper(startVertex, visited, result);

		return result;
	}

	private void dfshelper(String vertex, Set<String> visited, List<String> traversal) {
		visited.add(vertex);
		traversal.add(vertex);

		for (String neighbor : adjList.get(vertex)) {
			if (!visited.contains(neighbor)) {
				dfshelper(neighbor, visited, traversal);
			}
		}
	}
}

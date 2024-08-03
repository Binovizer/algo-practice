package algo.practice.v2.paradigms.graph;

import java.util.List;

/**
 * The type IsUndirectedGraphCyclic provides methods to check if a undirected graph has a cycle
 *
 * @author nadeem Date : 13/07/21
 */
public class IsUndirectedGraphCyclic {

    public boolean hasCycle(Graph graph) {
        int V = graph.getVertices();
        List<List<Integer>> adjList = graph.getAdjList();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && hasCycle(adjList, i, -1, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(
            List<List<Integer>> adjList, int index, int parent, boolean[] visited) {
        visited[index] = true;
        List<Integer> children = adjList.get(index);
        for (int child : children) {
            if (!visited[child]) {
                if (hasCycle(adjList, child, index, visited)) {
                    return true;
                }
            } else if (child != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new UndirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(3, 2);
        graph.addEdge(0, 2);

        IsUndirectedGraphCyclic isUndirectedGraphCyclic = new IsUndirectedGraphCyclic();
        boolean hasCycle = isUndirectedGraphCyclic.hasCycle(graph);
        System.out.println("hasCycle = " + hasCycle);
    }
}

package algo.practice.v2.paradigms.graph;

import java.util.List;

/**
 * The type IsDirectedGraphCyclic provides methods to check if a directed graph has a cycle
 *
 * @author nadeem Date : 13/07/21
 */
public class IsDirectedGraphCyclic {

    public boolean hasCycle(Graph graph) {
        int V = graph.getVertices();
        List<List<Integer>> adjList = graph.getAdjList();
        boolean[] visited = new boolean[V];
        boolean[] beingVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (hasCycle(adjList, i, visited, beingVisited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(
            List<List<Integer>> adjList, int index, boolean[] visited, boolean[] beingVisited) {
        if (visited[index]) {
            return false;
        }
        if (beingVisited[index]) {
            return true;
        }
        visited[index] = true;
        beingVisited[index] = true;
        List<Integer> neighbours = adjList.get(index);
        for (int neighbour : neighbours) {
            if (hasCycle(adjList, neighbour, visited, beingVisited)) {
                return true;
            }
        }
        beingVisited[index] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new DirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(3, 2);
        graph.addEdge(2, 0);

        IsDirectedGraphCyclic isDirectedGraphCyclic = new IsDirectedGraphCyclic();
        boolean hasCycle = isDirectedGraphCyclic.hasCycle(graph);
        System.out.println("hasCycle = " + hasCycle);
    }
}

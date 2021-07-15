package algo.practice.v2.paradigms.graph;

import java.util.Arrays;

/**
 * The Dijkstra type provides the implementation of Dijkstra's algorithm to find the shortest path
 * from source to vertex
 *
 * @author nadeem Date : 14/07/21
 */
public class Dijkstra {

    public static void main(String[] args) {
        Graph graph = new UndirectedGraph(9);
        graph.addWeightedEdge(0, 1, 4);
        graph.addWeightedEdge(0, 7, 8);
        graph.addWeightedEdge(1, 7, 11);
        graph.addWeightedEdge(1, 2, 8);
        graph.addWeightedEdge(7, 8, 7);
        graph.addWeightedEdge(8, 2, 2);
        graph.addWeightedEdge(8, 6, 6);
        graph.addWeightedEdge(6, 5, 2);
        graph.addWeightedEdge(7, 6, 1);
        graph.addWeightedEdge(2, 5, 4);
        graph.addWeightedEdge(2, 3, 7);
        graph.addWeightedEdge(3, 5, 14);
        graph.addWeightedEdge(4, 5, 10);
        graph.addWeightedEdge(3, 4, 9);

        graph.printWeightedGraph();

        int[] dist = findShortestPath(graph, 0);
        System.out.println(Arrays.toString(dist));
    }

    private static int[] findShortestPath(Graph graph, int source) {
        int V = graph.getVertices();
        int[][] adjMatrix = graph.getAdjMatrix();
        int[] dist = new int[V];
        boolean[] processed = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, processed);
            processed[u] = true;
            for (int v = 0; v < V; v++) {
                if (!processed[v] && adjMatrix[u][v] != 0) {
                    dist[v] = Math.min(dist[v], dist[u] + adjMatrix[u][v]);
                }
            }
        }
        return dist;
    }

    private static int minDistance(int[] dist, boolean[] processed) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < processed.length; i++) {
            if (!processed[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

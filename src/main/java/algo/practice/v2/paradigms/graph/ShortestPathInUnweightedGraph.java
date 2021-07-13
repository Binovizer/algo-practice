package algo.practice.v2.paradigms.graph;

import java.util.*;

/**
 * The type ShortestPathInUnweightedGraph provides methods to find the shortest paths from source to
 * destination
 *
 * @author nadeem Date : 13/07/21
 */
public class ShortestPathInUnweightedGraph {

    public static void main(String[] args) {
        Graph graph = new UndirectedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 7);
        graph.addEdge(7, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 4);
        graph.addEdge(6, 4);
        graph.addEdge(6, 7);
        graph.addEdge(6, 5);
        graph.addEdge(4, 5);

        ShortestPathInUnweightedGraph shortestPathInUnweightedGraph =
                new ShortestPathInUnweightedGraph();
        int from = 0, to = 7;
        List<Integer> path = shortestPathInUnweightedGraph.findShortestPath(graph, from, to);
        System.out.println("path = " + path);
    }

    private List<Integer> findShortestPath(Graph graph, int from, int to) {
        int V = graph.getVertices();
        List<List<Integer>> adjList = graph.getAdjList();
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[V];
        if (!bfs(adjList, from, to, visited, parent)) {
            // path does not exist
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        int curr = to;
        ans.add(to);
        while (curr != from) {
            ans.add(parent[curr]);
            curr = parent[curr];
        }
        Collections.reverse(ans);
        return ans;
    }

    private boolean bfs(
            List<List<Integer>> adjList, int from, int to, boolean[] visited, int[] parent) {
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(from);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            visited[current] = true;
            List<Integer> neighbours = adjList.get(current);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    parent[neighbour] = current;
                    q.offer(neighbour);
                    if (neighbour == to) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

package algo.practice.v2.paradigms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * BFS type provides methods to traverse the graph in the Breadth First Search(BFS) manner.
 *
 * @author nadeem Date : 13/07/21
 */
public class BFS {

    public static void main(String[] args) {
        Graph graph = new DirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);

        BFS bfs = new BFS();
        List<Integer> traversal = bfs.traverse(graph);
        System.out.println("BFS Traversal = " + traversal);
    }

    private List<Integer> traverse(Graph graph) {
        List<Integer> ans = new ArrayList<>();
        int N = graph.getVertices();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                traverse(graph.getAdjList(), i, ans, visited);
            }
        }
        return ans;
    }

    private void traverse(
            List<List<Integer>> adjList, int index, List<Integer> ans, boolean[] visited) {
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(index);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            if (!visited[current]) {
                visited[current] = true;
                ans.add(current);
                List<Integer> neighbours = adjList.get(current);
                for (int neighbour : neighbours) {
                    q.offer(neighbour);
                }
            }
        }
    }
}

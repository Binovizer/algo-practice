package algo.practice.v2.paradigms.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * DFS type provides methods to traverse the graph in the Depth First Search(DFS) manner.
 *
 * @author nadeem Date : 13/07/21
 */
public class DFS {

    public List<Integer> traverse(Graph graph) {
        List<Integer> ans = new LinkedList<>();
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
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        ans.add(index);
        List<Integer> neighbours = adjList.get(index);
        for (int neighbour : neighbours) {
            traverse(adjList, neighbour, ans, visited);
        }
    }

    public static void main(String[] args) {
        Graph graph = new DirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);

        DFS dfs = new DFS();
        List<Integer> traversal = dfs.traverse(graph);
        System.out.println("DFS Traversal = " + traversal);
    }
}

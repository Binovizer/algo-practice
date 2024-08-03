package algo.practice.v1.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * The type BFS
 *
 * @author Mohd Nadeem
 */
public class BFS {

    public static void main(String[] args) {
        Graph graph = new Graph();
        GraphNode a = new GraphNode("A", 1);
        GraphNode b = new GraphNode("B", 2);
        GraphNode c = new GraphNode("C", 3);
        GraphNode d = new GraphNode("D", 4);
        GraphNode e = new GraphNode("E", 5);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(a, e);
        graph.addEdge(b, d);
        graph.addEdge(b, e);
        graph.addEdge(d, e);
        graph.printGraph();

        BFS bfs = new BFS();
        bfs.bfs(graph, a);
    }

    void bfs(Graph graph, GraphNode start) {
        System.out.print("BFS : ");
        Map<GraphNode, List<GraphNode>> adjacencyList = graph.getAdjacencyList();
        Queue<GraphNode> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            GraphNode poll = q.poll();
            poll.setState(State.VISITING);
            System.out.print(poll.getVertex() + " ");
            List<GraphNode> graphNodes = adjacencyList.get(poll);
            for (GraphNode graphNode : graphNodes) {
                if (graphNode.getState() == State.UNVISITED) {
                    graphNode.setState(State.VISITING);
                    q.offer(graphNode);
                }
            }
            poll.setState(State.VISITED);
        }
    }
}

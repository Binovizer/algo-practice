package graph;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * The type BFS
 *
 * @author Mohd Nadeem
 */
public class DFS {

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

    DFS dfs = new DFS();
    dfs.dfs(graph, a);
  }

  void dfs(Graph graph, GraphNode start) {
    System.out.print("DFS : ");
    Map<GraphNode, List<GraphNode>> adjacencyList = graph.getAdjacencyList();
    Stack<GraphNode> stack = new Stack<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      GraphNode pop = stack.pop();
      pop.setState(State.VISITING);
      System.out.print(pop.getVertex() + " ");
      List<GraphNode> graphNodes = adjacencyList.get(pop);
      for (GraphNode graphNode : graphNodes) {
        if (graphNode.getState() == State.UNVISITED) {
          graphNode.setState(State.VISITING);
          stack.push(graphNode);
        }
      }
      pop.setState(State.VISITED);
    }
  }
}

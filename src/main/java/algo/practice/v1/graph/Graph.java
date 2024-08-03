package algo.practice.v1.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Graph
 *
 * @author Mohd Nadeem
 */
public class Graph {

    private List<GraphNode> vertices;
    private Map<GraphNode, List<GraphNode>> adjacencyList;

    public Graph() {
        this.vertices = new ArrayList<>();
        adjacencyList = new HashMap<>();
    }

    public List<GraphNode> getVertices() {
        return vertices;
    }

    public Map<GraphNode, List<GraphNode>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addVertex(GraphNode vertex) {
        vertices.add(vertex);
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(GraphNode source, GraphNode destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void printGraph() {
        System.out.println("***** START OF GRAPH *****");
        for (GraphNode vertex : vertices) {
            System.out.print(vertex.getValue() + " -> ");
            List<GraphNode> graphNodes = adjacencyList.get(vertex);
            for (GraphNode graphNode : graphNodes) {
                System.out.print(graphNode.getValue() + " -> ");
            }
            System.out.println("NULL");
        }
        System.out.println("***** END OF GRAPH *****");
    }
}

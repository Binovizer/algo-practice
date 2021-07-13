package algo.practice.v2.paradigms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Graph is a representation of a graph
 *
 * @author nadeem Date : 13/07/21
 */
public abstract class Graph {

    private final int vertices;
    private final List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < this.vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public abstract void addEdge(int u, int v);

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public int getVertices() {
        return vertices;
    }
}

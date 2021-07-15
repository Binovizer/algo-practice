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
    private final int[][] adjMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        adjMatrix = new int[vertices][vertices];
        for (int i = 0; i < this.vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public abstract void addEdge(int u, int v);

    public abstract void addWeightedEdge(int u, int v, int w);

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public int getVertices() {
        return vertices;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void printWeightedGraph() {
        System.out.println("#### GRAPH START ####");
        int[][] adjMatrix = this.getAdjMatrix();
        for (int[] row : adjMatrix) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        System.out.println("#### GRAPH END ####");
    }
}

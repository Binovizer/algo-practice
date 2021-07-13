package algo.practice.v2.paradigms.graph;

/**
 * UndirectedGraph type provides methods to create and modify an undirected graph.
 *
 * @author nadeem Date : 13/07/21
 */
public class UndirectedGraph extends Graph {

    public UndirectedGraph(int vertices) {
        super(vertices);
    }

    public void addEdge(int u, int v) {
        super.getAdjList().get(u).add(v);
        super.getAdjList().get(v).add(u);
    }
}

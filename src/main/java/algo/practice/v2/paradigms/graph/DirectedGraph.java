package algo.practice.v2.paradigms.graph;

/**
 * DirectedGraph type provides methods to create and modify an directed graph.
 *
 * @author nadeem Date : 13/07/21
 */
public class DirectedGraph extends Graph {

    public DirectedGraph(int vertices) {
        super(vertices);
    }

    public void addEdge(int u, int v) {
        super.getAdjList().get(u).add(v);
    }
}

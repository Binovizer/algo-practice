package algo.practice.v2.daily_coding_problem;

/**
 * The type GraphNode
 *
 * @author nadeem Date : 15/02/24
 */
public class GraphNode<K, V> {
    K vertex;
    V weight;

    public GraphNode(K vertex, V weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "GraphNode{" + "vertex=" + vertex + ", weight=" + weight + '}';
    }
}

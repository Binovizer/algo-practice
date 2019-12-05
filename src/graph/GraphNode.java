package graph;

import java.util.Objects;

/**
 * The type GraphNode
 *
 * @author Mohd Nadeem
 */
public class GraphNode {

    private String vertex;
    private int value;
    private State state;

    public GraphNode() {
    }

    public GraphNode(String vertex, int value) {
        this.vertex = vertex;
        this.value = value;
        this.state = State.UNVISITED;
    }

    public String getVertex() {
        return vertex;
    }

    public int getValue() {
        return value;
    }

    public State getState() {
        return state;
    }

    public void setVertex(String vertex) {
        this.vertex = vertex;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return value == graphNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

package ua.nure.timoshenko.practice6.part4;

import java.util.Objects;

public class Edge {
    private Vertex vertex1;
    private Vertex vertex2;

    public Edge(Vertex vertex1, Vertex vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Edge reversEdge() {
        return new Edge(vertex2, vertex1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Edge edge = (Edge) o;
        return Objects.equals(vertex1, edge.vertex1) &&
                Objects.equals(vertex2, edge.vertex2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vertex1, vertex2);
    }

    @Override
    public String toString() {
        return "Edge ==> " + vertex1 + " + " + vertex2;
    }
}

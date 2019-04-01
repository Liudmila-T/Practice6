package ua.nure.timoshenko.practice6.part4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {
    private int x;
    private int y;
    private List<Edge> edgeList;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
        edgeList = new ArrayList<>();
    }

    public List<Edge> getEdgeList() {
        return edgeList.subList(0, edgeList.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return x == vertex.x &&
                y == vertex.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

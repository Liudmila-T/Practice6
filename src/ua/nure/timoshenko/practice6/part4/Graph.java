package ua.nure.timoshenko.practice6.part4;

public class Graph {

    private Vertex[] arrGraph;

    Graph(int numberVertices) {
        arrGraph = new Vertex[numberVertices];
    }

    public boolean addEdge(int n1, int n2) {
        boolean result = false;
        if (isN1(n1) && isN2(n2) && (n1 != n2)) {
            Edge edge = new Edge(arrGraph[n1], arrGraph[n2]);
            if ((!(arrGraph[n1].getEdgeList().contains(edge)))
                    && (!(arrGraph[n1].getEdgeList().contains(edge.reversEdge())))) {
                arrGraph[n1].getEdgeList().add(edge);
                arrGraph[n2].getEdgeList().add(edge);
                result = true;
            }
        }
        return result;

    }

    private boolean isN1(int n1) {
        return ((n1 > 0) && (n1 < arrGraph.length));
    }

    private boolean isN2(int n2) {
        return ((n2 > 0) && (n2 < arrGraph.length));
    }

    public boolean deleteEdge(int n1, int n2) {
        boolean result = false;
        if (isN1(n1) && isN2(n2) && (n1 != n2)) {
            Edge edge = new Edge(arrGraph[n1], arrGraph[n2]);
            if (arrGraph[n1].getEdgeList().contains(edge)) {
                arrGraph[n1].getEdgeList().remove(edge);
                arrGraph[n2].getEdgeList().remove(edge);
                result = true;
            }
            if (arrGraph[n1].getEdgeList().contains(edge.reversEdge())) {
                arrGraph[n1].getEdgeList().remove(edge.reversEdge());
                arrGraph[n2].getEdgeList().remove(edge.reversEdge());
                result = true;
            }
        }
        return result;
    }


    public boolean addVertex(Vertex vertex) {
        boolean result = false;
        boolean check = false;
        for (int i = 0; i < arrGraph.length; i++) {
            if ((vertex.equals(arrGraph[i]))) {
                check = true;
                break;
            }
        }
        if (!check) {
            for (int i = 0; i < arrGraph.length; i++) {
                if (arrGraph[i] == null) {
                    arrGraph[i] = vertex;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex is : arrGraph) {
            if (is != null) {
                sb.append(is).append(is.getEdgeList()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
package ua.nure.timoshenko.practice6.part4;

public class Part4 {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addVertex(new Vertex(1, 2));
        //  попытка добавить такую же вершину
        graph.addVertex(new Vertex(1, 2));
        graph.addVertex(new Vertex(3, 2));
        graph.addVertex(new Vertex(4, 1));
        graph.addVertex(new Vertex(1, 3));

        System.out.println(graph);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println(graph);


        System.out.println(" After deleteEdge "+ graph.deleteEdge(2, 3));
        System.out.println(graph);
    }
}

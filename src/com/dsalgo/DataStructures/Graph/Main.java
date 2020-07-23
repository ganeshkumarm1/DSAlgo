package DataStructures.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
    }
}

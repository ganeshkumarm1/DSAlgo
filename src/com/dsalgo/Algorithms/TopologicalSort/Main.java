package Algorithms.TopologicalSort;

import DataStructures.Graph.Graph;
import DataStructures.Graph.Vertex;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(1, 0);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(4, 3);
        graph.addEdge(3, 2);

        List<Vertex> vertices = graph.getVertices();

        TopologicalSort topologicalSort = new TopologicalSort(graph, vertices);
        List<Vertex> sortedVertices = topologicalSort.sort();

        for(Vertex vertex: sortedVertices) {
            System.out.println(vertex.id);
        }
    }
}

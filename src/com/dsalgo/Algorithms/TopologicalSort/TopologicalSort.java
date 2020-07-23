package Algorithms.TopologicalSort;

import DataStructures.Graph.Graph;
import DataStructures.Graph.Vertex;

import java.util.*;

public class TopologicalSort {
    Graph graph;
    List<Vertex> vertices;

    public TopologicalSort(Graph graph, List<Vertex> vertices) {
        this.graph = graph;
        this.vertices = vertices;
    }

    public List<Vertex> sort() {
        Set<Vertex> visited = new HashSet<>();
        Deque<Vertex> stack = new ArrayDeque<>();

        for(Vertex vertex: vertices) {
            if(visited.contains(vertex)) {
                continue;
            }

            sortUtil(vertex, stack, visited);
        }

        return new ArrayList<>(stack);
    }

    private void sortUtil(Vertex vertex, Deque<Vertex> stack, Set<Vertex> visited) {
        visited.add(vertex);
        /*System.out.println("vertex: " + vertex.id);

        for(Vertex v: vertex.getAdjVertices()) {
            System.out.print(v.id + " ");
        }
        System.out.println("---------");*/
        for(Vertex adjVertex: vertex.getAdjVertices()) {
            if(visited.contains(adjVertex)) {
                continue;
            }

            sortUtil(adjVertex, stack, visited);
        }
//        System.out.println(vertex.id);
        stack.add(vertex);
    }
}

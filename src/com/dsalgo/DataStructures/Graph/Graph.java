package DataStructures.Graph;

import java.util.*;

public class Graph {
    List<Edge> edges;
    Map<Integer, Vertex> vertices;

    public Graph() {
        this.edges = new ArrayList<>();
        this.vertices = new HashMap<>();
    }

    private void addVertex(Vertex vertex) {
        vertices.put(vertex.id, vertex);
    }

    public void addEdge(int u, int v) {
        Vertex v1, v2;

        if(vertices.containsKey(u)) {
            v1 = vertices.get(u);
        }
        else {
            v1 = new Vertex(u);
            addVertex(v1);
        }

        if(vertices.containsKey(v)) {
            v2 = vertices.get(v);
        }
        else {
            v2 = new Vertex(v);
            addVertex(v2);
        }

        Edge edge = new Edge(v1, v2);
        edges.add(edge);

        v1.addAdjVertex(v2);
//        v2.addAdjVertex(v1);
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices.values());
    }
}

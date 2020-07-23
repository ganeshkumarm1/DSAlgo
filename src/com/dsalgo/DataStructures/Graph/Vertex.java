package DataStructures.Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public int id;
    List<Vertex> adjVertices;

    public Vertex(int id) {
        this.id = id;
        this.adjVertices = new ArrayList<>();
    }

    public void addAdjVertex(Vertex vertex) {
        adjVertices.add(vertex);
    }

    public List<Vertex> getAdjVertices() {
        return adjVertices;
    }
}

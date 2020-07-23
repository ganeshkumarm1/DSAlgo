package DataStructures.Graph;

public class Edge {
    Vertex u;
    Vertex v;
    int weight = -1;

    public Edge(Vertex u, Vertex v) {
        this.u = u;
        this.v = v;
    }

    public Edge(Vertex u, Vertex v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

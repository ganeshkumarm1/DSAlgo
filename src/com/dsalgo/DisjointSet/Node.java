package DisjointSet;

public class Node {
    int data;
    Node parent;
    int rank;

    public Node(int data) {
        this.data = data;
        this.parent = null;
        this.rank = 0;
    }
}

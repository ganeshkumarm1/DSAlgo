package DataStructures.DisjointSet;

import java.util.*;


public class DisjointSet {
    final private Map<Integer, Node> nodeMap = new HashMap<>();


    public void makeSet(int data) {
        Node node = new Node(data);
        nodeMap.put(data, node);
    }

    public Node find(Node node) {
        Node parent = node.parent;

        if(parent == null) {
            return node;
        }

        node.parent = find(parent);
        return node.parent;
    }

    public int find(int data) {
        return find(nodeMap.get(data)).data;
    }

    /*
        * Returns true if union can be done
        * Returns false if there is a cycle
    */
    public boolean union(int data1, int data2) {
        Node node1 = nodeMap.get(data1);
        Node node2 = nodeMap.get(data2);

        Node parent1 = find(node1);
        Node parent2 = find(node2);

        if(parent1 == parent2) {
            return false;
        }

        int rank1 = parent1.rank;
        int rank2 = parent2.rank;

        if(rank1 >= rank2) {
            parent1.rank += rank2;
            parent2.parent = parent1;
        }
        else {
            parent2.rank += rank1;
            parent1.parent = parent2;
        }

        return true;
    }
}

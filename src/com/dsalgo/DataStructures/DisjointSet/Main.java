package DataStructures.DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);
        data.add(6);
        data.add(7);
        data.add(8);

        DisjointSet disjointSet = new DisjointSet();

        for (Integer value: data) {
            disjointSet.makeSet(value);
        }

        System.out.println(disjointSet.union(1, 2));
        System.out.println(disjointSet.union(1, 3));
        System.out.println(disjointSet.union(2, 4));
        System.out.println(disjointSet.union(2, 5));
        System.out.println(disjointSet.union(3, 4));
        System.out.println(disjointSet.union(5, 6));
        System.out.println(disjointSet.union(5, 7));
        System.out.println(disjointSet.union(6, 8));
        System.out.println(disjointSet.union(7, 8));
    }
}

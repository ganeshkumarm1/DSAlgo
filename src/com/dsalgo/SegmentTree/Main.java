package SegmentTree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void findMin(int start, int end, SegmentTree segmentTree) {
        String result = "Minimum value between range " + start + " and " + end + " is ";

        System.out.println(result + segmentTree.query(start, end));
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(8);
        input.add(7);
        input.add(2);
        input.add(5);
        input.add(4);
        input.add(3);

        SegmentTree segmentTree = new SegmentTree(input.size());
        segmentTree.construct(input, 0, input.size() - 1, 0);

        System.out.println(segmentTree.toString());

        // 0 based index
        findMin(1, 3, segmentTree);
        findMin(0, 1, segmentTree);
        findMin(4, 5, segmentTree);
        findMin(2, 4, segmentTree);

        segmentTree.update(3, 1); // Point Update
        segmentTree.update(0, 5,1); // Range Update

        System.out.println(segmentTree.toString());

        findMin(1, 3, segmentTree);
        findMin(0, 1, segmentTree);
        findMin(4, 5, segmentTree);
        findMin(2, 4, segmentTree);
    }
}

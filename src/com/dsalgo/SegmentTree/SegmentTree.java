package SegmentTree;

import java.util.ArrayList;
import java.util.List;

public class SegmentTree {
    private final List<Integer> ST;
    private  List<Integer> input;
    private int n;

    public SegmentTree(int n) {
        int height = (int) Math.ceil((Math.log(n) / Math.log(2)));
        int stSize = 2 * (int) Math.pow(2, height) - 1;

        ST = new ArrayList<>();

        for(int i = 0; i < stSize; i ++) {
            ST.add(Integer.MAX_VALUE);
        }

        this.n = n;
    }

    public int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

    public int construct(List<Integer> input, int start, int end, int index) {
        this.input = input;

        if(start == end) {
            ST.set(index, input.get(start));
            return input.get(start);
        }

        int mid = getMid(start, end);

        ST.set(index, Math.min(construct(input, start, mid, (2 * index) + 1), construct(input, mid + 1, end, (2 * index) + 2)));

        return ST.get(index);
    }

    private int query(int queryStart, int queryEnd, int STStart, int STEnd, int index) {
        if(STEnd < queryStart || STStart > queryEnd) {
            return Integer.MAX_VALUE;
        }

        if(queryStart <= STStart && queryEnd >= STEnd) {
            return ST.get(index);
        }

        int mid = getMid(STStart, STEnd);

        return Math.min(
                query(queryStart, queryEnd, STStart, mid, (2 * index) + 1),
                query(queryStart, queryEnd, mid + 1, STEnd, (2 * index) + 2)
        );
    }

    public int query(int queryStart, int queryEnd) {
        return query(queryStart, queryEnd, 0, n - 1, 0);
    }

    public void update(int index, int value, int STStart, int STEnd, int STIndex) {
        if(index < STStart || index > STEnd) {
            return;
        }

        if(STStart == STEnd) {
            ST.set(STIndex, value);
            input.set(index, value);
        }
        else {
            int mid = getMid(STStart, STEnd);

            if(index >= STStart && index <= mid) {
                update(index, value, STStart, mid, 2 * STIndex + 1);
            }
            else {
                update(index, value, mid + 1, STEnd, 2 * STIndex + 2);
            }

            ST.set(STIndex, Math.min(ST.get(2 * STIndex + 1), ST.get(2 * STIndex + 2)));
        }

        return;

    }

    public void update(int index, int value) {
        update(index, value, 0, n - 1, 0);
    }

    @Override
    public String toString() {
        return "Input: " + input.toString() + "\n" + "Segment Tree: " + ST.toString();
    }
}

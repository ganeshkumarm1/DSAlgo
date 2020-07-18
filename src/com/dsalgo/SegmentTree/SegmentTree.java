package SegmentTree;

import java.util.ArrayList;
import java.util.List;

public class SegmentTree {
    private final List<Integer> ST; //Segment Tree
    private final List<Integer> LT; // Lazy Tree

    private  List<Integer> input;
    private int n;

    public SegmentTree(int n) {
        int height = (int) Math.ceil((Math.log(n) / Math.log(2)));
        int stSize = 2 * (int) Math.pow(2, height) - 1;

        ST = new ArrayList<>();
        LT = new ArrayList<>();

        for(int i = 0; i < stSize; i ++) {
            ST.add(Integer.MAX_VALUE);
            LT.add(0);
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

    private int query(int queryStart, int queryEnd, int STStart, int STEnd, int STIndex) {
        if(STStart > STEnd) {
            return Integer.MAX_VALUE;
        }

        if(LT.get(STIndex) != 0) {
            int LTValue = LT.get(STIndex);

            ST.set(STIndex, ST.get(STIndex) + LTValue);
            LT.set(STIndex, 0);


            if(STStart != STEnd) {
                LT.set(2 * STIndex + 1, LT.get(2 * STIndex + 1) + LTValue);
                LT.set(2 * STIndex + 2, LT.get(2 * STIndex + 2) + LTValue);
            }
        }

        if(STEnd < queryStart || STStart > queryEnd) {
            return Integer.MAX_VALUE;
        }

        if(queryStart <= STStart && queryEnd >= STEnd) {
            return ST.get(STIndex);
        }

        int mid = getMid(STStart, STEnd);

        int lValue = query(queryStart, queryEnd, STStart, mid, (2 * STIndex) + 1);
        int rValue = query(queryStart, queryEnd, mid + 1, STEnd, (2 * STIndex) + 2);

        return Math.min(lValue, rValue);
    }

    public int query(int queryStart, int queryEnd) {
        return query(queryStart, queryEnd, 0, n - 1, 0);
    }

    // Point Update
    public void update(int index, int value, int STStart, int STEnd, int STIndex) {
        if(index < STStart || index > STEnd) {
            return;
        }

        if(STStart == STEnd) {
            ST.set(STIndex, ST.get(STIndex) + value);
            input.set(index, input.get(index) + value);
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

    // Point Update
    public void update(int index, int value) {
        update(index, value, 0, n - 1, 0);
    }

    // Range Update
    public void update(int l, int r, int value, int STStart, int STEnd, int STIndex) {
        if(l > r) {
            return;
        }

        if(LT.get(STIndex) != 0) {
            ST.set(STIndex, LT.get(STIndex));
            if(l != r) {
                int curr = LT.get(STIndex);
                LT.set(2 * STIndex + 1, LT.get(2 * STIndex + 1) + curr);
                LT.set(2 * STIndex + 2, LT.get(2 * STIndex + 2) + curr);
            }

            LT.set(STIndex, 0);
        }

        if(l > STEnd || r < STStart) {
            return;
        }

        if(l <= STStart && r >= STEnd) {
            ST.set(STIndex, ST.get(STIndex) + value);

            if(l != r) {
                LT.set(2 * STIndex + 1, LT.get(2 * STIndex + 1) + value);
                LT.set(2 * STIndex + 2, LT.get(2 * STIndex + 2) + value);

            }

            return;
        }

        int mid = getMid(l, r);
        update(l, r, value, STStart, mid, 2 * STIndex + 1);
        update(l, r, value, mid + 1, STEnd, 2 * STIndex + 2);

        ST.set(STIndex, Math.min(ST.get(2 * STIndex + 1), ST.get(2 * STIndex + 2)));
    }

    // Range Update
    public void update(int l, int r, int value) {
        update(l, r, value, 0, n - 1, 0);
    }

    @Override
    public String toString() {
        return "Input: " + input.toString() + "\n"
                + "Segment Tree: " + ST.toString() + "\n"
                + "Lazy Tree: " + LT.toString();
    }
}

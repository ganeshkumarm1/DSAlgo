package FenwickTree;

import java.util.ArrayList;
import java.util.List;

/*
    * Also known as Binary Index Tree (BIT)
*/
public class FenwickTree {
    List<Integer> binaryIndexTree;

    private int getNext(int index) {
        return index + (index & -index);
    }

    private int getParent(int index) {
        return  index - (index & -index);
    }

    public void update(int index, int value) {
        index += 1;
        while (index < binaryIndexTree.size()) {
            binaryIndexTree.set(index, binaryIndexTree.get(index) + value);
            index = getNext(index);
        }
    }

    public void build(List<Integer> input) {
        int n = input.size();

        binaryIndexTree = new ArrayList<>();


        for(int i = 0; i <= n; i ++) {
            binaryIndexTree.add(0);
        }

        for(int i = 0; i < n; i ++) {
            update(i, input.get(i));
        }
    }

    private int getSum(int index) {
        int sum = 0;
        index += 1;

        while (index > 0) {
            sum += binaryIndexTree.get(index);
            index = getParent(index);
        }

        return sum;
    }

    public int getSum(int l, int r) {
        int lSum = getSum(l - 1);
        int rSum = getSum(r);

        return rSum - lSum;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for(int i = 1; i < binaryIndexTree.size(); i ++) {
            result.append(binaryIndexTree.get(i))
                    .append(", ");
        }
        result.append("]");

        return result.toString();
    }
}

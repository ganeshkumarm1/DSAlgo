package DataStructures.Set;

/*
 * Created by GaNeShKuMaRm
 * Created at 23-Jun-20, 5:11 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DevilSet {
    private final List<Integer> entries;

    public DevilSet() {
        this.entries = new ArrayList<>();
    }

    public int get(int index) {
        return entries.get(index);
    }

    public void add(int value) {
        if(isEmpty()) {
            entries.add(value);
        }
        else {
            boolean foundValue = false;
            for (Integer entry : entries) {
                if (entry == value) {
                    foundValue = true;
                    break;
                }
            }

            if(!foundValue) {
                entries.add(value);
            }
        }
    }

    public void remove(int value) {
        int removeIndex = -1;
        for(int i = 0; i < entries.size(); i ++) {
            if(entries.get(i) == value) {
                removeIndex = i;
                break;
            }
        }

        entries.remove(removeIndex);
    }

    public boolean contains(int value) {
        for (Integer entry : entries) {
            if (entry == value) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return entries.size() == 0;
    }

    public int size() {
        return entries.size();
    }

    public void clear() {
        entries.clear();
    }

    public boolean equals(DevilSet o) {
        if(entries.size() != o.size()) {
            return false;
        }

        Object[] a = o.toArray();
        Object[] b = this.toArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0; i < a.length; i ++) {
            if(a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public Object[] toArray() {
        return entries.toArray();
    }
}

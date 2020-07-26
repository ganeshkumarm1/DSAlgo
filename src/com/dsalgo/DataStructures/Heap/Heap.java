package DataStructures.Heap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Heap {
    List<Integer> heap;

    // Max Heap
    public Heap(int[] input) {
        this.heap = Arrays.stream(input).boxed().collect(Collectors.toList());
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int largest) {
        int temp = heap.get(i);
        heap.set(i, heap.get(largest));
        heap.set(largest, temp);
    }

    private void heapifyDown(List<Integer> heap, int i) {
        int left = getLeft(i);
        int right = getRight(i);

        int largest = i;

        if(left < heap.size() && heap.get(left) > heap.get(i)) {
            largest = left;
        }

        if(right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if(largest != i) {
            swap(i, largest);
            heapifyDown(heap, largest);
        }
    }

    private void heapifyUp(List<Integer> heap, int i) {
        int parent = getParent(i);

        if(parent >= 0 && heap.get(i) > heap.get(parent)) {
            swap(i, parent);
            heapifyUp(heap, parent);
        }
    }

    public void build() {
        for(int i = heap.size() - 1; i >= 0; i --) {
            heapifyDown(heap, i);
        }
    }

    public void insert(int element) {
        heap.add(element);

        heapifyUp(heap, heap.size() - 1);
    }

    public int getMax() {
        return heap.size() > 0 ? heap.get(0) : -1;
    }

    public int extractMax() {
        if(heap.size() == 0) {
            return -1;
        }

        int max = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapifyDown(heap, 0);

        return max;
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}

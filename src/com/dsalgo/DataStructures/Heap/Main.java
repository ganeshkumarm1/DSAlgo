package DataStructures.Heap;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[] { 10, 5, 3, 7, 2, 6, 1, 9, 8, 4 };

        Heap heap = new Heap(input);
        heap.build();

        System.out.println(heap.toString());

        System.out.println("Extract Max: " + heap.extractMax());
        System.out.println("Extract Max: " + heap.extractMax());
        System.out.println("Extract Max: " + heap.extractMax());

        System.out.println("Insert: " + 11);
        heap.insert(11);
        System.out.println("Insert: " + 12);
        heap.insert(12);
        System.out.println("Insert: " + 8);
        heap.insert(8);

        System.out.println("Extract Max: " + heap.extractMax());
        System.out.println("Extract Max: " + heap.extractMax());

        System.out.println(heap.toString());
    }
}

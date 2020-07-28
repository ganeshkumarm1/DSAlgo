package Algorithms.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[] { 8, 2, 4, 3, 1, 5, 9, 6, 7 };

        MergeSort mergeSort = new MergeSort();

        System.out.println("Input: " + Arrays.toString(input));

        int[] sortedResult = mergeSort.sort(input);

        System.out.println("Output: " + Arrays.toString(sortedResult));
    }
}

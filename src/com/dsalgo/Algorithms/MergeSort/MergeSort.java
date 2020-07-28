package Algorithms.MergeSort;

import java.util.Arrays;

public class MergeSort {
    private void merge(int[] input, int start, int mid, int end) {
        int lLength = (mid - start) + 1;
        int rLength = (end - mid);

        int[] lArray = new int[lLength];
        int[] rArray = new int[rLength];

        for(int i = 0; i < lLength; i ++) {
            lArray[i] = input[start + i];
        }

        for(int i = 0; i < rLength; i ++) {
            rArray[i] = input[mid + 1 + i];
        }


        int i = 0, j = 0;
        int index = start;

        while(i < lLength && j < rLength) {
            if(lArray[i] > rArray[j]) {
                input[index] = rArray[j];
                j ++;
            }
            else {
                input[index] = lArray[i];
                i ++;
            }

            index ++;
        }

        while (i < lLength) {
            input[index] = lArray[i];
            i ++;
            index ++;
        }

        while(j < rLength) {
            input[index] = rArray[j];
            j ++;
            index ++;
        }
    }

    private int[] sortUtil(int[] input, int start, int end) {
        if(start >= end) {
            return input;
        }

        int mid = start + (end - start) / 2;

        sortUtil(input, start, mid);
        sortUtil(input, mid + 1, end);
        merge(input, start, mid, end);

        return input;
    }

    public int[] sort(int[] input) {
        return sortUtil(input, 0, input.length - 1);
    }
}

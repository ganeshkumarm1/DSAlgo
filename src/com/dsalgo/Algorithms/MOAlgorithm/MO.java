package Algorithms.MOAlgorithm;

import utils.InputReader;

import java.io.IOException;
import java.util.*;

class MO {
    public static int BLOCK_SIZE = 0;
    
    public static void main(String[] args) {
        // Problem Statement: https://www.spoj.com/problems/DQUERY/

        final InputReader in = new InputReader(System.in);
        int n = in.readInt();

        int[] array = new int[n];

        for(int i = 0; i < n; i ++) {
            array[i] = in.readInt();
        }

        int q = in.readInt();

        Query[] queries = new Query[q];

        for(int i = 0; i < q; i ++) {
            int l = in.readInt();
            int r = in.readInt();
            queries[i] = new Query(i, l - 1, r - 1);
        }

        BLOCK_SIZE = (int) Math.sqrt(n);

        Arrays.parallelSort(queries);

        int[] answers = new int[q];

        int start = queries[0].l;
        int end = queries[0].l;

        int[] frequencies = new int[1000001];

        frequencies[array[start]] ++;
        int count = 1;

        for(Query query: queries) {
            int l = query.l;
            int r = query.r;
            int i  = query.index;

            while (start < l) {
                frequencies[array[start]] --;
                if(frequencies[array[start]] == 0)
                    count --;
                start ++;
            }

            while (start > l) {
                start --;
                frequencies[array[start]] ++;
                if(frequencies[array[start]] == 1)
                    count ++;
            }

            while (end < r) {
                end ++;
                frequencies[array[end]] ++;
                if(frequencies[array[end]] == 1)
                    count ++;
            }

            while(end > r) {
                frequencies[array[end]] --;
                if(frequencies[array[end]] == 0)
                    count --;
                end --;
            }

            answers[i] = count;
        }

        StringBuilder ans = new StringBuilder();
        for (int answer : answers) {
            ans.append(answer).append("\n");
        }

        System.out.println(ans.toString());
    }
}

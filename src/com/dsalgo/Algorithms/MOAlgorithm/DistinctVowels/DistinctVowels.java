package Algorithms.MOAlgorithm.DistinctVowels;

import utils.InputReader;

import java.util.Arrays;

public class DistinctVowels {
    public static int BLOCK_SIZE = 0;

    public static boolean isVowel(Character c) {
        final String vowels = "aeiou";
        return vowels.indexOf(c) >= 0;
    }

    public static void main(String[] args) {
        final InputReader in = new InputReader(System.in);

        char[] array = new char[] {'m', 'e', 'd', 'i', 'u', 'm', 'i', 's', 'g', 'o', 'o', 'd'};
        int n = array.length;


        Query1[] queries = new Query1[] {
                new Query1(0,4, 9),
                new Query1(0,3, 7),
                new Query1(0,2, 8),
                new Query1(0,0, 5),
                new Query1(0,7, 10),
                new Query1(0,1, 11),
        };
        int q = queries.length;

        for(int i = 0; i < q; i ++) {
            queries[i].index = i;
        }

        BLOCK_SIZE = (int) Math.sqrt(n);

        Arrays.parallelSort(queries);

        int[] answers = new int[q];

        int start = queries[0].l;
        int end = queries[0].l;

        int vowelsCount = isVowel(array[start]) ? 1 : 0;

        for(Query1 query: queries) {
            int l = query.l;
            int r = query.r;
            int i  = query.index;

            while (start < l) {
                if(isVowel(array[start]))
                    vowelsCount --;
                start ++;
            }

            while (start > l) {
                start --;
                if(isVowel(array[start]))
                    vowelsCount ++;
            }

            while (end < r) {
                end ++;
                if(isVowel(array[end]))
                    vowelsCount ++;
            }

            while(end > r) {
                if(isVowel(array[end]))
                    vowelsCount --;
                end --;
            }

            answers[i] = vowelsCount;
        }

        StringBuilder ans = new StringBuilder();
        for (int answer : answers) {
            ans.append(answer).append("\n");
        }

        System.out.println(ans.toString());
    }
}

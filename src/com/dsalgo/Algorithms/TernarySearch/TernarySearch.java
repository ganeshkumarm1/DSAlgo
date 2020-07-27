package Algorithms.TernarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TernarySearch {
    public static long f(long x){
        return (2 * x * x) - (12 * x) + 7;
    }

    public static long ternarySearch(long l, long r) {
        while(r - l >= 3) {
            long m1 = l + (r - l) / 3;
            long m2 = r - (r - l) / 3;

            long f1 = f(m1);
            long f2 = f(m2);

            if(f1 < f2) {
                r = m2;
            }
            else {
                l = m1;
            }
        }

        if(l == r) {
            return f(l);
        }
        else if(l + 1 == r) {
            return Math.min(f(l), f(r));
        }
        else {
            return Math.min(f(l), Math.min(f(l + 1), f(l + 2)));
        }
    }

    public static void main(String[] args) throws IOException {
        // Problem: https://www.hackerearth.com/practice/algorithms/searching/ternary-search/practice-problems/algorithm/solve-with-ternary-search/description/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n -- > 0) {
            String[] row = br.readLine().split("\\s+");
            long l = Long.parseLong(row[0]);
            long r = Long.parseLong(row[1]);

            System.out.println(ternarySearch(l, r));
        }
    }
}

package Algorithms.WindowSlidingTechnique;

public class WindowSliding {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int newSum = 0;
        int actualSatisfiedCustomers = 0;

        for(int i = 0; i < customers.length; i ++) {
            actualSatisfiedCustomers += grumpy[i] == 0 ? customers[i] : 0;
        }

        for(int i = 0; i < X; i ++) {
            newSum += grumpy[i] == 1 ? customers[i] : 0;
        }

        int maxNonGrumpyCustomers = newSum;

        for(int i = 1; i < customers.length - X + 1; i ++) {
            newSum -= grumpy[i - 1] == 1 ? customers[i - 1] : 0;
            newSum += grumpy[i + X - 1] == 1 ? customers[i + X - 1] : 0;

            if(newSum  >= maxNonGrumpyCustomers) {
                maxNonGrumpyCustomers = newSum;
            }
        }

        return actualSatisfiedCustomers + maxNonGrumpyCustomers;
    }

    public static void main(String[] args) {
        // Problem Statment: https://leetcode.com/problems/grumpy-bookstore-owner/

        int[] customers = new int[] {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[] {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;

        System.out.println("The maximum customers that can be satisfied are " + maxSatisfied(customers, grumpy, X));

    }
}

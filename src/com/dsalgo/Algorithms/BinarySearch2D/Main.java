package Algorithms.BinarySearch2D;

public class Main {
    public static void check(int input, BinarySearch2D binarySearch2D) {
        int[] result = binarySearch2D.search(input);

        if(result[0] == -1 || result[1] == -1) {
            System.out.println("The input " + input + " could not be found in the matrix");
        }
        else {
            System.out.println("The input " + input + " is can be found in [" + result[0] + " ," + result[1] + "]");
        }
    }

    public static void main(String[] args) {
        int[][] matrix =  {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };

        BinarySearch2D binarySearch2D = new BinarySearch2D(matrix);

        check(1, binarySearch2D);
        check(5, binarySearch2D);
        check(0, binarySearch2D);
        check(25, binarySearch2D);
        check(16, binarySearch2D);
        check(100, binarySearch2D);
    }
}

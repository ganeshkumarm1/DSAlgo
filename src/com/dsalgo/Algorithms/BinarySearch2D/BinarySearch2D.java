package Algorithms.BinarySearch2D;

public class BinarySearch2D {
    int[][] matrix;
    int rows;
    int columns;

    public BinarySearch2D(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.columns = matrix[0].length;
    }

    public int[] search(int value) {
        int column = columns - 1;
        int row = 0;


        while(row < rows && column >= 0) {
            if (value == matrix[row][column]) {
                return new int[] { row, column };
            }
            else if (value > matrix[row][column]) {
                row ++;
            }
            else {
                column --;
            }
        }

        return new int[] { -1, -1 };
    }
}

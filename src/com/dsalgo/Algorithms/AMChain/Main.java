package Algorithms.AMChain;

public class Main {
    public static void main(String[] args) {
        // Problem Statement: https://leetcode.com/problems/erect-the-fence/

        Point[] points = new Point[] {
                new Point(1, 0),
                new Point(2, 0),
                new Point(1, 1),
                new Point(1, 2),
                new Point(1, 3),
        };


        AMChain amChain = new AMChain(points);
        Point[] boundingPoints = amChain.findBoundingPoints();

        System.out.println("The bounding points of Convex Hull are:");
        for (Point boundingPoint : boundingPoints) {
            System.out.println(boundingPoint.x + ", " + boundingPoint.y);
        }
    }
}

package Algorithms.GrahamScan;

public class Main {
    public static void main(String[] args) {
        // Problem Statement: https://leetcode.com/problems/erect-the-fence/

        Point[] points = new Point[] {
                new Point(0, 0),
                new Point(0, 1),
                new Point(0, 2),
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 2),
                new Point(3, 1),
                new Point(3, 0),
                new Point(2, 0),
                new Point(1, 0),
                new Point(1, 1),
                new Point(4, 3),
        };

        ConvexHull convexHull = new ConvexHull(points);
        Point[] boundingPoints = convexHull.findBoundingPoints();

        System.out.println("The bounding points of Convex Hull are:");
        for (Point boundingPoint : boundingPoints) {
            System.out.println(boundingPoint.x + ", " + boundingPoint.y);
        }
    }
}

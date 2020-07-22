package Algorithms.AMChain;

import java.util.Arrays;
import java.util.Stack;

public class AMChain {
    Point[] points;
    int totalPoints;

    public AMChain(Point[] points) {
        this.points = points;
        this.totalPoints = points.length;
    }

    public  boolean isEqual(Point a, Point b) {
        return (a.x == b.x) && (a.y == b.y);
    }

    public int calcOrientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    public void sortPoints() {
        Arrays.sort(points, (p, q) -> (p.x < q.x) || ((p.x == q.x) && (p.y < q.y)) ? -1 : 1);
    }

    public Point[] stackToPoints(Stack<Point> stack) {
        Point[] pts = new Point[stack.size()];

        for(int i = 0; i < stack.size(); i ++) {
            pts[i] = stack.get(i);
        }

        return pts;
    }

    public Point[] findLowerHull() {
        Stack<Point> lower = new Stack<>();
        
        for(int i = totalPoints - 1; i >= 0; i --) {
            int lowerSize = lower.size();

            int bottom = lowerSize - 2;
            int middle = lowerSize - 1;

            while (lowerSize > 1 && (calcOrientation(lower.get(bottom), lower.get(middle), points[i]) < 0)) {
                lower.pop();

                lowerSize = lower.size();
                bottom = lowerSize - 2;
                middle = lowerSize - 1;
            }

            lower.push(points[i]);
        }

        return stackToPoints(lower);
    }

    public Point[] findUpperHull() {
        Stack<Point> upper = new Stack<>();

        for(int i = 0; i < totalPoints; i ++) {
            int upperSize = upper.size();

            int bottom = upperSize - 2;
            int middle = upperSize - 1;

            while (upperSize > 1 && (calcOrientation(upper.get(bottom), upper.get(middle), points[i]) < 0)) {
                upper.pop();
                upperSize = upper.size();
                bottom = upperSize - 2;
                middle = upperSize - 1;
            }

            upper.push(points[i]);
        }

        return stackToPoints(upper);
    }

    public boolean isCollinear(Point[] lowerHull, Point[] upperHull) {
        return (points.length == 1) || (isEqual(upperHull[1], lowerHull[lowerHull.length - 2]));
    }

    public Point[] removeDuplicatePoints(Point[] lowerHull, Point[] upperHull) {
        Point[] boundingPoints = new Point[lowerHull.length + upperHull.length - 2];
        int bpIndex = 0;

        for(int i = 0; i < lowerHull.length - 1; i ++) {
            boundingPoints[bpIndex] = lowerHull[i];
            bpIndex ++;
        }

        for(int i = 0; i < upperHull.length - 1; i ++) {
            boundingPoints[bpIndex] = upperHull[i];
            bpIndex ++;
        }

        return boundingPoints;
    }

    public Point[] findBoundingPoints() {
        sortPoints();

        Point[] lowerHull = findLowerHull();
        Point[] upperHull = findUpperHull();

        if(isCollinear(lowerHull, upperHull)) {
            return upperHull;
        }

        return removeDuplicatePoints(lowerHull, upperHull);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Point point: points) {
            sb.append("x: ").append(point.x).append(" ").append("y: ").append(point.y).append("\n");
        }

        return sb.toString();
    }
}

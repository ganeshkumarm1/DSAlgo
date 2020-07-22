package Algorithms.GrahamScan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class GrahamScan {
    Point[] points;
    int totalPoints;

    public GrahamScan(Point[] points) {
        this.points = points;
        this.totalPoints = points.length;
    }

    public int calcDistance(Point p, Point q) {
        return ((q.x - p.x) * (q.x - p.x)) + ((q.y - p.y) * (q.y - p.y));
    }

    public int calcOrientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    public void findBottomLeftPoint() {
        Point bottomLeftPoint = new Point(points[0].x, points[0].y);
        int minIndex = 0;

        for(int i = 1; i < points.length; i ++) {
            Point currPoint = points[i];

            if((currPoint.y < bottomLeftPoint.y) || (currPoint.y == bottomLeftPoint.y && currPoint.x < bottomLeftPoint.x)) {
                bottomLeftPoint = currPoint;
                minIndex = i;
            }
        }

        if(minIndex != 0) {
            // Swap 2 points
            int tempX = points[0].x;
            int tempY = points[0].y;

            points[0].x = points[minIndex].x;
            points[0].y = points[minIndex].y;

            points[minIndex].x = tempX;
            points[minIndex].y = tempY;
        }
    }

    public void sortPointsByPolarAngle() {
        Arrays.sort(points, new Comparator<>() {
            final Point bottomLeftPt = points[0];

            @Override
            public int compare(Point p, Point q) {
                int orientation = calcOrientation(p, bottomLeftPt, q);
                int distance = calcDistance(p, bottomLeftPt) - calcDistance(q, bottomLeftPt);

                return orientation == 0 ? distance : orientation;
            }
        });

        Point p = points[0];
        Point q = points[points.length - 1];
        int i = points.length - 2;

        while (i >= 0 && calcOrientation(p, q, points[i]) == 0) {
            i --;
        }

        for (int l = i + 1, r = points.length - 1; l < r; l++, r--) {
            Point tmp = points[l];
            points[l] = points[r];
            points[r] = tmp;
        }
    }

    public Point[] addPointsToConvexHull() {
        Stack<Point> stack = new Stack<>();

        stack.push(points[0]);
        stack.push(points[1]);


        for(int i = 2; i < totalPoints; i ++) {

            Point top = stack.pop();

            while (calcOrientation(stack.peek(), top, points[i]) < 0)
                top=stack.pop();
            stack.push(top);
            stack.push(points[i]);

        }

        Point[] boundingPoints = new Point[stack.size()];

        for(int i = 0; i < stack.size(); i ++) {
            boundingPoints[i] = stack.get(i);
        }

        return boundingPoints;
    }

    public Point[] findBoundingPoints() {
        findBottomLeftPoint();
        sortPointsByPolarAngle();

        return addPointsToConvexHull();
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

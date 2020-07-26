package Algorithms.DDALineDrawingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class DDA {
    public int findDelta(int a, int b) {
        return Math.abs(a - b);
    }

    public float findIncrement(int delta, int steps) {
        return (float) delta / steps;
    }

    public List<Point> draw(Point p, Point q) {
        List<Point> points = new ArrayList<>();

        int x1 = p.x;
        int y1 = p.y;

        int x2 = q.x;
        int y2 = q.y;

        int deltaX = findDelta(x2, x1);
        int deltaY = findDelta(y2, y1);

        int steps = Math.max(deltaX, deltaY);

        float xIncrement = findIncrement(deltaX, steps);
        float yIncrement = findIncrement(deltaY, steps);

        float x = (float) x1;
        float y = (float) y1;

        for(int i = 0; i <= steps; i ++) {
            points.add(
                new Point(
                    Math.round(x),
                    Math.round(y)
                )
            );

            x += xIncrement;
            y += yIncrement;
        }

        return points;
    }
}

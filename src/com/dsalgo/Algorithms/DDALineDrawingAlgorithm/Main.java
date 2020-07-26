package Algorithms.DDALineDrawingAlgorithm;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point p = new Point(5, 4);
        Point q = new Point(12, 7);

        DDA dda = new DDA();

        List<Point> points = dda.draw(p, q);

        System.out.println("The points between (" + p.x + ", " + p.y + ") and (" + q.x + ", " + q.y + ") are");

        for(Point point: points) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }
}

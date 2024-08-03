package algo.practice.v1.maths;

/**
 * The type Point
 *
 * @author Mohd Nadeem
 */
public class Point {

    private static Point emptyPoint;

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point empty() {
        if (emptyPoint == null) {
            emptyPoint = new Point(-1, -1);
        }
        return emptyPoint;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

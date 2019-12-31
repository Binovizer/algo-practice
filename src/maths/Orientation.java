package maths;

/**
 * The type Orientation
 *
 * @author Mohd Nadeem
 */
public class Orientation {

    public String findOrientation(Point p1, Point p2, Point p3) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        int x3 = p3.getX();
        int y3 = p3.getY();
        int out = (y2 - y1) * (x3 - x2) - (y3 - y2) * (x2 - x1);
        if (out == 0) {
            return "Collinear";
        } else if (out < 0) {
            return "Counter Clockwise";
        } else {
            return "Clockwise";
        }
    }
}

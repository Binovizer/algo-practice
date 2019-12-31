package maths;

/**
 * The type OverlapRectangles
 *
 * @author Mohd Nadeem
 */
public class OverlapRectangles {

    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // Left of other rectangle
        if (l1.getX() > r2.getX() || l2.getX() > r1.getX()) {
            return false;
        }
        return l1.getY() >= r2.getY() && l2.getY() >= r1.getY();
    }
}

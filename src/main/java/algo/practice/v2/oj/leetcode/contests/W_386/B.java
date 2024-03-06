package algo.practice.v2.oj.leetcode.contests.W_386;

/**
 * The type B
 *
 * <p>
 *     <a href="https://leetcode.com/contest/weekly-contest-386/problems/find-the-largest-area-of-square-inside-two-rectangles/">Problem Link</a>
 * </p>
 *
 * @author nadeem Date : 27/02/24
 */
public class B {
    public long largestSquareArea(int[][] bottomLeftCoordinates, int[][] topRightCoordinates) {
        int maxSideLength = 0; // Initialize the maximum side length of the largest square
        int numberOfRectangles = bottomLeftCoordinates.length; // Get the number of rectangles

        // Loop through all pairs of rectangles
        for (int i = 0; i < numberOfRectangles; i++) {
            int[] currentBottomLeft = bottomLeftCoordinates[i];
            int[] currentTopRight = topRightCoordinates[i];

            for (int j = i + 1; j < numberOfRectangles; j++) {
                int[] nextBottomLeft = bottomLeftCoordinates[j];
                int[] nextTopRight = topRightCoordinates[j];

                // Check if rectangles overlap on x-axis
                if (nextBottomLeft[0] >= currentTopRight[0]
                        || nextTopRight[0] <= currentBottomLeft[0])
                    continue; // Rectangles don't overlap, move to the next pair

                // Check if rectangles overlap on y-axis
                if (nextTopRight[1] <= currentBottomLeft[1]
                        || nextBottomLeft[1] >= currentTopRight[1])
                    continue; // Rectangles don't overlap, move to the next pair

                // Calculate overlapping area
                int overlapStartX = Math.max(currentBottomLeft[0], nextBottomLeft[0]);
                int overlapStartY = Math.max(currentBottomLeft[1], nextBottomLeft[1]);
                int overlapEndX = Math.min(currentTopRight[0], nextTopRight[0]);
                int overlapEndY = Math.min(currentTopRight[1], nextTopRight[1]);
                int overlapWidth = overlapEndX - overlapStartX;
                int overlapHeight = overlapEndY - overlapStartY;

                // Update maxSideLength with the maximum side length of a square
                maxSideLength = Math.max(maxSideLength, Math.min(overlapWidth, overlapHeight));
            }
        }

        // Return the area of the largest square found
        return (long) maxSideLength * maxSideLength;
    }
}

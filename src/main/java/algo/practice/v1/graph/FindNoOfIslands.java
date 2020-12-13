package algo.practice.v1.graph;

import algo.practice.v1.maths.Point;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type FindNoOfIslands
 *
 * @author Mohd Nadeem
 */
public class FindNoOfIslands {

    private static final int[] xMoves = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] yMoves = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        int[][] matrix =
                new int[][] {
                    {1, 0, 0, 1},
                    {0, 1, 0, 0},
                    {1, 0, 0, 1}
                };
        FindNoOfIslands findNoOfIslands = new FindNoOfIslands();
        int noOfIslands = findNoOfIslands.findNoOfIslands(matrix);
        System.out.println("noOfIslands = " + noOfIslands);
    }

    private int findNoOfIslands(int[][] matrix) {
        int count = 0;
        Point point = findStartPoint(matrix);
        while (point.getX() != -1 && point.getY() != -1) {
            bfs(matrix, point);
            point = findStartPoint(matrix);
            count++;
        }
        return count;
    }

    private void bfs(int[][] matrix, Point point) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        while (!q.isEmpty()) {
            Point poll = q.poll();
            int x = poll.getX();
            int y = poll.getY();
            matrix[x][y] = 2;
            for (int i = 0; i < xMoves.length; i++) {
                int currX = x + xMoves[i];
                int currY = y + yMoves[i];
                if (isValid(matrix, currX, currY) && matrix[currX][currY] == 1) {
                    q.offer(new Point(currX, currY));
                }
            }
        }
    }

    private boolean isValid(int[][] matrix, int currX, int currY) {
        return (currX >= 0 && currY >= 0 && currY < matrix[0].length && currX < matrix.length);
    }

    private Point findStartPoint(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    return new Point(i, j);
                }
            }
        }
        return Point.empty();
    }
}

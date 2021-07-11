package algo.practice.v2.oj.leetcode.general;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * @author Nadeem 2021-03-06
 */
public class KClosestPoints {

    public int[][] kClosest(int[][] points, int k) {
        if (k >= points.length) {
            return points;
        }
        PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            Point p = new Point(x, y);
            p.d = x * x + y * y;
            q.add(p);
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point poll = q.poll();
            ans[i][0] = poll.x;
            ans[i][1] = poll.y;
        }
        return ans;
    }

    static class Point {
        int x;
        int y;
        int d; // distance from origin

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setD(int d) {
            this.d = d;
        }
    }
}

package algo.practice.v2.oj.leetcode.contests.W_387;

/**
 * The type A
 *
 * <p><a
 * href="https://leetcode.com/contest/weekly-contest-387/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/">Problem
 * Link</a>
 *
 * @author nadeem Date : 07/03/24
 */
public class B {

    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] pre = new int[n][m];

        int ans = 0;
        int rowSum;
        for (int i = 0; i < n; i++) {
            rowSum = 0;
            for (int j = 0; j < m; j++) {
                int top = (i > 0) ? pre[i - 1][j] : 0;
                pre[i][j] = grid[i][j] + top + rowSum;
                if (pre[i][j] <= k) ans++;
                rowSum += grid[i][j];
            }
        }
        return ans;
//        int n = grid.length;
//        int m = grid[0].length;
//
//        int[] prev = new int[m];
//        int[] curr = new int[m];
//
//        int ans = 0;
//        int rowSum;
//        for (int i = 0; i < n; i++) {
//            rowSum = 0;
//            for (int j = 0; j < m; j++) {
//                int top = (i > 0) ? prev[j] : 0;
//                curr[j] = grid[i][j] + top + rowSum;
//                if (curr[j] <= k) ans++;
//                rowSum += grid[i][j];
//            }
//            prev = curr;
//        }
//        return ans;
    }
}

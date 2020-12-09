package algo.interview.dp.leetcode;

import algo.interview.utils.ArrayUtil;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-10
 */
public class UniquePaths {

    private int[][] dp;

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int paths = uniquePaths.uniquePaths(3, 7);
        System.out.println("paths = " + paths);
    }

    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        ArrayUtil.fill2DArray(dp, -1);
        return uniquePathsMemo(0, 0, m, n);
    }

    private int uniquePaths(int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        return uniquePaths(i + 1, j, m, n) + uniquePaths(i, j + 1, m, n);
    }

    private int uniquePathsMemo(int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = uniquePathsMemo(i + 1, j, m, n) + uniquePathsMemo(i, j + 1, m, n);
    }

    private int uniquePathsBottomUp(int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = uniquePathsMemo(i + 1, j, m, n) + uniquePathsMemo(i, j + 1, m, n);
    }
}

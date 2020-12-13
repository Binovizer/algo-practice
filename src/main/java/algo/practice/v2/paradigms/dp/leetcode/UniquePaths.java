package algo.practice.v2.paradigms.dp.leetcode;

import algo.practice.v2.utils.ArrayUtil;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-10
 */
public class UniquePaths {

    private int[][] dp;

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        UniquePaths uniquePaths = new UniquePaths();
        int paths = uniquePaths.uniquePathsBottomUp(m, n);
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

    private int uniquePathsBottomUp(int m, int n) {
        int[][] dp = new int[m][n];
        // Initialization
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

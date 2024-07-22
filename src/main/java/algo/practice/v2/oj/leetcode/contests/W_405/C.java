package algo.practice.v2.oj.leetcode.contests.W_405;

/**
 * The type C
 *
 * @author nadeem Date : 08/07/24
 */
public class C {

    public static void main(String[] args) {}

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] hasX = new boolean[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int current = getCurrent(grid, i, j);
                if (current == 1) {
                    hasX[i][j] = true;
                }
                if (i > 0 && j > 0) {
                    current -= dp[i - 1][j - 1];
                    hasX[i][j] = hasX[i][j] || hasX[i - 1][j] || hasX[i][j - 1];
                }
                if (i > 0) {
                    current += dp[i - 1][j];
                    hasX[i][j] = hasX[i][j] || hasX[i - 1][j];
                }
                if (j > 0) {
                    current += dp[i][j - 1];
                    hasX[i][j] = hasX[i][j] || hasX[i][j - 1];
                }
                dp[i][j] = current;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == 0 && hasX[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static int getCurrent(char[][] grid, int i, int j) {
        if (grid[i][j] == 'X') return 1;
        if (grid[i][j] == 'Y') return -1;
        return 0;
    }
}

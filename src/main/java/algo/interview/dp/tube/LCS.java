package algo.interview.dp.tube;

import algo.interview.utils.ArrayUtil;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-03
 */
public class LCS {

    private static int[][] dp = new int[100][100];

    {
        ArrayUtil.fill2DArray(dp, -1);
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        LCS lcs = new LCS();
        int lcsLength = lcs.lcsBottomUp(s1, s2, s1.length(), s2.length());
        System.out.println("lcsLength = " + lcsLength);
    }

    private int lcs(String X, String Y, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (X.charAt(n - 1) == Y.charAt(m - 1)) {
            return 1 + lcs(X, Y, n - 1, m - 1);
        } else {
            return Math.max(lcs(X, Y, n - 1, m), lcs(X, Y, n, m - 1));
        }
    }

    private int lcsMemoized(String X, String Y, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (X.charAt(n - 1) == Y.charAt(m - 1)) {
            dp[n][m] = 1 + lcs(X, Y, n - 1, m - 1);
        } else {
            dp[n][m] = Math.max(lcs(X, Y, n - 1, m), lcs(X, Y, n, m - 1));
        }
        return dp[n][m];
    }

    private int lcsBottomUp(String X, String Y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}

package algo.interview.dp;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-03
 */
public class LCSS {

    public static void main(String[] args) {
        String X = "abcde";
        String Y = "abfce";
        LCSS LCSS = new LCSS();
        int lcs = LCSS.longestCommonSubstring(X, Y, X.length(), Y.length());
        System.out.println("lcs = " + lcs);
    }

    private int longestCommonSubstring(String X, String Y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int result = Integer.MIN_VALUE;
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
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }
}

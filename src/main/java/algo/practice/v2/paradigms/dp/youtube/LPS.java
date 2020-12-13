package algo.practice.v2.paradigms.dp.youtube;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-04
 */
public class LPS {

    public static void main(String[] args) {
        String X = "agbcba";
        LPS lps = new LPS();
        int longestPalindromicSubsequence = lps.lps(X);
        System.out.println("longestPalindromicSubsequence = " + longestPalindromicSubsequence);
    }

    private int lps(String X) {
        return lcs(X, new StringBuilder(X).reverse().toString());
    }

    private int lcs(String X, String Y) {
        int n = X.length();
        int m = Y.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}

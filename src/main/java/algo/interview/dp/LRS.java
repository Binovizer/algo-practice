package algo.interview.dp;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-04
 */
public class LRS {

    public static void main(String[] args) {
        String X = "AABEBCDD";
        LRS LRS = new LRS();
        int lrs = LRS.lrs(X);
        System.out.println("lrs = " + lrs);
    }

    private int lrs(String X) {
        return modifiedLCS(X, X);
    }

    private int modifiedLCS(String X, String Y) {
        int n = X.length();
        int m = Y.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1) && (i != j)) { // Can't select the same element in both strings
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}

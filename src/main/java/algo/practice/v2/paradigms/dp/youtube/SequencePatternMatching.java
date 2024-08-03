package algo.practice.v2.paradigms.dp.youtube;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-05
 */
public class SequencePatternMatching {

    public static void main(String[] args) {
        String A = "AXY";
        String B = "ADXCPY";
        SequencePatternMatching sequencePatternMatching = new SequencePatternMatching();
        boolean isMatching = sequencePatternMatching.match(A, B);
        System.out.println("isMatching = " + isMatching);
    }

    private boolean match(String A, String B) {
        return lcs(A, B) == A.length();
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

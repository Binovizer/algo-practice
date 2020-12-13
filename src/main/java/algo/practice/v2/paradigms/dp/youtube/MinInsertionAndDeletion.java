package algo.practice.v2.paradigms.dp.youtube;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-04
 */
public class MinInsertionAndDeletion {

    public static void main(String[] args) {
        String X = "heap";
        String Y = "pea";
        MinInsertionAndDeletion obj = new MinInsertionAndDeletion();
        int[] minInsertionAndDeletion = obj.minInsertionAndDeletion(X, Y);
        System.out.println("Min Insertion : " + minInsertionAndDeletion[1]);
        System.out.println("Min Deletion : " + minInsertionAndDeletion[0]);
    }

    private int[] minInsertionAndDeletion(String X, String Y) {
        int lcs = lcs(X, Y);
        return new int[] {X.length() - lcs, Y.length() - lcs};
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

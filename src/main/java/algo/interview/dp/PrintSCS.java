package algo.interview.dp;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-04
 */
public class PrintSCS {

    public static void main(String[] args) {
        String X = "geek";
        String Y = "eke";
        PrintSCS scs = new PrintSCS();
        String shortestCommonSupersequence = scs.shortestCommonSupersequence(X, Y);
        System.out.println("shortestCommonSupersequence = " + shortestCommonSupersequence);
    }

    private String shortestCommonSupersequence(String X, String Y) {
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
        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                sb.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(X.charAt(i - 1));
                i--;
            } else {
                sb.append(Y.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            sb.append(X.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(Y.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }
}

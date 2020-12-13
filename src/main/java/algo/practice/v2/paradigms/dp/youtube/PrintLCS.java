package algo.practice.v2.paradigms.dp.youtube;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-03
 */
public class PrintLCS {

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        PrintLCS printLCS = new PrintLCS();
        String lcs = printLCS.printLCS(X, Y, X.length(), Y.length());
        System.out.println("lcs = " + lcs);
    }

    private String printLCS(String X, String Y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Process
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
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
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return sb.reverse().toString();
    }
}

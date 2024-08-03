package algo.practice.v2.paradigms.dp.youtube;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-03
 */
public class CoinChangeII {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        CoinChangeII coinChange = new CoinChangeII();
        int minNumberOfCoins = coinChange.minNumberOfCoins(coins, sum);
        System.out.println("minNumberOfCoins = " + minNumberOfCoins);
    }

    private int minNumberOfCoins(int[] coins, int sum) {
        return minNumberOfCoins(coins, sum, coins.length);
    }

    private int minNumberOfCoins(int[] coins, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize first row and first columns
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    // -1 so that the int value does not overflow because of adding +1 in process
                    // step
                    dp[i][j] = Integer.MAX_VALUE - 1;
                }
                if (j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Process
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return -1 if not possible
        return dp[n][sum] >= Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
    }
}

package algo.practice.v2.paradigms.dp.youtube;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-03
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        CoinChange coinChange = new CoinChange();
        int noOfWays = coinChange.countWays(coins, sum);
        System.out.println("noOfWays = " + noOfWays);
    }

    private int countWays(int[] arr, int sum) {
        // Unbounded knapsack as coins can be repeated
        // Same as count of subset sum with unbounded version
        return countWays(arr, sum, arr.length);
    }

    private int countWays(int[] coins, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}

package algo.practice.v2.platforms.leetcode.challenges.jan.week1;

/**
 * https://leetcode.com/problems/coin-change-2/
 *
 * @author Nadeem 2021-01-05
 */
public class CoinChange2 {

    private int[][] dp;

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 5;
        CoinChange2 coinChange2 = new CoinChange2();
        int noOfWays = coinChange2.change(amount, coins);
        System.out.println("noOfWays = " + noOfWays);
    }

    public int change(int amount, int[] coins) {
        //        int n = coins.length;
        //        dp = new int[amount + 1][n + 1];
        //        ArrayUtil.fill2DArray(dp, -1);
        //        return change(coins, amount, n);
        return changeDPBottomUp(coins, amount);
    }

    private int change(int[] coins, int W, int n) {
        if (W == 0) {
            return 1;
        }
        if (W < 0) {
            return 0;
        }
        if (n <= 0) {
            return 0;
        }
        if (dp[W][n] != -1) {
            return dp[W][n];
        }
        int op1 = change(coins, W, n - 1);
        int op2 = change(coins, W - coins[n - 1], n);
        return dp[W][n] = op1 + op2;
    }

    private int changeDPBottomUp(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}

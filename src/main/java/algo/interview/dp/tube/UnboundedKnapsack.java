package algo.interview.dp.tube;

import algo.interview.utils.ArrayUtil;

/**
 * This is similar to knapsack01 with the minor difference. In this we can select the item multiple
 * times So, when we are not selecting any element we will not be selecting it again but when we are
 * selecting we can select it again
 *
 * @author Nadeem 2020-11-29
 */
public class UnboundedKnapsack {

    private static int[][] dp;

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        UnboundedKnapsack knapsack = new UnboundedKnapsack();
        int maxProfit = knapsack.knapsack(val, wt, W, val.length);
        System.out.println("maxProfit = " + maxProfit);
    }

    private int knapsack(int[] val, int[] wt, int W, int n) {
        return knapsackDPBottomUp(val, wt, W, n);
    }

    private int knapsackRecursive(int[] val, int[] wt, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            // When Item is selected then don't reduce the size as the item can be selected again
            // hence passed n again in the recursive call.
            return Math.max(
                    val[n - 1] + knapsackRecursive(val, wt, W - wt[n - 1], n),
                    knapsackRecursive(val, wt, W, n - 1));
        } else {
            return knapsackRecursive(val, wt, W, n - 1);
        }
    }

    private int knapsackDP(int[] val, int[] wt, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        ArrayUtil.fill2DArray(dp, -1);
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {
            dp[n][W] =
                    Math.max(
                            val[n - 1] + knapsackDP(val, wt, W - wt[n - 1], n),
                            knapsackDP(val, wt, W, n - 1));
        } else {
            dp[n][W] = knapsackDP(val, wt, W, n - 1);
        }
        return dp[n][W];
    }

    private int knapsackDPBottomUp(int[] val, int[] wt, int W, int n) {
        dp = new int[n + 1][W + 1];

        // initialize dp
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Process
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}

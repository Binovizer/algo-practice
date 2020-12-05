package algo.interview.dp.tube;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-03
 */
public class RodCuttingProblem {

    public static void main(String[] args) {
        // int[] length = {}; // 1 to len always so redundant
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        RodCuttingProblem rodCuttingProblem = new RodCuttingProblem();
        int maxProfit = rodCuttingProblem.maxProfit(price);
        System.out.println("maxProfit = " + maxProfit);
    }

    private int maxProfit(int[] price) {
        int[] lenArr = getLengthArray(price.length);
        return maxProfitUtil(price, lenArr, price.length, price.length);
    }

    private int[] getLengthArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    // Unbounded knapsack
    private int maxProfitUtil(int[] val, int[] wt, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // initialize dp
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Processing
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

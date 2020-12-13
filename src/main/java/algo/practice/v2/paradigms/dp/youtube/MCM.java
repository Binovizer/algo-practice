package algo.practice.v2.paradigms.dp.youtube;

import algo.practice.v2.utils.ArrayUtil;

/**
 * Matrix Chain Multiplication
 *
 * @author Nadeem 2020-12-05
 */
public class MCM {

    private static int[][] dp = new int[100][100];

    static {
        ArrayUtil.fill2DArray(dp, -1);
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        MCM mcm = new MCM();
        int minCost = mcm.minCost(arr);
        System.out.println("minCost = " + minCost);
    }

    private int minCost(int[] arr) {
        return solveMemoized(arr, 1, arr.length - 1);
    }

    private int solve(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            min = Math.min(min, temp);
        }
        return min;
    }

    private int solveMemoized(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp =
                    solveMemoized(arr, i, k)
                            + solveMemoized(arr, k + 1, j)
                            + (arr[i - 1] * arr[k] * arr[j]);
            dp[i][j] = Math.min(dp[i][j], temp);
        }
        return dp[i][j];
    }
}

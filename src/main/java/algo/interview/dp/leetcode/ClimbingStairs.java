package algo.interview.dp.leetcode;

import java.util.Arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-08
 */
public class ClimbingStairs {

    private int[] dp;

    public static void main(String[] args) {
        int n = 5;
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int distinctWays = climbingStairs.distinctWaysV2TopDown(n);
        System.out.println("distinctWays = " + distinctWays);
    }

    private int distinctWays(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return distinctWaysV2Memo(n);
    }

    private int distinctWaysV1(int curr, int n) {
        if (curr > n) {
            return 0;
        }
        if (curr == n) {
            return 1;
        }
        return distinctWaysV1(curr + 1, n) + distinctWaysV1(curr + 2, n);
    }

    private int distinctWaysV2(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return distinctWaysV2(n - 1) + distinctWaysV2(n - 2);
    }

    private int distinctWaysV2Memo(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = distinctWaysV2Memo(n - 1) + distinctWaysV2Memo(n - 2);
    }

    private int distinctWaysV2TopDown(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

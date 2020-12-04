package algo.interview.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-02
 */
public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int sum = 1;
        SubsetSum subsetSum = new SubsetSum();
        int targetSum = subsetSum.targetSum(arr, sum);
        System.out.println("targetSum = " + targetSum);
    }

    // Problem # 1
    private boolean isSubsetPresent(int[] arr, int sum) {
        return isSubsetPresentUtil(arr, sum, arr.length);
    }

    // Problem # 2
    private boolean canPartition(int[] arr) {
        int arraySum = Arrays.stream(arr).sum();
        if ((arraySum & 1) == 1) { // Odd -> Can never be two equal integer parts
            return false;
        }
        return isSubsetPresent(arr, arraySum / 2);
    }

    // Problem # 3
    private int countSubset(int[] arr, int sum) {
        return countSubset(arr, sum, arr.length);
    }

    // Problem # 4
    private int minimumSubsetSum(int[] arr) {
        int range = Arrays.stream(arr).sum();
        int n = arr.length;

        // Subset sum present matrix
        boolean[][] dp = new boolean[n + 1][range + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= range; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Last row of dp contains if subset with column sum is present or not
        ArrayList<Integer> presentSubsetSums = new ArrayList<>();
        for (int j = 1; j <= range / 2; j++) {
            if (dp[n][j]) {
                presentSubsetSums.add(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int sum : presentSubsetSums) {
            min = Math.min(min, range - 2 * sum);
        }
        return min;
    }

    // Problem # 5
    private int countSubsetSumWithDiff(int[] arr, int diff) {
        // Let Sum of subset 1 be S1, subset 2 be S2 and total sum is S then
        // S1 - S2 = diff
        // S1 + S2 = S
        // So, S1 = (diff + S) / 2
        // So, problem now is count all subsets with sum S1
        int S = Arrays.stream(arr).sum();
        int S1 = (diff + S) / 2;
        return countSubset(arr, S1);
    }

    // Problem # 6
    private int targetSum(int[] arr, int sum) {
        // Divide into 2 subsets
        // 1. With all positives
        // 2. With all negatives
        // S1 - S2 = diff
        // Same problem as count minimum subset
        return countSubsetSumWithDiff(arr, sum);
    }

    private boolean isSubsetPresentUtil(int[] arr, int sum, int n) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    private int countSubset(int[] arr, int sum, int n) {
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
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}

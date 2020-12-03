package algo.interview.dp;

import java.util.Arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-02
 */
public class SubsetSum {

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        SubsetSum subsetSum = new SubsetSum();
        int noOfSubsets = subsetSum.countSubset(arr, sum);
        System.out.println("noOfSubsets = " + noOfSubsets);
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

package algo.practice.v2.paradigms.dp.youtube;

import algo.practice.v2.utils.ArrayUtil;

/**
 * Palindrome Partitioning
 *
 * @author Nadeem 2020-12-06
 */
public class PalindromePartitioning {

    private static int[][] dp;

    static {
        dp = new int[100][100];
        ArrayUtil.fill2DArray(dp, -1);
    }

    public static void main(String[] args) {
        String str = "nitik";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        int minPartition = palindromePartitioning.minPalindromePartition(str);
        System.out.println("minPartition = " + minPartition);
    }

    private int minPalindromePartition(String str) {
        return solveMemoOptimized(str.toCharArray(), 0, str.length() - 1);
    }

    private int solve(char[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(arr, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(arr, i, k) + solve(arr, k + 1, j) + 1;
            min = Math.min(temp, min);
        }
        return min;
    }

    private int solveMemo(char[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(arr, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(arr, i, k) + solve(arr, k + 1, j) + 1;
            min = Math.min(temp, min);
        }
        return dp[i][j] = min;
    }

    private int solveMemoOptimized(char[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(arr, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left;
            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = solve(arr, i, k);
            }
            dp[i][k] = left;
            int right;
            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = solve(arr, k + 1, j);
            }
            dp[k + 1][j] = right;
            int temp = left + right + 1;
            min = Math.min(temp, min);
        }
        return dp[i][j] = min;
    }

    private boolean isPalindrome(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

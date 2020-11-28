package algo.interview.recursion.leetcode;

/**
 * This class helps find the nth Tribonacci Number
 * Problem Desc : https://leetcode.com/problems/n-th-tribonacci-number/
 *
 * @author Nadeem 2020-11-25
 */
public class NthTribonacciNumber {

    public static void main(String[] args) {
        NthTribonacciNumber nthTribonacciNumber = new NthTribonacciNumber();
//        int nThTribonacci = nthTribonacciNumber.tribonacci(25);
        int nThTribonacci = nthTribonacciNumber.tribonacciDP(25);
        System.out.println("nThTribonacci = " + nThTribonacci);
    }

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
    }

    public int tribonacciDP(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}

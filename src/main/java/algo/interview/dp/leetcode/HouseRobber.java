package algo.interview.dp.leetcode;

import java.util.Arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-09
 */
public class HouseRobber {

    private int[] dp;

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        int maxRobbery = houseRobber.robTopDown(nums);
        System.out.println("maxRobbery = " + maxRobbery);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return robMemoized(nums, n - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0; // no houses so robbery 0
        }
        if (i == 0) {
            return nums[i]; // single house so rob it
        }
        int op1 = nums[i] + rob(nums, i - 2); // Choose to rob it then can't rob the previous house
        int op2 = rob(nums, i - 1); // Choose not to rob it then can rob the previous house
        return Math.max(op1, op2);
    }

    private int robMemoized(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return nums[i];
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        return dp[i] = Math.max(nums[i] + robMemoized(nums, i - 2), robMemoized(nums, i - 1));
    }

    private int robTopDown(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n + 1];
        // Base case
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[n];
    }
}
